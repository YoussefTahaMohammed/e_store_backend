package com.example.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    Integer userId;

    @Column(name = "username")
    String username;

    @Column(name = "email")
    String email;

    @Column(name = "password")
    String password;

    @Column(name = "wishlist_id")
    Integer wishlistId;

    @Column(name = "cart_id")
    Integer cartId;


    @OneToOne(mappedBy = "user")
    @JsonManagedReference
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Wishlist wishlist;

    @OneToOne(mappedBy = "user")
    @JsonManagedReference
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Cart cart;

}
