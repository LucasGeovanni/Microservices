package com.example.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.client.PaymentClient;
import com.example.model.Order;
import com.example.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order save(@Validated Order order) {
        order.setCode( UUID.randomUUID().toString() );
        return orderRepository.save(order);
    }

    public Order findById(Integer id){
        return orderRepository.findOne(id);
    }

    public Iterable<Order> findAll(){
        return orderRepository.findAll();
    }

    public void delete(Integer id) {
        orderRepository.delete(id);
    }
}
