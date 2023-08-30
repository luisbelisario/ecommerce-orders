package com.belisario.ecommerceorders.repository;

import com.belisario.ecommerceorders.domain.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

    public Order findByClient(String client);
}
