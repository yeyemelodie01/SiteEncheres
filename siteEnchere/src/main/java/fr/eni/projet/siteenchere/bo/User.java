package fr.eni.projet.siteenchere.bo;

import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Long idUser = 0L;
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
    private String personnalRoadName;
    @NotBlank
    @Size(min=5, max = 10)
    private String personnalPostalCode;
    @NotBlank
    @Size(min=4, max = 30)
    private String personnalCity;
    @NotBlank
    @Size(min=4, max = 30)
    private String password;
    private Withdrawal withdrawal;
    private Long credit = 120L;
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
        this.personnalRoadName = roadName;
        this.personnalPostalCode = postalCode;
        this.personnalCity = city;
        this.password = password;
        this.admin = admin;
        this.salesList = salesList;
        this.purchasedItemsList = purchasedItemsList;
        this.currentBid = currentBid;
    }

    public User(String pseudo, String lastName, String firstName, String email, String phone, String roadName, String postalCode, String city, String password, boolean admin) {
        this.pseudo = pseudo;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phone = phone;
        this.personnalRoadName = roadName;
        this.personnalPostalCode = postalCode;
        this.personnalCity = city;
        this.password = password;
        this.admin = admin;
    }
    
    public Withdrawal getWithdrawal() {
        return withdrawal;
    }
    
    public void setWithdrawal(Withdrawal withdrawal) {
        this.withdrawal = withdrawal;
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

    public String getPersonnalRoadName() {
        return personnalRoadName;
    }

    public void setPersonnalRoadName(String roadName) {
        this.personnalRoadName = roadName;
    }

    public String getPersonnalPostalCode() {
        return personnalPostalCode;
    }

    public void setPersonnalPostalCode(String postalCode) {
        this.personnalPostalCode = postalCode;
    }

    public String getPersonnalCity() {
        return personnalCity;
    }

    public void setPersonnalCity(String city) {
        this.personnalCity = city;
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

    public Long getCredit() {
        return credit;
    }

    public void setCredit(Long credit) {
        this.credit = credit;
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
                ", roadName='" + personnalRoadName + '\'' +
                ", postalCode='" + personnalPostalCode + '\'' +
                ", city='" + personnalCity + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                ", salesList=" + salesList +
                ", purchasedItemsList=" + purchasedItemsList +
                ", currentBid=" + currentBid +
                '}';
    }
}
