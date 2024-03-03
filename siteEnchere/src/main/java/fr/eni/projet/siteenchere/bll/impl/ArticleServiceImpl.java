package fr.eni.projet.siteenchere.bll.impl;

import fr.eni.projet.siteenchere.bll.ArticleService;
import fr.eni.projet.siteenchere.bo.Article;
import fr.eni.projet.siteenchere.dal.ArticleDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    
    @Autowired
    private ArticleDAOInterface articleDAOInterface;
    @Override
    public Long createArticle(Article article) {
        return articleDAOInterface.createArticle(article);
    }

    @Override
    public Article readArticleById(Long idArticle) {
        return articleDAOInterface.readArticleById(idArticle);
    }

    @Override
    public List<Article> getArticlesByUser(Long idUser) {
        return articleDAOInterface.getArticlesByUser(idUser);
    }

    @Override
    public List<Article> getArticleByCategories(Long idCategory) {
        return articleDAOInterface.getArticleByCategories(idCategory);
    }

    @Override
    public void updateArticle(Article article) {
        articleDAOInterface.updateArticle(article);
    }

    @Override
    public void deleteArticle(Long idArticle) {
        articleDAOInterface.deleteArticle(idArticle);
    }
}
