package com.belisario.ecommerceorders.controller;

import com.belisario.ecommerceorders.domain.dto.MessageDto;
import com.belisario.ecommerceorders.domain.dto.OrderDto;
import com.belisario.ecommerceorders.domain.model.Order;
import com.belisario.ecommerceorders.repository.OrderRepository;
import com.belisario.ecommerceorders.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping
    public ResponseEntity<MessageDto> testController() {
        MessageDto dto = new MessageDto("Orders API");

        return  ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto dto) {
        return ResponseEntity.ok(orderService.save(dto));
    }
}
