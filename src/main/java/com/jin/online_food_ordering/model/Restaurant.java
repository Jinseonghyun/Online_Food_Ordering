package com.jin.online_food_ordering.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private User owner;

    private String name;

    private String description;

    private String cuisineType;

    @OneToOne
    private Address address;

    @Embedded // ContactInformation 클래스의 필드가 Restaurant 테이블에 속한 컬럼으로 저장된다
    private ContactInformation contactInformation; // ContactInformation은 독립적인 엔티티로 저장되는 것이 아니라, 그 필드들이 Restaurant 테이블에 속하게 됩니다

    private String openingHours;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL) // 하나의 가게에 여러개 주문  // 스프링부트에세 말한다 별도의 테이블을 만들지 말고 바로 restaurant 으로 가주세요
    private List<Order> orders = new ArrayList<>();

    @ElementCollection // 컬렉션 타입의 필드를 사용할 때, 이 컬렉션이 별도의 테이블에 저장되도록 합니다
    @Column(length = 1000)
    private List<String> images; // List<String> 타입의 이미지 URL 목록을 저장, images와 관련된 데이터는 기본적으로 Restaurant 엔티티와 관련된 테이블에서 관리

    private LocalDateTime registrationDate;

    private boolean open;

    @JsonIgnore //순환 참조 방지: Food 클래스에도 Restaurant를 참조하는 필드가 있다면, JSON 직렬화 과정에서 서로를 참조하면서 무한 루프가 발생할 수 있다.
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Food> foods = new ArrayList<>();
}
