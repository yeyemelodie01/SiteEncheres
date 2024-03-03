//package fr.eni.projet.siteenchere.dal.impl;
//
//import fr.eni.projet.siteenchere.bo.Article;
//import fr.eni.projet.siteenchere.bo.Bid;
//import fr.eni.projet.siteenchere.bo.User;
//import fr.eni.projet.siteenchere.dal.BidDAOInterface;
//import fr.eni.projet.siteenchere.dal.UserDAOInterface;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.sql.Date;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//
//@Repository
//public class BidDAOSQLImpl implements BidDAOInterface {
//    private JdbcTemplate jdbcTemplate;
//    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//
//    private static final String ADD_BID = "INSERT INTO BID (id_user, id_article, bid_date, bid_amount) VALUES (:idUser, :idArticle, :bidDate, :bidAmount);";
//    private static final String FIND_ONE_BID = "SELECT * FROM BID INNER JOIN ARTICLES ON BID.id_article = ARTICLES.id_article INNER JOIN USERS ON BID.id_user = USERS.id_user WHERE BID.id_article = :idArticle;";
//    private static final String FIND_ALL_BID = "SELECT * FROM BID;";
//
//    public BidDAOSQLImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
//    }
//
//    @Override
//    public void addBid(Bid bid) {
//
//    }
//
//    @Override
//    public Bid findOneBid(Article article) {
//        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
//        namedParameters.addValue("noArticle", article.getIdArticle());
//
//        return namedParameterJdbcTemplate.queryForObject(FIND_ONE_BID, namedParameters, (resultSet, rowNum) -> {
//            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
//            Bid bid = new Bid();
//            bid.setBidDate(Date.from(LocalDateTime.parse(resultSet.getString("bid_date"), dateTimeFormatter)));
//            bid.setBidAmount(Date.ofEpochDay(resultSet.getInt("bid_amount")));
//
//            /* Charger l'id de l'article */
//            Article articleEnchere = new Article();
//            articleEnchere.setIdArticle((long) resultSet.getInt("id_article"));
//            bid.setArticle(articleEnchere);
//
//            /* Charger l'id de l'utilisateur */
//            User user = new User();
//            user.setIdUser((long) resultSet.getInt("id_user"));
//            bid.setUser(user);
//
//            return bid;
//        });
//    }
//
//    @Override
//    public List<Bid> findAllBid() {
//        return jdbcTemplate.query(FIND_ALL_BID, new BeanPropertyRowMapper<>(Bid.class));
//    }
//}