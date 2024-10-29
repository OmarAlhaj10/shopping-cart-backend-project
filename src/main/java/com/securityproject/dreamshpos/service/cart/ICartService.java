package com.securityproject.dreamshpos.service.cart;

import com.securityproject.dreamshpos.dto.CartDto;
import com.securityproject.dreamshpos.model.Cart;
import com.securityproject.dreamshpos.model.User;

import java.math.BigDecimal;

public interface ICartService {
    Cart getCart(Long id);
    void clearCart(Long id);
    BigDecimal getTotalPrice(Long id);

    Cart initializeNewCart(User user);

    Cart getCartByUserId(Long userId);

    CartDto convertToDto(Cart cart);
}
