package com.thoughtworks.parking_lot.controller;


import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parkingLot")
public class ParkingLotController {

    private List<ParkingLot> parkingLots ;
    private ParkingLotRepository parkingLotRepository;

    @PostMapping
    public ParkingLot addParkingLot(ParkingLot parkingLot){
        return parkingLotRepository.save(parkingLot);
        //return parkingLotRepository.findAll();
    }

}
