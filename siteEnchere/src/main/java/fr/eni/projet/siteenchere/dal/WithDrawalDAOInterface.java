package fr.eni.projet.siteenchere.dal;

import fr.eni.projet.siteenchere.bo.Article;
import fr.eni.projet.siteenchere.bo.Withdrawal;

public interface WithDrawalDAOInterface {
    void addWithDrawal(Article article);
    Withdrawal findWithDrawal(Article article);
}
