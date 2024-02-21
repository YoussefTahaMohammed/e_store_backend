package com.example.demo.model.entity;

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
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    Integer cartId;

    @Column(name = "products_number")
    Integer productNumber;

    @Column(name = "total_price")
    Double totalPrice;

    public Cart(Integer productNumber, Double totalPrice) {
        this.productNumber = productNumber;
        this.totalPrice = totalPrice;
    }

    @OneToOne
    @JsonBackReference
    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JoinColumn(name = "cart_id",updatable = false,insertable = false)
    User user;

    @OneToMany(mappedBy = "cart")
    @JsonManagedReference
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<ProductsCart> productsCartEntities;
}
