package fr.eni.projet.siteenchere.bll;

import fr.eni.projet.siteenchere.bo.Category;

import java.util.List;

public interface CategoryServiceInterface {
    Category findOneCategory(Long idCategory);
    List<Category> findAllCategory();
}
