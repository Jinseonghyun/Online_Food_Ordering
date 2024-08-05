package com.jin.online_food_ordering.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne // 주문이 많아도 유저는 1명
    private User customer;

    @JsonIgnore // 한가지 레스토랑에서 여러개 주문이 되는게 아니다. 여러 레스토랑일 수도 있기 때문에 아래가 필요하지 않을 수 있다.
    @ManyToOne // 레스토랑에 대한 주문이 여러개 일수 있다.
    private Restaurant restaurant;

    private Long totalAmount;

    private String orderStatus;

    private Date createdAt;

    @ManyToOne // 주문이 여러개여도 주소는 1개
    private Address deliveryAddress;

    @OneToMany // 항목은 1개의 주문이지만 수량이 여러개일수 있다.
    private List<OrderItem> items;

    // 결제 수단
//    private Payment payment;

    private int totalItem;

    private int totalPrice;
}
