package fr.eni.projet.siteenchere.dal.impl;

import fr.eni.projet.siteenchere.bo.*;
import fr.eni.projet.siteenchere.dal.ArticleDAOInterface;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ArticleDAOSQLImpl implements ArticleDAOInterface {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    final JdbcTemplate jdbcTemplate;

    private final String CREATE_REQUEST = " INSERT INTO `auction`.`articles` " + "(article_name, description, " +
            "bid_start_day, bid_end_day, starting_price, id_user, id_category) " + "values (:articleName, :description, " + ":bidStartDay, :bidEndDay, :startingPrice, :idUser, :idCategory)";
    private final String READ_ID_REQUEST = "SELECT * FROM `auction`.`articles` WHERE id_article = :idArticle";

    private final String READ_USER_REQUEST = "SELECT * FROM `auction`.`articles` WHERE id_user = :idUser";

    private final String UPDATE_REQUEST = "UPDATE `auction`.`articles` " + "SET article_name = :articleName, " +
            "description = :description, " + "bid_start_day = :bidStartDay, " + "bid_end_day = :bidEndDay, " +
            "starting_price = :startingPrice, " + "id_user = :idUser, " + "id_category = :idCategory " + "WHERE id_article "
            + "= :idArticle";

    private final String GET_BY_CATEGORY_REQUEST = "SELECT * FROM articles " +
            "INNER JOIN category  ON articles.id_category = category.id_category " +
            "INNER JOIN users ON articles.id_user" + "= users.id_user " +
            "INNER JOIN withdrawal  ON articles.id_article = withdrawal.id_article " +
            "INNER JOIN bid ON articles.id_article = bid.id_article " +
            "WHERE articles.id_category = :idCategory;";

    public ArticleDAOSQLImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate, JdbcTemplate jdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * @param article (articleName, description, bidStartDay, bidEndDay, startingPrice, idUser, idCategory)
     * @return id of the created article
     */
    @Override
    public Long createArticle(Article article) {
        try {
            GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
            BeanPropertySqlParameterSource namedParameters = new BeanPropertySqlParameterSource(article);
            namedParameterJdbcTemplate.update(CREATE_REQUEST, namedParameters, keyHolder);
            Number key = keyHolder.getKey();
            if (key != null) {
                Long id = key.longValue();
                article.setIdArticle(id);
                return id;
            } else {
                return null;
            }
        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Read an article by its ID.
     *
     * @param idArticle the ID of the article to be read
     * @return the article with the specified ID, or a default article if not found
     * @throws DataAccessException if an error occurs while reading the article
     */
    @Override
    public Article readArticleById(Long idArticle) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource().addValue("idArticle", idArticle);
        try {
            return namedParameterJdbcTemplate.queryForObject(READ_ID_REQUEST, paramSource,
                    new BeanPropertyRowMapper<>(Article.class));
        } catch (EmptyResultDataAccessException e) {
            Article nullArticle = new Article();
            nullArticle.setDescription("Article not found");
            return nullArticle;
        }
    }

    /**
     * Retrieves a list of articles associated with a specific user.
     *
     * @param idUser the ID of the user
     * @return a list of articles associated with the specified user or an empty list if none
     * @throws DataAccessException if an error occurs while retrieving the articles
     */
    @Override
    public List<Article> getArticlesByUser(Long idUser) {
        try {
            return namedParameterJdbcTemplate.query(READ_USER_REQUEST, new MapSqlParameterSource("idUser", idUser),
                    new BeanPropertyRowMapper<>(Article.class));
        } catch (EmptyResultDataAccessException e) {
            return Collections.emptyList();
        }
    }

    public List<Article> getArticleByCategories(Long idCategory) {
        try {
            return namedParameterJdbcTemplate.queryForObject(GET_BY_CATEGORY_REQUEST, new MapSqlParameterSource("idCategory", idCategory), (resulSet, rowNum) -> {
                List<Article> articles = new ArrayList<>();
                while (resulSet.next()) {

                    Category category = new Category();
                    category.setIdCategory(resulSet.getLong("id_category"));
                    category.setCatName(resulSet.getString("cat_name"));

                    Withdrawal withdrawal = new Withdrawal();
                    withdrawal.setRoadName(resulSet.getString("road_name"));
                    withdrawal.setCity(resulSet.getString("city"));
                    withdrawal.setPostalCode(resulSet.getString("postal_code"));

                    User user = new User();
                    user.setIdUser(resulSet.getLong("id_user"));
                    user.setPseudo(resulSet.getString("pseudo"));
                    user.setFirstName(resulSet.getString("firstname"));
                    user.setLastName(resulSet.getString("lastname"));
                    user.setEmail(resulSet.getString("email"));
                    user.setPhone(resulSet.getString("phone"));
                    user.setPersonnalRoadName(resulSet.getString("personnal_road_name"));
                    user.setPersonnalPostalCode(resulSet.getString("personnal_postal_code"));
                    user.setPersonnalCity(resulSet.getString("personnal_city"));
                    user.setCredit(resulSet.getLong("credit"));
                    user.setAdmin(resulSet.getBoolean("admin"));
                    user.setWithdrawal(withdrawal);

                    Article article = new Article();
                    article.setIdArticle(resulSet.getLong("id_article"));
                    article.setArticleName(resulSet.getString("article_name"));
                    article.setDescription(resulSet.getString("description"));
                    article.setStartingPrice(resulSet.getInt("starting_price"));
                    article.setBidStartDay(resulSet.getDate("bid_start_day"));
                    article.setBidEndDay(resulSet.getDate("bid_end_day"));
                    article.setIdUser(user.getIdUser());
                    article.setUser(user);
                    article.setIdCategory(category.getIdCategory());
                    article.setCategory(category);
                    article.setWithdrawal(withdrawal);

                    Bid bid = new Bid();
                    bid.setBidDate(resulSet.getDate("bid_date"));
                    bid.setBidAmount(resulSet.getInt("bid_amount"));
                    bid.setUser(user);
                    bid.setArticle(article.getIdArticle());
                    boolean bool = false;
                    if (articles.isEmpty()) {
                        article.addBid(bid);
                        articles.add(article);
                    } else {
                        for (Article art : articles) {
                            if (art.getIdArticle().equals(article.getIdArticle())) {
                                art.addBid(bid);
                                bool = true;
                            }
                        }
                        if (!bool) {
                                article.addBid(bid);
                                articles.add(article);
                        }
                    }
                }
                return articles;
            });
//        Article{
//            idArticle=1,
//            articleName = 'Article Electronique',
//            description='Un article électronique',
//            bidStartDay=2024-01-01,
//            bidEndDay=2024-01-10,
//            startingPrice=100,
//            finalPrice=null,
//            sellingStatus='null',
//            idUser=1,
//            user = User{
//                idUser=1, pseudo='jdupont', lastName='Dupont', firstName='Jean', email='jdupont@gmail.com', phone='0123456789', roadName='1 rue de Paris', postalCode='75001', city='Paris', password='null', admin=false, salesList=[], purchasedItemsList=[], currentBid=[]},
//            idCategory=1,
//            category = Category { idCategory=1, catName='Electronique', articleCategorys=[]},
//            withdrawal= Withdrawal{roadName='Rue de la Liberté', postalCode='75001', city='Paris', articles=null},
//            currentBid = [
//                    Bid{bidDate=2024-03-01, bidAmount=75, article=1, user = User{idUser=1, pseudo='jdupont', lastName='Dupont', firstName='Jean', email='jdupont@gmail.com', phone='0123456789', roadName='1 rue de Paris', postalCode='75001', city='Paris', password='null', admin=false, salesList=[],purchasedItemsList=[],currentBid=[]}},
//                    Bid{bidDate=2024-03-01, bidAmount=60, article=1, user=User{idUser=1, pseudo='jdupont', lastName='Dupont', firstName='Jean', email='jdupont@gmail.com', phone='0123456789', roadName='1 rue de Paris', postalCode='75001', city='Paris', password='null', admin=false, salesList=[], purchasedItemsList=[], currentBid=[]}},
//                    Bid{bidDate=2024-03-01, bidAmount=90, article=1, user=User{idUser=1, pseudo='jdupont', lastName='Dupont', firstName='Jean', email='jdupont@gmail.com', phone='0123456789', roadName='1 rue de Paris', postalCode='75001', city='Paris', password='null', admin=false, salesList=[], purchasedItemsList=[], currentBid=[]}},
//                    Bid{bidDate=2024-03-01, bidAmount=70, article=1, user=User{idUser=1, pseudo='jdupont', lastName='Dupont', firstName='Jean', email='jdupont@gmail.com', phone='0123456789', roadName='1 rue de Paris', postalCode='75001', city='Paris', password='null', admin=false, salesList=[], purchasedItemsList=[], currentBid=[]}},
//                    Bid{bidDate=2024-03-01, bidAmount=55, article=1, user=User{idUser=1, pseudo='jdupont', lastName='Dupont', firstName='Jean', email='jdupont@gmail.com', phone='0123456789', roadName='1 rue de Paris', postalCode='75001', city='Paris', password='null', admin=false, salesList=[], purchasedItemsList=[], currentBid=[]}},
//                    Bid{bidDate=2024-03-01, bidAmount=80, article=1, user=User{idUser=1, pseudo='jdupont', lastName='Dupont', firstName='Jean', email='jdupont@gmail.com', phone='0123456789', roadName='1 rue de Paris', postalCode='75001', city='Paris', password='null', admin=false, salesList=[], purchasedItemsList=[], currentBid=[]}},
//                    Bid{bidDate=2024-03-01, bidAmount=65, article=1, user=User{idUser=1, pseudo='jdupont', lastName='Dupont', firstName='Jean', email='jdupont@gmail.com', phone='0123456789', roadName='1 rue de Paris', postalCode='75001', city='Paris', password='null', admin=false, salesList=[], purchasedItemsList=[], currentBid=[]}},
//                    Bid{bidDate=2024-03-01, bidAmount=85, article=1, user=User{idUser=1, pseudo='jdupont', lastName='Dupont', firstName='Jean', email='jdupont@gmail.com', phone='0123456789', roadName='1 rue de Paris', postalCode='75001', city='Paris', password='null', admin=false, salesList=[], purchasedItemsList=[], currentBid=[]}},
//                    Bid{bidDate=2024-03-01, bidAmount=95, article=1, user=User{idUser=1, pseudo='jdupont', lastName='Dupont', firstName='Jean', email='jdupont@gmail.com', phone='0123456789', roadName='1 rue de Paris', postalCode='75001', city='Paris', password='null', admin=false, salesList=[], purchasedItemsList=[], currentBid=[]}}
//        ]}
        } catch (EmptyResultDataAccessException e) {
            return Collections.emptyList();
        }
    }

    /**
     * Update an article in the database.
     *
     * @param article the article to be updated
     * @throws DataAccessException if an error occurs while updating the article
     */
    @Override
    public void updateArticle(Article article) {
        try {
            Article oldArticle = readArticleById(article.getIdArticle());
            if (oldArticle.getIdArticle() == null) {
                throw new EmptyResultDataAccessException("Article not found", 1);
            } else {
                if (!article.equals(oldArticle)) {
                    try {
                        BeanPropertySqlParameterSource namedParameters = new BeanPropertySqlParameterSource(article);
                        namedParameterJdbcTemplate.update(UPDATE_REQUEST, namedParameters);
                    } catch (DataAccessException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Deletes an article from the database.
     *
     * @param idArticle the ID of the article to be deleted
     * @throws DataAccessException if an error occurs while deleting the article
     */

    @Override
    public void deleteArticle(Long idArticle) {
        try {
            namedParameterJdbcTemplate.update("DELETE FROM `auction`.`articles` WHERE id_article = :idArticle",
                    new MapSqlParameterSource("idArticle", idArticle));
        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
        }
    }
}