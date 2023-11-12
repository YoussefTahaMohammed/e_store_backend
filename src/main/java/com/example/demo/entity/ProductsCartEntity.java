package com.example.demo.entity;

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
@Table(name = "products_cart")
@Entity
public class ProductsCartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pc_id")
    private Integer pcId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "cart_id")
    private Integer cartId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "product_id",insertable = false,updatable = false)
    private ProductEntity productEntity;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "cart_id",insertable = false,updatable = false)
    private CartEntity cartEntity;

    public ProductsCartEntity(Integer productId, Integer cartId) {
        this.productId = productId;
        this.cartId = cartId;
    }
}
