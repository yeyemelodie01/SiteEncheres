package fr.eni.projet.siteenchere.dal.impl;

import fr.eni.projet.siteenchere.bo.Article;
import fr.eni.projet.siteenchere.dal.ArticleDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleDAOSQLImpl implements ArticleDAOInterface {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    final
    JdbcTemplate jdbcTemplate;

    private final String CREATE_REQUEST = " INSERT INTO 'auctions'.articles " + "(article_name, description, bid_start_day, " + "bid_end_day, starting_price, id_user, id_category) values (:articleName, :description, :bidStartDay, " + ":bidDayEnd, :startingPrice, :idUser, :idCategory)";

    public ArticleDAOSQLImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate, JdbcTemplate jdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.jdbcTemplate = jdbcTemplate;
    }

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


    @Override
    public Article readArticleById(Long idArticle) {
        return null;
    }

    @Override
    public List<Article> getArticlesByUser(Long idUser) {
        return null;
    }

    @Override
    public void updateArticle(Long idUser) {

    }

    @Override
    public void deleteArticle(Long idArticle) {

    }
}