package fr.eni.projet.siteenchere.dal.impl;

import fr.eni.projet.siteenchere.bo.Article;
import fr.eni.projet.siteenchere.bo.User;
import fr.eni.projet.siteenchere.bo.Withdrawal;
import fr.eni.projet.siteenchere.dal.UserDAOInterface;
import fr.eni.projet.siteenchere.dal.WithDrawalDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Profile("sql")
public class WithDrawalDAOSQLImpl implements WithDrawalDAOInterface {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private UserDAOInterface userDAOInterface;
    private static final String ADD_WITHDRAWAL = "INSERT INTO WITHDRAWAL (id_article, road_name, postal_code, city) VALUES (:idArticle, :roadName, :postalCode, :city);";
    private static final String FIND_WITHDRAWAL = "SELECT id_article, road_name, postal_code, city FROM WITHDRAWAL WHERE id_article = :idArticle;";
    @Override
    public void addWithDrawal(Article article) {
        User user = this.userDAOInterface.readUserById(article.getUser().getIdUser());

        MapSqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("idArticle", article.getIdArticle())
                .addValue("roadName", user.getRoadName())
                .addValue("postal_code", user.getPostalCode())
                .addValue("city", user.getCity());

        namedParameterJdbcTemplate.update(ADD_WITHDRAWAL,namedParameters);
    }

    @Override
    public Withdrawal findWithDrawal(Article article) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("idArticle", article.getIdArticle());
        return this.namedParameterJdbcTemplate.queryForObject(FIND_WITHDRAWAL, namedParameters, new BeanPropertyRowMapper<>(Withdrawal.class));
    }
}
