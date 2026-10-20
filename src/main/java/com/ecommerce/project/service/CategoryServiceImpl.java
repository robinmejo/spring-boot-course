package com.ecommerce.project.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.ecommerce.project.exceptions.APIException;
import com.ecommerce.project.exceptions.NoDataFoundException;
import com.ecommerce.project.exceptions.ResourceNotFoundException;
import com.ecommerce.project.model.Category;
import com.ecommerce.project.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {

        List<Category> categories = categoryRepository.findAll();
        if(categories.isEmpty()){
            throw new NoDataFoundException("No data available!");
        }
        else{
            return categories;
        }
    }

    @Override
    public void createCategory(Category category) {
        Category existingCategory=categoryRepository.findByCategoryNameIgnoreCase(category.getCategoryName());
        if(existingCategory!=null){
            throw new APIException("Category name: "+category.getCategoryName()+" already exists");
        }
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Category", "categoryId", categoryId));

        categoryRepository.delete(category);

        return "Category with Category ID " + categoryId
                + " and category name "
                + category.getCategoryName()
                + " is deleted successfully";
    }

    @Override
    public Category updateCategory(Long categoryId, Category category) {

        Category existingCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Category", "categoryName", category.getCategoryName()));

        existingCategory.setCategoryName(category.getCategoryName());

        return categoryRepository.save(existingCategory);
    }

}
