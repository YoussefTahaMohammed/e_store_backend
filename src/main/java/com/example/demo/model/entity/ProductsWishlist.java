package com.example.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products_wishlist")
@Entity
public class ProductsWishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pw_id")
    private Integer pwId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "wishlist_id")
    private Integer wishlistId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "product_id",insertable = false,updatable = false)
    private Product product;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "wishlist_id",insertable = false,updatable = false)
    private Wishlist wishlist;

    public ProductsWishlist(Integer productId, Integer wishlistId) {
        this.productId = productId;
        this.wishlistId = wishlistId;
    }
}
