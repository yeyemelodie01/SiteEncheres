package fr.eni.projet.siteenchere.bo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public class Withdrawal {

    @NotBlank
    @Size(min=4, max = 30)
    private String roadName;
    @NotBlank
    @Size(min=4, max = 30)
    private String postalCode;
    @NotBlank
    @Size(min=4, max = 30)
    private String city;
    private List<Article> articles;

    public Withdrawal() {
    }

    public Withdrawal(String roadName, String postalCode, String city) {
        this.roadName = roadName;
        this.postalCode = postalCode;
        this.city = city;
    }

    public Withdrawal(String roadName, String postalCode, String city, List<Article> articles) {
        this.roadName = roadName;
        this.postalCode = postalCode;
        this.city = city;
        this.articles = articles;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Withdrawal{" +
                "roadName='" + roadName + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", articles=" + articles +
                '}';
    }
}
