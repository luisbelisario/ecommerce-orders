package com.belisario.ecommerceorders.service;

import com.belisario.ecommerceorders.domain.dto.OrderKafkaDto;
import com.belisario.ecommerceorders.domain.dto.OrderDto;
import com.belisario.ecommerceorders.domain.model.Order;
import com.belisario.ecommerceorders.repository.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public OrderDto save(OrderDto dto) {
        try {
            Order order = OrderDto.toOrder(dto);
            orderRepository.save(order);

            OrderKafkaDto kafkaDto = OrderDto.toKafkaDto(order);
            ObjectMapper objectMapper = new ObjectMapper();

            String kafkaDtoAsString = objectMapper.writeValueAsString(kafkaDto);

            kafkaTemplate.send("NEW_ORDER", order.getId(), kafkaDtoAsString);

            return OrderDto.toDto(order);
        } catch (Exception ex) {
            throw new RuntimeException("Não foi possível gerar o pedido");
        }
    }
}
