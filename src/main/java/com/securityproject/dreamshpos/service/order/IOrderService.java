package com.securityproject.dreamshpos.service.order;

import com.securityproject.dreamshpos.dto.OrderDto;
import com.securityproject.dreamshpos.model.Order;

import java.util.List;

public interface IOrderService {
    Order placeOrder(Long userId);

    OrderDto getOrder(Long orderId);

    List<OrderDto> getUserOrders(Long userId);

    OrderDto convertToDto(Order order);
}
