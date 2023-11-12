package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity()
@Table(name = "products")

public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_image")
    private String productImage;

    @Column(name = "price")
    private Double price;

    @Column(name = "rate")
    private Integer rate;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "brand_id")
    private Integer brandId;

    //--Relations--

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private CategoryEntity categoryEntity;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "brand_id", insertable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private BrandEntity brandEntity1;

    @OneToMany(mappedBy = "productEntity")
    @JsonManagedReference
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<ProductsCartEntity> productsCartEntities;

    @OneToMany(mappedBy = "productEntity")
    @JsonManagedReference
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<ProductsWishlistEntity> productsWishlistEntities;


    //--Custom Fields--

    @Transient
    private String brandName;

    @Transient
    private String categoryName;

    public String getBrandName() {
        return this.brandEntity1.getBrandName();
    }
    public String getCategoryName() {
        return this.categoryEntity.getCategoryName();
    }

}
