package fr.eni.projet.siteenchere.dal.impl;

import fr.eni.projet.siteenchere.bo.User;
import fr.eni.projet.siteenchere.dal.UserDAOInterface;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

@Repository

public class UserDAOSQLImpl implements UserDAOInterface {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final String CREATE_USER = "INSERT INTO USERS(pseudo, lastname, firstname, email, phone, road_name, postal_code, city, password, credit, admin)"
            + " VALUES (:pseudo, :lastname, :firstname, :email, :phone, :roadName, :postalCode, :town, :password, 200, false);";

    private static final String READ_USER_BY_ID = "SELECT * FROM USERS WHERE id_user = :idUser;";
    private static final String READ_USER_BY_EMAIL = "SELECT * FROM USERS WHERE email = :email;";
    private static final String UPDATE_USER = "UPDATE USERS SET pseudo = :pseudo, lastname = :lastname, firstname = :firstname, email = :email, phone = :phone, roadName = :roadName, postalCode = :postalCode, town = :town, password = :password WHERE id_user = :idUser;";
    private static final String DELETE_USER = "DELETE FROM USERS WHERE id_user = :idUser";


    public UserDAOSQLImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void createUser(User user) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("pseudo", user.getPseudo())
                .addValue("lastname", user.getLastName())
                .addValue("firstname", user.getFirstName())
                .addValue("email", user.getEmail())
                .addValue("phone", user.getPhone())
                .addValue("roadName", user.getPersonnalRoadName())
                .addValue("postalCode", user.getPersonnalPostalCode())
                .addValue("town", user.getPersonnalCity())
                .addValue("password", user.getPassword());

        namedParameterJdbcTemplate.update(CREATE_USER, namedParameters, keyHolder);

        if (keyHolder.getKey() != null)
             user.setIdUser((long) keyHolder.getKey().intValue());
    }

    @Override
    public User readUserById(Long idUser) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("idUser", idUser);

        User user = null;

        try{
            user = namedParameterJdbcTemplate.queryForObject(READ_USER_BY_ID,namedParameters, new BeanPropertyRowMapper<>(User.class));
        } catch (EmptyResultDataAccessException e) {
            user = null;
        }

        return user;
    }

    @Override
    public User readUserByEmail(String email) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("email", email);

        return namedParameterJdbcTemplate.queryForObject(READ_USER_BY_EMAIL, namedParameters, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public void updateUser(User user) {
        BeanPropertySqlParameterSource namedParameters = new BeanPropertySqlParameterSource(user);
        namedParameterJdbcTemplate.update(UPDATE_USER,namedParameters);
    }

    @Override
    public void deleteUser(Long idUser) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("idUser", idUser);

        namedParameterJdbcTemplate.update(DELETE_USER, namedParameters);
    }
}
