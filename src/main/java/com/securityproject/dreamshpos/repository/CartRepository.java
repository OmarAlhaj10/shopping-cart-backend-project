package com.securityproject.dreamshpos.repository;

import com.securityproject.dreamshpos.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUserId(Long userId);
}