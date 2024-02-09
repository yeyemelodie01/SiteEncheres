package fr.eni.projet.siteenchere.bo;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private Long idCategory;
    private String catName;
    private List<Article> articleCategorys = new ArrayList<>();

    public Category() {
    }

    public Category(Long idCategory, String catName) {
        this.idCategory = idCategory;
        this.catName = catName;
    }

    public Category(Long idCategory, String catName, List<Article> articleCategorys) {
        this.idCategory = idCategory;
        this.catName = catName;
        this.articleCategorys = articleCategorys;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public List<Article> getArticleCategorys() {
        return articleCategorys;
    }

    public void setArticleCategorys(List<Article> articleCategorys) {
        this.articleCategorys = articleCategorys;
    }

    @Override
    public String toString() {
        return "Category{" +
                "idCategory=" + idCategory +
                ", catName='" + catName + '\'' +
                ", articleCategorys=" + articleCategorys +
                '}';
    }
}
