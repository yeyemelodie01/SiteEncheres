package fr.eni.projet.siteenchere.dal.impl;

import fr.eni.projet.siteenchere.bo.Article;
import fr.eni.projet.siteenchere.bo.User;
import fr.eni.projet.siteenchere.bo.Withdrawal;
import fr.eni.projet.siteenchere.dal.UserDAOInterface;
import fr.eni.projet.siteenchere.dal.WithDrawalInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Profile("sql")
public class WithDrawalDAOSQLImpl implements WithDrawalInterface {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private UserDAOInterface userDAOInterface;
    private final String ADD_WITHDRAWAL = "INSERT INTO withdrawal (id_article, road_name, postal_code, city) VALUES (:idArticle, :roadName, :postalCode, :city);";
    private final String FIND_WITHDRAWAL = "SELECT id_article, road_name, postal_code, city FROM withdrawal WHERE id_article = :idArticle;";
    @Override
    public void addWithDrawal(Article article) {
        User user = this.userDAOInterface.readUserById(article.getUser().getIdUser());

        MapSqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("idArticle", article.getIdArticle())
                .addValue("roadName", user.getPersonnalRoadName())
                .addValue("postal_code", user.getPersonnalPostalCode())
                .addValue("city", user.getPersonnalCity());

        namedParameterJdbcTemplate.update(ADD_WITHDRAWAL,namedParameters);
    }

    @Override
    public Withdrawal findWithDrawal(Article article) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("idArticle", article.getIdArticle());
        return this.namedParameterJdbcTemplate.queryForObject(FIND_WITHDRAWAL, namedParameters, new BeanPropertyRowMapper<>(Withdrawal.class));
    }
}
