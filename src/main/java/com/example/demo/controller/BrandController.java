package com.example.demo.controller;


import com.example.demo.services.BrandServices;
import com.example.demo.entity.BrandEntity;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(path = "/brand")
public class BrandController {
    @Autowired
    private BrandServices brandServices;

    @PostMapping(path = "/addBrand")
    public Map<String, String> addBrand(@RequestBody BrandEntity brand){
        return this.brandServices.addBrand(brand);
    }


    @GetMapping(path = "/getAllBrands")
    public List<BrandEntity> getAllBrands(){
        return this.brandServices.getAllBrands();
    }

    @DeleteMapping(path = "/deleteBrandById")
    public void deleteBrandById(@RequestParam Integer id){
        this.brandServices.deleteBrandById(id);
    }

    @DeleteMapping(path = "/deleteBrandByName")

    public void deleteBrandByName(@RequestParam String name){
        this.brandServices.deleteBrandByName(name);
    }
}
