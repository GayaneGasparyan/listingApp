package com.example.listingapp.service;


import com.example.listingapp.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> getAllCategory();

    Optional<Category> getCategoryById(int id);

    Category addCategory(Category category);

    void deleteCategoryByID(int id);



}
