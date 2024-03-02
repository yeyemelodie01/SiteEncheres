package fr.eni.projet.siteenchere.bll;

import fr.eni.projet.siteenchere.bo.User;

public interface UserServiceInterface {
    void create(User user);
    User readUserById(Long idUser);
    User readUserByEmail(String mailUser);
    void updateUser(User user);
    void deleteUser(Long idUser);
}
