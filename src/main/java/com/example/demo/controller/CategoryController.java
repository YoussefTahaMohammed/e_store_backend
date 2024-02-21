package com.example.demo.controller;


import com.example.demo.model.entity.Category;
import com.example.demo.services.CategoryServices;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/category")
public class CategoryController {
    private final CategoryServices categoryServices;

    @PostMapping(path = "/addCategory")
    public Map<String,String> addCategory(@RequestBody Category category){
        return this.categoryServices.addCategory(category);
    }

    @GetMapping(path = "/getAllCategories")
    public List<Category> getAllCategories(){
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
