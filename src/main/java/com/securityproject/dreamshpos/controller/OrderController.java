package com.securityproject.dreamshpos.controller;

import com.securityproject.dreamshpos.dto.OrderDto;
import com.securityproject.dreamshpos.exceptions.ResourceNotFoundException;
import com.securityproject.dreamshpos.model.Order;
import com.securityproject.dreamshpos.response.ApiResponse;
import com.securityproject.dreamshpos.service.order.IOrderService;
import com.securityproject.dreamshpos.service.payment.PaymentInfo;
import com.securityproject.dreamshpos.service.payment.PaymentService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/orders")
public class OrderController {
    private final IOrderService orderService;
    private final PaymentService paymentService;

    @PostMapping("/user/place-order")
    public ResponseEntity<ApiResponse> createOrder(@RequestParam Long userId) {
        try {
            Order order =  orderService.placeOrder(userId);
            OrderDto orderDto =  orderService.convertToDto(order);
            return ResponseEntity.ok(new ApiResponse("Items Order Success!", orderDto));
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("Error occurred!", e.getMessage()));
        }
    }

    @GetMapping("/{orderId}/order")
    public ResponseEntity<ApiResponse> getOrderById(@PathVariable Long orderId) {
        try {
            OrderDto order = orderService.getOrder(orderId);
            return ResponseEntity.ok(new ApiResponse("Item Order Success!", order));
        } catch (ResourceNotFoundException e) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Oops!", e.getMessage()));
        }
    }

    @GetMapping("/user/{userId}/order")
    public ResponseEntity<ApiResponse> getUserOrders(@PathVariable Long userId) {
        try {
            List<OrderDto> order = orderService.getUserOrders(userId);
            return ResponseEntity.ok(new ApiResponse("Item Order Success!", order));
        } catch (ResourceNotFoundException e) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Oops!", e.getMessage()));
        }
    }

    @PostMapping("/payment/create-payment-intent")
    public ResponseEntity<String> createPaymentIntent(@RequestBody PaymentInfo paymentInfo) throws StripeException {
        try {
            System.out.println("The body :" +paymentInfo);
            PaymentIntent paymentIntent = paymentService.createPaymentIntent(paymentInfo);
            String paymentString = paymentIntent.toJson();
            System.out.println("The payment string :" + paymentString);
            return ResponseEntity.ok(paymentString);
        } catch (StripeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
