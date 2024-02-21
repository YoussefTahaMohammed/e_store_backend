package com.example.demo.services.Impl;

import com.example.demo.model.entity.Brand;
import com.example.demo.repository.BrandRepository;
import com.example.demo.services.BrandServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor

public class BrandServicesImplement implements BrandServices {
    private final BrandRepository brandRepository;
    public Map<String, String> addBrand(Brand brand) {
        Map<String, String> result = new HashMap<>();

        if (existsBrandByName(brand.getBrandName())) {
            result.put("api_status", "failed");
            result.put("message", "Duplicate Brand Name");
            return result;
        }
        result.put("api_status", "success");
        result.put("message", "Brand Added Successfully");
        this.brandRepository.save(brand);
        return result;
    }

    public Brand findBrandById(Integer id){
        Optional<Brand> returnedProduct = this.brandRepository.findById(id);
        return returnedProduct.orElseGet(Brand::new);
    }

    public List<Brand> getAllBrands() {
        return brandRepository.findAllByOrderByBrandId();
    }

    public void deleteBrandById(Integer id){
        brandRepository.deleteById(id);
    }

    @Transactional
    public void deleteBrandByName (String name){
        brandRepository.deleteByBrandName(name);
    }


    public boolean existsBrandByName(String name) {
        return this.brandRepository.existsByBrandName(name);
    }

}
