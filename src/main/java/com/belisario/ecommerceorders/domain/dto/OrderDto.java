package com.belisario.ecommerceorders.domain.dto;

import com.belisario.ecommerceorders.domain.model.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private String id;
    private String client;

    private List<String> itens;

    private BigDecimal totalValue;

    public static Order toOrder(OrderDto dto) {
        Order order = new Order();
        order.setClient(dto.getClient());
        order.setItens(dto.getItens());
        order.setTotalValue(dto.getTotalValue());
        return order;
    }

    public static OrderDto toDto(Order order) {
        OrderDto dto = new OrderDto();
        dto.setId(order.getId());
        dto.setClient(order.getClient());
        dto.setItens(order.getItens());
        dto.setTotalValue(order.getTotalValue());
        return dto;
    }

    public static OrderKafkaDto toKafkaDto(Order order) {
        OrderKafkaDto kafkaDto = new OrderKafkaDto();
        kafkaDto.setOrderId(order.getId());
        kafkaDto.setTotalValue(order.getTotalValue());
        return kafkaDto;
    }
}