package fr.eni.projet.siteenchere.bll;

import fr.eni.projet.siteenchere.bo.Article;
import fr.eni.projet.siteenchere.bo.Bid;

import java.util.List;

public interface BidService {
    void addBid(Bid bid);
    Bid findOneBid(Article article);
    List<Bid> findAllBid();
}
