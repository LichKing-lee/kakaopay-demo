package com.kakaopay.kakaopaydemo.user;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    @EntityGraph(attributePaths = "kakaopayAccount")
    Optional<User> findById(Long aLong);
}
