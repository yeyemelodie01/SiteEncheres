package fr.eni.projet.siteenchere.dal.impl;

import fr.eni.projet.siteenchere.bo.Article;
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

import java.util.Collections;
import java.util.List;

@Repository
public class ArticleDAOSQLImpl implements ArticleDAOInterface {
  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
  final JdbcTemplate jdbcTemplate;
  
  private final String CREATE_REQUEST = " INSERT INTO `auction`.`articles` " +
      "(article_name, description, bid_start_day, bid_end_day, starting_price, id_user, id_category) " +
      "values (:articleName, :description, :bidStartDay, :bidEndDay, :startingPrice, :idUser, :idCategory)";
  private final String READ_ID_REQUEST = "SELECT * FROM `auction`.`articles` WHERE id_article = :idArticle";
  
  private final String READ_USER_REQUEST = "SELECT * FROM `auction`.`articles` WHERE id_user = :idUser";
  
  private final String UPDATE_REQUEST = "UPDATE `auction`.`articles` " +
      "SET article_name = :articleName, " +
      "description = :description, " +
      "bid_start_day = :bidStartDay, " +
      "bid_end_day = :bidEndDay, " +
      "starting_price = :startingPrice, " +
      "id_user = :idUser, " +
      "id_category = :idCategory " +
      "WHERE id_article = :idArticle";
  
  public ArticleDAOSQLImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate, JdbcTemplate jdbcTemplate) {
    this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    this.jdbcTemplate = jdbcTemplate;
  }
  
  /**
   * @param article (articleName, description, bidStartDay, bidEndDay, startingPrice, idUser, idCategory)
   *
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
   *
   * @return the article with the specified ID, or a default article if not found
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
   *
   * @return a list of articles associated with the specified user or an empty list if none
   */
  @Override
  public List<Article> getArticlesByUser(Long idUser) {
    try {
      return namedParameterJdbcTemplate.query(
          READ_USER_REQUEST,
          new MapSqlParameterSource("idUser", idUser),
          new BeanPropertyRowMapper<>(Article.class)
      );
    } catch (EmptyResultDataAccessException e) {
      return Collections.emptyList();
    }
  }
  // pas testé
  @Override
  public void updateArticle(Article article) {
    try {
      Article oldArticle = readArticleById(article.getIdArticle());
      if (oldArticle.getIdArticle() == null) {
        String description = oldArticle.getDescription();
        assert (description.equals("Article not found"));
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
  
  @Override
  public void deleteArticle(Long idArticle) {
  
  }
}