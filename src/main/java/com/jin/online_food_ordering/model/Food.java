package com.jin.online_food_ordering.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private Long price;

    @ManyToOne
    private Category foodCategory;

    @Column(length = 1000)
    @ElementCollection // 요소 컬렉션을 제공하여 음식을 위한 별도의 테이블이 생성됩니다.
    private List<String> images;

    private boolean available;

    @ManyToOne // 음식이 여러개 일 때 가게는 1개
    private Restaurant restaurant;

    private boolean isVegetarian;
    private boolean isSeasonal;

    @ManyToMany // 하나의 음식안에는 여러가지 재료가 있기 때문
    private List<IngredientsItem> ingredients = new ArrayList<>();

    private Date creationDate;
}
