package com.example.demo.services;

import com.example.demo.model.entity.Brand;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public interface BrandServices {

    Map<String, String> addBrand(Brand brand) ;
    Brand findBrandById(Integer id);

    List<Brand> getAllBrands() ;

    void deleteBrandById(Integer id);

    @Transactional
    void deleteBrandByName (String name);

    boolean existsBrandByName(String name);

}
