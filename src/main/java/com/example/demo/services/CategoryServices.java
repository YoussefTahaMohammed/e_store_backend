package com.example.demo.services;

import com.example.demo.entity.CategoryEntity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public interface CategoryServices {

    Map<String, String> addCategory(CategoryEntity category);

    List<CategoryEntity> getAllCategories();

    void deleteCategoryById(Integer id);

    @Transactional
    void deleteCategoryByName(String name);

    boolean existsCategoryById(Integer id);

    boolean existsCategoryByName(String name);
}
