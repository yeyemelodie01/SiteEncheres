package fr.eni.projet.siteenchere.bo;

import java.time.LocalDate;

public class Bid {
    private LocalDate bidDate;
    private LocalDate bidAmount;
    private Article article;
    private User user;

    public Bid() {
    }

    public Bid(LocalDate bidDate, LocalDate bidAmount) {
        this.bidDate = bidDate;
        this.bidAmount = bidAmount;
    }

    public Bid(LocalDate bidDate, LocalDate bidAmount, Article article, User user) {
        this.bidDate = bidDate;
        this.bidAmount = bidAmount;
        this.article = article;
        this.user = user;
    }

    public LocalDate getBidDate() {
        return bidDate;
    }

    public void setBidDate(LocalDate bidDate) {
        this.bidDate = bidDate;
    }

    public LocalDate getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(LocalDate bidAmount) {
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
