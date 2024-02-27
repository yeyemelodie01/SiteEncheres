package fr.eni.projet.siteenchere.dal;

import fr.eni.projet.siteenchere.bo.Article;

import java.util.List;

public interface ArticleDAOInterface {
    Long createArticle(Article article);

    Article readArticleById(Long idArticle);

    List<Article> getArticlesByUser(Long idUser);

    void updateArticle(Article article);

    void deleteArticle(Long idArticle);
}