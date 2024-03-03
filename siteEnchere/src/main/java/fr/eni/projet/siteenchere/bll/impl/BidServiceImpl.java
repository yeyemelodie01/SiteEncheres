package fr.eni.projet.siteenchere.bll.impl;

import fr.eni.projet.siteenchere.bll.BidService;
import fr.eni.projet.siteenchere.bo.Article;
import fr.eni.projet.siteenchere.bo.Bid;
import fr.eni.projet.siteenchere.dal.BidDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidServiceImpl implements BidService {

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
