package fr.eni.projet.siteenchere.dal;

import fr.eni.projet.siteenchere.bo.Category;

import java.util.List;

public interface CategoryDAOinterface {
    Category findOneCategory(Long id);
    List<Category> findAllCategory();
}
