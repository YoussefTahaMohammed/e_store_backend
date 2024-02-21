package com.example.demo.controller;


import com.example.demo.services.Impl.BrandServicesImplement;
import com.example.demo.model.entity.Brand;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(path = "/brand")
@RequiredArgsConstructor
public class BrandController {
    private final BrandServicesImplement brandServices;

    @PostMapping(path = "/addBrand")
    public Map<String, String> addBrand(@RequestBody Brand brand){
        return this.brandServices.addBrand(brand);
    }


    @GetMapping(path = "/getAllBrands")
    public List<Brand> getAllBrands(){
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
