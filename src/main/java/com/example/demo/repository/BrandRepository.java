package com.example.demo.repository;

import com.example.demo.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity,Integer> {
    boolean existsByBrandName(String brand);
    void deleteByBrandName(String brand);

    List<BrandEntity> findAllByOrderByBrandId();
}
