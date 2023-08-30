package com.belisario.ecommerceorders.controller;

import com.belisario.ecommerceorders.domain.dto.MessageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping
    public ResponseEntity<MessageDto> testController() {
        MessageDto dto = new MessageDto("Orders API");

        return  ResponseEntity.ok(dto);
    }
}
