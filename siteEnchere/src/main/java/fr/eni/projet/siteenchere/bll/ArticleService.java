package fr.eni.projet.siteenchere.bll;

import fr.eni.projet.siteenchere.bo.Article;

import java.util.List;

public interface ArticleService {
    Long createArticle(Article article);

    Article readArticleById(Long idArticle);

    List<Article> getArticlesByUser(Long idUser);

    List<Article> getArticleByCategories(Long idCategory);

    void updateArticle(Article article);

    void deleteArticle(Long idArticle);
}
