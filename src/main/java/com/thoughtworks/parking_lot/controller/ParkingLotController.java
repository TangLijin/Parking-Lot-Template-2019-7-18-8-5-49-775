package com.thoughtworks.parking_lot.controller;


import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parkingLot")
public class ParkingLotController {

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    private List<ParkingLot> parkingLots ;


    @PostMapping
    public ParkingLot addParkingLot(@RequestBody ParkingLot parkingLot){
        System.out.println("--------------");
        System.out.println(parkingLot);
         parkingLotRepository.save(parkingLot);
         return parkingLotRepository.findAll().get(0);
        //return parkingLotRepository.findAll();
    }

}
