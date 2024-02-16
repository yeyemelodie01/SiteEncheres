package fr.eni.projet.siteenchere.dal;

import fr.eni.projet.siteenchere.bo.Article;
import fr.eni.projet.siteenchere.bo.Bid;

import java.util.List;

public interface BidDAOInterface {
    void addBid(Article article);
    Bid findOneBid(Article article);
    List<Bid> findAllBid();
}
