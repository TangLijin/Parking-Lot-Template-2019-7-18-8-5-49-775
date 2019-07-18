package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.model.Order;
import com.thoughtworks.parking_lot.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/1/{carId}")
    public Order createOrder(@PathVariable String carId){
        //orderRepository.deleteAll();
        if(ParkingLotController.parkingLotRepository.findById(1L).get().getCapacity() - orderRepository.count() <= 0){
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



}
