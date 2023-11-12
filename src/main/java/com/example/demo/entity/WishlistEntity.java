package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "wishlist")
public class WishlistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wishlist_id")
    Integer wishlistId;

    @Column(name = "products_number")
    Integer productNumber;

    @Column(name = "total_price")
    Double totalPrice;

    public WishlistEntity(Integer productNumber, Double totalPrice) {
        this.productNumber = productNumber;
        this.totalPrice = totalPrice;
    }

    @OneToOne
    @JsonBackReference
    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JoinColumn(name = "wishlist_id",updatable = false,insertable = false)
    UserEntity userEntity;

    @OneToMany(mappedBy = "wishlistEntity")
    @JsonManagedReference
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<ProductsWishlistEntity> productsWishlistEntities;
}
