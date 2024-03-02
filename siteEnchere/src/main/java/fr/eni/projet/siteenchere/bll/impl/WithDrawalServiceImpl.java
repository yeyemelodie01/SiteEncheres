package fr.eni.projet.siteenchere.bll.impl;

import fr.eni.projet.siteenchere.bll.WithDrawalService;
import fr.eni.projet.siteenchere.bo.Article;
import fr.eni.projet.siteenchere.bo.Withdrawal;
import fr.eni.projet.siteenchere.dal.WithDrawalDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WithDrawalServiceImpl implements WithDrawalService {

    @Autowired
    private WithDrawalDAOInterface withDrawalDAOInterface;
    @Override
    public void addWithDrawal(Article article) {
        withDrawalDAOInterface.addWithDrawal(article);
    }

    @Override
    public Withdrawal findWithDrawal(Article article) {
        return withDrawalDAOInterface.findWithDrawal(article);
    }
}
