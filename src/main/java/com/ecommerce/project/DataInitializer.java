
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
                    "Travel Accessories",
                    "Laptops & Computers",
                    "Cameras & Photography",
                    "Kitchen Appliances",
                    "Watches",
                    "Jewellery",
                    "Bags & Backpacks",
                    "Automotive Accessories",
                    "Pet Supplies",
                    "Musical Instruments",
                    "Office Supplies",
                    "Gardening",
                    "Outdoor & Camping",
                    "Health & Wellness",
                    "Baby Products",
                    "Stationery",
                    "Video Games",
                    "Smart Home Devices",
                    "Cleaning Supplies",
                    "Mobile Accessories",
                    "Headphones & Speakers",
                    "Printers & Scanners",
                    "Networking Devices",
                    "Toys & Games",
                    "Personal Care Appliances",
                    "Mattresses & Bedding",
                    "Lighting & Lamps",
                    "Womens Fashion",
                    "Mens Fashion",
                    "Womens Handbags",
                    "Womens Accessories"
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
