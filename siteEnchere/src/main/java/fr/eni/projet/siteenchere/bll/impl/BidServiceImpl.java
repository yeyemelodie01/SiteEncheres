package fr.eni.projet.siteenchere.bll.impl;

import fr.eni.projet.siteenchere.bll.BidServiceInterface;
import fr.eni.projet.siteenchere.bo.Article;
import fr.eni.projet.siteenchere.bo.Bid;
import fr.eni.projet.siteenchere.dal.BidDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BidServiceImpl implements BidServiceInterface {

    @Autowired
    private BidDAOInterface bidDAOInterface;
    @Override
    public void addBid(Bid bid) {
        bidDAOInterface.addBid(bid);
    }

    @Override
    public Bid findOneBid(Article article) {
        return bidDAOInterface.findOneBid(article);
    }

    @Override
    public List<Bid> findAllBid() {
        return bidDAOInterface.findAllBid();
    }
}
