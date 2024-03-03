package fr.eni.projet.siteenchere.bll.impl;

import fr.eni.projet.siteenchere.bll.CategoryService;
import fr.eni.projet.siteenchere.bo.Category;
import fr.eni.projet.siteenchere.dal.CategoryDAOinterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAOinterface categoryDAOinterface;
    @Override
    public Category findOneCategory(Long idCategory) {
        return categoryDAOinterface.findOneCategory(idCategory);
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryDAOinterface.findAllCategory();
    }
}
