package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "order_date")
    private String orderDate;

    @Column(name = "shipping_date")
    private String shippingDate;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "order_status")
    private String orderStatus;

}
