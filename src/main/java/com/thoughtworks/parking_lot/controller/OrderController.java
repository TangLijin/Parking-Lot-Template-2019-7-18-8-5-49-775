package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.model.Order;
import com.thoughtworks.parking_lot.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/1/{carId}")
    public Order createOrder(@PathVariable String carId){
        //orderRepository.deleteAll();
        long openOrderCount = orderRepository.findAll().stream().filter(i -> i.getState().toUpperCase() == "OPEN").count();
        if(ParkingLotController.parkingLotRepository.findById(1L).get().getCapacity() - openOrderCount <= 0){
            return null;
        }
        Order order = new Order();
        order.setCarId(carId);
        order.setStartTime(Long.toString(System.currentTimeMillis()));
        order.setStartTime("------------------");
        order.setState("OPEN");

        orderRepository.saveAndFlush(order);
        orderRepository.findAll().stream().forEach(i -> System.out.println(i.toString()));
        return orderRepository.findById(order.getId()).get();
    }

    @PutMapping("/1/{carId}")
    public List<Order> closeOrder(@PathVariable String carId){
        //orderRepository.deleteAll();
        long orderId = 0;
        for(Order order: orderRepository.findAll()){
            if(order.getCarId() == carId)
                orderId = order.getId();
        }
        
        orderRepository.findById(orderId).get().setState("CLOSE");
        orderRepository.findById(orderId).get().setEndTime(Long.toString(System.currentTimeMillis()));
        return orderRepository.findAll();
    }



}
