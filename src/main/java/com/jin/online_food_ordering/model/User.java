package com.jin.online_food_ordering.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jin.online_food_ordering.dto.RestaurantDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullName;

    private String email;

    private USER_ROLE role;

    @JsonIgnore // 별도의 테이블을 생성하지 마시오
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer") // 주문엔티티가 고객에게 제공되는 필드
    private List<Order> orders = new ArrayList<>();

    @ElementCollection // 요소 수집이 필요하다 (유형은 아래 RestaurantDto)
    private List<RestaurantDto>favorites = new ArrayList();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) // 사용자는 이것과 관련된 모든 주소를 사용한다. (사용자가 자동으로 삭제)
    private List<Address> addresses = new ArrayList<>();

}
