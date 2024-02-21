package com.example.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "category_brand")
@Setter
@Getter
public class CategoryBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_id")
    @JsonIgnore
    private Integer cdId;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "brand_id")
    private Integer brandId;


    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "brand_id", insertable = false, updatable = false)
    private Brand brand;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private Category category;

    @Transient
    private String categoryName;

    @Transient
    private String brandName;


    public String getCategoryName() {
        return this.category.getCategoryName();
    }

    public String getBrandName() {
        return this.brand.getBrandName();
    }

}
