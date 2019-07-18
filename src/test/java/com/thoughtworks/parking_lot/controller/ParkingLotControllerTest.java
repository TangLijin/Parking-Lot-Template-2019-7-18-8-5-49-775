package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParkingLotControllerTest {
    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void init(){
        parkingLotRepository.deleteAll();
    }

    @Test
    public void  should_return_the_saved_parking_lot_when_addparking(){

        ParkingLot parkingLot = new ParkingLot("pakingLotA",38,"tang jia");
        parkingLotRepository.save(parkingLot);

        Assertions.assertEquals(parkingLot,parkingLotRepository.findAll());

    }
}