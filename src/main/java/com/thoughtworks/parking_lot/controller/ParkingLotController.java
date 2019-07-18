package com.thoughtworks.parking_lot.controller;


import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parkingLot")
public class ParkingLotController {

    @Autowired
    static protected ParkingLotRepository parkingLotRepository;

    private List<ParkingLot> parkingLots ;



    @GetMapping
    public List<ParkingLot> init(){
        parkingLotRepository.deleteAll();
        parkingLotRepository.saveAll(ParkingLot.createParkingLots());
        parkingLotRepository.findAll().stream().forEach(i -> System.out.println(i.toString()));
        return parkingLotRepository.findAll();
    }

    @PostMapping
    public ParkingLot addParkingLot(@RequestBody ParkingLot parkingLot){
        System.out.println("--------------");
        System.out.println(parkingLot);
         parkingLotRepository.save(parkingLot);
         return parkingLotRepository.findAll().get(0);
        //return parkingLotRepository.findAll();
    }

    @PostMapping("/{id}")
    public List<ParkingLot>  deleteParkingLot(@PathVariable Long id){
        parkingLotRepository.deleteById(id);
        return parkingLotRepository.findAll();
        //return parkingLotRepository.findAll();
    }

//

    @GetMapping("/{id}")
    public String  showParkingLotsAccodingToPage(@PathVariable Long id){
        return parkingLotRepository.findById(id).get().toString();
        //return parkingLotRepository.findAll();
    }

    @PutMapping("/{id}")
    public List<ParkingLot>  updateParkingLot(@PathVariable Long id,@RequestParam Long newCapacity){
        parkingLotRepository.findById(id).get().setCapacity(newCapacity);
        return parkingLotRepository.findAll();
        //return parkingLotRepository.findAll();
    }

}
