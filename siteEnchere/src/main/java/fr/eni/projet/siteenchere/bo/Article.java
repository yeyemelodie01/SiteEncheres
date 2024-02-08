package fr.eni.projet.siteenchere.bo;

import jdk.jfr.Category;

import java.time.LocalDate;
import java.util.ArrayList;

public class Article {
    private Long idArticle;
    private String articleName;
    private String desciption;
    private LocalDate bidStartDay;
    private LocalDate bidEndDay;
    private Integer startingPrice;
    private Integer finalPrice;
    private String sellingStatus;
    private User buyUser;
    private User purchasedUser;
    private Category category;
    private Withdrawal withdrawal;
    private List<Bid> currentBid = new ArrayList<>();
}
