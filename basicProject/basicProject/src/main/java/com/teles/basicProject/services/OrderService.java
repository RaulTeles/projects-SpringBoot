package com.teles.basicProject.services;

import com.teles.basicProject.entities.Order;
import com.teles.basicProject.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findByID(long id){
         Optional<Order> obj = orderRepository.findById(id);
        return obj.get();
    }


}
