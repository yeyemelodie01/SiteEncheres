package fr.eni.projet.siteenchere.bo;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jdk.jfr.Category;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Article {
    private Long idArticle;
    @NotBlank
    @Size(min=4, max = 30)
    private String articleName;
    @NotBlank
    @Size(min=4, max = 300)
    private String desciption;
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private LocalDate bidStartDay;
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private LocalDate bidEndDay;
    @NotBlank
    @Min(value = 10)
    @Max(value = 600)
    private Integer startingPrice;
    @NotBlank
    private Integer finalPrice;
    private String sellingStatus;
    private User user;
    private Category category;
    private Withdrawal withdrawal;
    private List<Bid> currentBid = new ArrayList<>();

    public Article() {
    }

    public Article(Long idArticle, String articleName, String desciption, LocalDate bidStartDay, LocalDate bidEndDay, Integer startingPrice, Integer finalPrice, String sellingStatus) {
        this.idArticle = idArticle;
        this.articleName = articleName;
        this.desciption = desciption;
        this.bidStartDay = bidStartDay;
        this.bidEndDay = bidEndDay;
        this.startingPrice = startingPrice;
        this.finalPrice = finalPrice;
        this.sellingStatus = sellingStatus;
    }

    public Article(String articleName, String desciption, LocalDate bidStartDay, LocalDate bidEndDay, Integer startingPrice, Integer finalPrice, String sellingStatus) {
        this.articleName = articleName;
        this.desciption = desciption;
        this.bidStartDay = bidStartDay;
        this.bidEndDay = bidEndDay;
        this.startingPrice = startingPrice;
        this.finalPrice = finalPrice;
        this.sellingStatus = sellingStatus;
    }

    public Article(Long idArticle, String articleName, String desciption, LocalDate bidStartDay, LocalDate bidEndDay, Integer startingPrice, Integer finalPrice, String sellingStatus, User user, Category category, Withdrawal withdrawal, List<Bid> currentBid) {
        this.idArticle = idArticle;
        this.articleName = articleName;
        this.desciption = desciption;
        this.bidStartDay = bidStartDay;
        this.bidEndDay = bidEndDay;
        this.startingPrice = startingPrice;
        this.finalPrice = finalPrice;
        this.sellingStatus = sellingStatus;
        this.user = user;
        this.category = category;
        this.withdrawal = withdrawal;
        this.currentBid = currentBid;
    }

    public Article(String articleName, String desciption, LocalDate bidStartDay, LocalDate bidEndDay, Integer startingPrice, Integer finalPrice, String sellingStatus, User user, Category category, Withdrawal withdrawal, List<Bid> currentBid) {
        this.articleName = articleName;
        this.desciption = desciption;
        this.bidStartDay = bidStartDay;
        this.bidEndDay = bidEndDay;
        this.startingPrice = startingPrice;
        this.finalPrice = finalPrice;
        this.sellingStatus = sellingStatus;
        this.user = user;
        this.category = category;
        this.withdrawal = withdrawal;
        this.currentBid = currentBid;
    }

    public Long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Long idArticle) {
        this.idArticle = idArticle;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public LocalDate getBidStartDay() {
        return bidStartDay;
    }

    public void setBidStartDay(LocalDate bidStartDay) {
        this.bidStartDay = bidStartDay;
    }

    public LocalDate getBidEndDay() {
        return bidEndDay;
    }

    public void setBidEndDay(LocalDate bidEndDay) {
        this.bidEndDay = bidEndDay;
    }

    public Integer getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(Integer startingPrice) {
        this.startingPrice = startingPrice;
    }

    public Integer getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Integer finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getSellingStatus() {
        return sellingStatus;
    }

    public void setSellingStatus(String sellingStatus) {
        this.sellingStatus = sellingStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Withdrawal getWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(Withdrawal withdrawal) {
        this.withdrawal = withdrawal;
    }

    public List<Bid> getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(List<Bid> currentBid) {
        this.currentBid = currentBid;
    }

    @Override
    public String toString() {
        return "Article{" +
                "idArticle=" + idArticle +
                ", articleName='" + articleName + '\'' +
                ", desciption='" + desciption + '\'' +
                ", bidStartDay=" + bidStartDay +
                ", bidEndDay=" + bidEndDay +
                ", startingPrice=" + startingPrice +
                ", finalPrice=" + finalPrice +
                ", sellingStatus='" + sellingStatus + '\'' +
                ", user=" + user +
                ", category=" + category +
                ", withdrawal=" + withdrawal +
                ", currentBid=" + currentBid +
                '}';
    }
}
