package fr.eni.projet.siteenchere.bll.impl;

import fr.eni.projet.siteenchere.bll.UserServiceInterface;
import fr.eni.projet.siteenchere.bo.User;
import fr.eni.projet.siteenchere.dal.UserDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    private UserDAOInterface userDAOInterface;
    @Override
    public void create(User user) {
        userDAOInterface.createUser(user);
    }

    @Override
    public User readUserById(Long idUser) {
        return userDAOInterface.readUserById(idUser);
    }

    @Override
    public User readUserByEmail(String mailUser) {
        return userDAOInterface.readUserByEmail(mailUser);
    }

    @Override
    public void updateUser(User user) {
        userDAOInterface.updateUser(user);
    }

    @Override
    public void deleteUser(Long idUser) {
        userDAOInterface.deleteUser(idUser);
    }
}
