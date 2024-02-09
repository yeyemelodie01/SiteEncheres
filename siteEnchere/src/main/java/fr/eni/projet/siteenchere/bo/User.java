package fr.eni.projet.siteenchere.bo;

import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Long idUser;
    @NotBlank
    @Size(min=4, max = 30)
    private String pseudo;
    @NotBlank
    @Size(min=4, max = 30)
    private String lastName;
    @NotBlank
    @Size(min=4, max = 30)
    private String firstName;
    @NotBlank
    @Email
    @Pattern(regexp = "^[\\w\\.-]+@[a-zA-Z\\d\\.-]+\\.[a-zA-Z]{2,}$")
    private String email;
    @NotBlank
    @Size(min=10, max = 15)
    private String phone;
    @NotBlank
    @Size(min=4, max = 30)
    private String roadName;
    @NotBlank
    @Size(min=5, max = 10)
    private String postalCode;
    @NotBlank
    @Size(min=4, max = 30)
    private String city;
    @NotBlank
    @Size(min=4, max = 30)
    private String password;
    private final static Long credit = 120L;
    @AssertFalse
    private boolean admin;
    private List<Article> salesList = new ArrayList<>();
    private List<Article> purchasedItemsList = new ArrayList<>();
    private List<Bid> currentBid = new ArrayList<>();

    public User() {
    }

    public User(Long idUser, String pseudo, String lastName, String firstName, String email, String phone, String roadName, String postalCode, String city, String password, boolean admin, List<Article> salesList, List<Article> purchasedItemsList, List<Bid> currentBid) {
        this.idUser = idUser;
        this.pseudo = pseudo;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phone = phone;
        this.roadName = roadName;
        this.postalCode = postalCode;
        this.city = city;
        this.password = password;
        this.admin = admin;
        this.salesList = salesList;
        this.purchasedItemsList = purchasedItemsList;
        this.currentBid = currentBid;
    }

    public User(String pseudo, String lastName, String firstName, String email, String phone, String roadName, String postalCode, String city, String password, boolean admin, List<Article> salesList, List<Article> purchasedItemsList, List<Bid> currentBid) {
        this.pseudo = pseudo;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phone = phone;
        this.roadName = roadName;
        this.postalCode = postalCode;
        this.city = city;
        this.password = password;
        this.admin = admin;
        this.salesList = salesList;
        this.purchasedItemsList = purchasedItemsList;
        this.currentBid = currentBid;
    }

    public User(Long idUser, String pseudo, String lastName, String firstName, String email, String phone, String roadName, String postalCode, String city, String password, boolean admin) {
        this.idUser = idUser;
        this.pseudo = pseudo;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phone = phone;
        this.roadName = roadName;
        this.postalCode = postalCode;
        this.city = city;
        this.password = password;
        this.admin = admin;
    }

    public User(String pseudo, String lastName, String firstName, String email, String phone, String roadName, String postalCode, String city, String password, boolean admin) {
        this.pseudo = pseudo;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phone = phone;
        this.roadName = roadName;
        this.postalCode = postalCode;
        this.city = city;
        this.password = password;
        this.admin = admin;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public List<Article> getSalesList() {
        return salesList;
    }

    public void setSalesList(List<Article> salesList) {
        this.salesList = salesList;
    }

    public List<Article> getPurchasedItemsList() {
        return purchasedItemsList;
    }

    public void setPurchasedItemsList(List<Article> purchasedItemsList) {
        this.purchasedItemsList = purchasedItemsList;
    }

    public List<Bid> getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(List<Bid> currentBid) {
        this.currentBid = currentBid;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", pseudo='" + pseudo + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", roadName='" + roadName + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                ", salesList=" + salesList +
                ", purchasedItemsList=" + purchasedItemsList +
                ", currentBid=" + currentBid +
                '}';
    }
}
