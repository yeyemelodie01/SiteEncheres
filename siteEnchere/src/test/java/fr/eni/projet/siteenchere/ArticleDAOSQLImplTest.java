package fr.eni.projet.siteenchere;

import fr.eni.projet.siteenchere.bo.Article;

import fr.eni.projet.siteenchere.dal.impl.ArticleDAOSQLImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;

@SpringBootTest
class ArticleDAOSQLImplTest {

    @Autowired
    ArticleDAOSQLImpl articleDAOSQLImpl;

    @Test
    @Transactional
    void createArticleTest() {
        Article article = new Article( "test", "test", Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()), 10, 10, "test");
        System.out.println(article);
        Long id = articleDAOSQLImpl.createArticle(article);
        System.out.println(id);
        assert(id != null);
        //assert(articleDAOSQLImpl.readArticleById(id) != null);
        assert(!id.equals(article.getIdArticle()));
    }

}
