package fr.eni.projet.siteenchere.dal.impl;

import fr.eni.projet.siteenchere.bo.Category;
import fr.eni.projet.siteenchere.dal.CategoryDAOinterface;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("sql")
public class CategoryDAOSQLImpl implements CategoryDAOinterface {
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final String FIND_ONE_CATEGORY = "SELECT * FROM CATEGORY WHERE id_category = :idCategory;";
    private static final String FIND_ALL_CATEGORY = "SELECT * FROM CATEGORY;";

    public CategoryDAOSQLImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Category findOneCategory(Long idCategory) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("idCategory", idCategory);

        return namedParameterJdbcTemplate.queryForObject(FIND_ONE_CATEGORY, namedParameters, new
                BeanPropertyRowMapper<>(Category.class));
    }

    @Override
    public List<Category> findAllCategory() {
        return jdbcTemplate.query(FIND_ALL_CATEGORY, new BeanPropertyRowMapper<>(Category.class));
    }
}
