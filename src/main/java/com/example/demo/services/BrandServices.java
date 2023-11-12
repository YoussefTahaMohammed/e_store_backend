package com.example.demo.services;

import com.example.demo.entity.BrandEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public interface BrandServices {

    Map<String, String> addBrand(BrandEntity brand) ;

    List<BrandEntity> getAllBrands() ;

    void deleteBrandById(Integer id);

    @Transactional
    void deleteBrandByName (String name);


    boolean existsBrandByName(String name);

}
