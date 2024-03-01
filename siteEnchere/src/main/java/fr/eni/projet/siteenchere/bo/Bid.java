package fr.eni.projet.siteenchere.bo;

import java.sql.Date;
import java.time.LocalDate;

public class Bid {
    private Date bidDate;
    private Integer bidAmount;
    //private Long idArticle;
    private User user;
    private Article article;

    public Bid() {
    }

    public Bid(Date bidDate, Integer bidAmount) {
        this.bidDate = bidDate;
        this.bidAmount = bidAmount;
    }

    public Bid(Date bidDate, Integer bidAmount, Article article, User user) {
        this.bidDate = bidDate;
        this.bidAmount = bidAmount;
        this.article = article;
        this.user = user;
    }

    public Date getBidDate() {
        return bidDate;
    }

    public void setBidDate(Date bidDate) {
        this.bidDate = bidDate;
    }

    public Integer getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(Integer bidAmount) {
        this.bidAmount = bidAmount;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "bidDate=" + bidDate +
                ", bidAmount=" + bidAmount +
                ", article=" + article +
                ", user=" + user +
                '}';
    }
}
