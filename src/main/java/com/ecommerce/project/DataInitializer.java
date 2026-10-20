
package com.ecommerce.project;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.repositories.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(CategoryRepository categoryRepository) {
        return args -> {
            if (categoryRepository.count() == 0) {
                String[] names = {
                    "Electronics",
                    "Furniture",
                    "Clothing",
                    "Footwear",
                    "Groceries",
                    "Books",
                    "Sports",
                    "Beauty Products",
                    "Home Decor",
                    "Travel Accessories"
                };

                for (String name : names) {
                    Category category = new Category();
                    category.setCategoryName(name);
                    categoryRepository.save(category);
                }
            }
        };
    }
}
