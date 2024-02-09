package fr.eni.projet.siteenchere.dal;

import fr.eni.projet.siteenchere.bo.User;

public interface UserDAO {
    Long createUser(User user);
    User readUserById(Long user);
    User readUserByEmail(String email);

}
