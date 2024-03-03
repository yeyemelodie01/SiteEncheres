package fr.eni.projet.siteenchere.bo;

import java.sql.Date;
import java.time.LocalDate;

public class Bid {
    private Date bidDate;
    private Integer bidAmount;
    //private Long idArticle;
    private User user;
    private Long idArticle;

    public Bid() {
    }

    public Bid(Date bidDate, Integer bidAmount) {
        this.bidDate = bidDate;
        this.bidAmount = bidAmount;
    }

    public Bid(Date bidDate, Integer bidAmount, Long idArticle, User user) {
        this.bidDate = bidDate;
        this.bidAmount = bidAmount;
        this.idArticle = idArticle;
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

    public Long getArticle() {
        return idArticle;
    }

    public void setArticle(Long idArticle) {
        this.idArticle = idArticle;
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
                ", article=" + idArticle +
                ", user=" + user +
                '}';
    }
}
