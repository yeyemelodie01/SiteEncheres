package fr.eni.projet.siteenchere.dal;

import fr.eni.projet.siteenchere.bo.User;

public interface UserDAOInterface {
    void createUser(User user);
    User readUserById(Long idUser);
    User readUserByEmail(String mailUser);
    void updateUser(User user);
    void deleteUser(Long idUser);
}
