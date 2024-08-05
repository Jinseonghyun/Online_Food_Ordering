package com.jin.online_food_ordering.repository;

import com.jin.online_food_ordering.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    //사용자 찾기
    public User findByEmail(String username);
}
