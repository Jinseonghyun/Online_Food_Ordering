package com.jin.online_food_ordering.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne // 주문항목은 1개 이지만 동일한 음식을 주문한 주문자는 여러명일 수 있다.
    private Food food;

    private int quantity;

    private Long totalPrice;

    private List<String> ingredients;
}
