package fr.eni.projet.siteenchere.bll;

import fr.eni.projet.siteenchere.bo.Article;
import fr.eni.projet.siteenchere.bo.Withdrawal;

public interface WithDrawalService {
    void addWithDrawal(Article article);
    Withdrawal findWithDrawal(Article article);
}
