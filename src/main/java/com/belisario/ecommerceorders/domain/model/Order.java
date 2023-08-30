package com.belisario.ecommerceorders.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("orders")
public class Order {

    @Id
    private String id;

    private String client;

    private List<String> itens;

    private BigDecimal totalValue;
}
