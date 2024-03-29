package fr.eni.projet.siteenchere.bo;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Article {
    private Long idArticle = null;
    @NotBlank
    @Size(min=4, max = 30)
    private String articleName;
    @NotBlank
    @Size(min=4, max = 300)
    private String description;
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date bidStartDay;
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date bidEndDay;
    @NotBlank
    @Min(value = 10)
    @Max(value = 600)
    private Integer startingPrice;

    @NotBlank
    private Integer finalPrice;
    private String sellingStatus;
    private Long idUser;
    private User user;
    private Long idCategory;
    private Category category;
    private Withdrawal withdrawal;
    private List<Bid> currentBidList = new ArrayList<>();

    public Article() {
    }
    
    //le constructeur à utiliser pour créer et récupérer un article en bdd
    //les autres attribut doivent être initialisés a l'aide des setter dans la bll
    //
    public Article(String articleName, String description, Date bidStartDay, Date bidEndDay, Integer startingPrice, Long idUser, Long idCategory) {
        this.articleName = articleName;
        this.description = description;
        this.bidStartDay = bidStartDay;
        this.bidEndDay = bidEndDay;
        this.startingPrice = startingPrice;
        this.idUser = idUser;
        this.idCategory = idCategory;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String desciption) {
        this.description = desciption;
    }

    public Date getBidStartDay() {
        return bidStartDay;
    }

    public void setBidStartDay(Date bidStartDay) {
        this.bidStartDay = bidStartDay;
    }

    public Date getBidEndDay() {
        return bidEndDay;
    }

    public void setBidEndDay(Date bidEndDay) {
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

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public Withdrawal getWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(Withdrawal withdrawal) {
        this.withdrawal = withdrawal;
    }

    public List<Bid> getCurrentBidList() {
        return currentBidList;
    }

    public void setCurrentBidList(List<Bid> currentBidList) {
        this.currentBidList = currentBidList;
    }

    public void addBid(Bid bid) {
        currentBidList.add(bid);
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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(idArticle, article.idArticle) && Objects.equals(articleName, article.articleName) && Objects.equals(description, article.description) && Objects.equals(bidStartDay, article.bidStartDay) && Objects.equals(bidEndDay, article.bidEndDay) && Objects.equals(startingPrice, article.startingPrice) && Objects.equals(finalPrice, article.finalPrice) && Objects.equals(sellingStatus, article.sellingStatus) && Objects.equals(idUser, article.idUser) && Objects.equals(user, article.user) && Objects.equals(idCategory, article.idCategory) && Objects.equals(category, article.category) && Objects.equals(withdrawal, article.withdrawal) && Objects.equals(currentBidList, article.currentBidList);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idArticle, articleName, description, bidStartDay, bidEndDay, startingPrice, finalPrice, sellingStatus, idUser, user, idCategory, category, withdrawal, currentBidList);
    }
    
    @Override
    public String toString() {
        return "Article{" +
            "idArticle=" + idArticle +
            ", articleName='" + articleName + '\'' +
            ", description='" + description + '\'' +
            ", bidStartDay=" + bidStartDay +
            ", bidEndDay=" + bidEndDay +
            ", startingPrice=" + startingPrice +
            ", finalPrice=" + finalPrice +
            ", sellingStatus='" + sellingStatus + '\'' +
            ", idUser=" + idUser +
            ", user=" + user +
            ", idCategory=" + idCategory +
            ", category=" + category +
            ", withdrawal=" + withdrawal +
            ", currentBid=" + currentBidList +
            '}';
    }
}
