package com.jin.online_food_ordering.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.List;

@Data // getter, setter 의미
@Embeddable // 이걸로 분석하자
public class RestaurantDto {

    private String title;

    @Column(length = 1000) // url 문자열이 필요하다
    private List<String> images;

    private String description;
    private Long id;
}
