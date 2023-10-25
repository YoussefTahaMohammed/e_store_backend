package com.example.demo.controller;

import com.example.demo.services.CategoryServices;
import com.example.demo.entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

//    @PostMapping(path = "/addCategory")
//    public CategoryEntity addCategory(@RequestBody CategoryEntity category){
//        return this.categoryDao.addCategory(category);
//    }
@RestController
@RequestMapping(path = "/category")
public class CategoryController {
    @Autowired
    private CategoryServices categoryServices;

    @PostMapping(path = "/addCategory")
    public Map<String,String> addCategory(@RequestBody CategoryEntity category){
        return this.categoryServices.addCategory(category);
    }

    @GetMapping(path = "/getAllCategories")
    public List<CategoryEntity> getAllCategories(){
        return this.categoryServices.getAllCategories();
    }

    @GetMapping(path = "/existsCategoryById")
    public boolean existsCategoryById(@RequestParam Integer id){
        return this.categoryServices.existsCategoryById(id);
    }

    @DeleteMapping(path = "/deleteCategoryById")
    public void deleteCategoryById (@RequestParam Integer id){
        categoryServices.deleteCategoryById(id);
    }

    @DeleteMapping(path = "/deleteCategoryByName")
    public void deleteCategoryByName (@RequestParam String name){
        categoryServices.deleteCategoryByName(name);
    }
}
