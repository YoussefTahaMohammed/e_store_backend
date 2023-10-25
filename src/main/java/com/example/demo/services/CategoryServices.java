package com.example.demo.services;

import com.example.demo.entity.CategoryEntity;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
//    public CategoryEntity addCategory(CategoryEntity category) {
//        if (existsCategoryByName(category.getCategoryName())) {
//            return null;
//        }
//        return this.categoryRepository.save(category);
//    }

@Service
public class CategoryServices {
    @Autowired
    private CategoryRepository categoryRepository;

    public Map<String, String> addCategory(CategoryEntity category) {
        Map<String, String> result = new HashMap<>();
        if (!existsCategoryByName(category.getCategoryName())) {
            this.categoryRepository.save(category);
            result.put("api_status", "success");
            result.put("message", "Category Added Successfully");
            return result;
        }
        result.put("api_status", "failed");
        result.put("message", "Duplicate Category Name");
        return result;
    }

    public List<CategoryEntity> getAllCategories(){
        return categoryRepository.findAllByOrderByCategoryId();
    }
    public void deleteCategoryById(Integer id){
        categoryRepository.deleteById(id);
    }

    @Transactional
    public void deleteCategoryByName(String name){
        categoryRepository.deleteByCategoryName(name);
    }

    public boolean existsCategoryById(Integer id) {
        return this.categoryRepository.existsById(id);
    }

    public boolean existsCategoryByName(String name) {
        return this.categoryRepository.existsByCategoryName(name);
    }
}
