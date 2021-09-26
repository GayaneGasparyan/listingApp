package com.example.listingapp.endPoint;

import com.example.listingapp.model.Category;
import com.example.listingapp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequiredArgsConstructor
public class CategoryEndPoint {

    private final CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategory();
    }

    @GetMapping("/categories/{id}")
    public Optional<Category> getById(int id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/categories")
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }

    @PutMapping("/categories")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        categoryService.getCategoryById(category.getId());
        return ResponseEntity
                .notFound()
                .build();
    }

    @DeleteMapping("(/categories/{id}")
    public void deleteCategory(@PathVariable("id") int id) {
        categoryService.deleteCategoryByID(id);
    }

}
