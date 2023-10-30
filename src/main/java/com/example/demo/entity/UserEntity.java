package com.example.demo.entity;

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
public class UserEntity {
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


    @OneToOne(mappedBy = "userEntity")
    @JsonManagedReference
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    WishlistEntity wishlistEntity;

    @OneToOne(mappedBy = "userEntity")
    @JsonManagedReference
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    CartEntity cartEntity;

}
