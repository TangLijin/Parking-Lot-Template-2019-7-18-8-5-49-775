package com.thoughtworks.parking_lot.repository;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ParkingLotRepositoryTest {

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @BeforeEach
    public void init(){
        parkingLotRepository.deleteAll();
    }

    @Test
    public void should_return_the_parking_lot_when_add_parking_lot(){

    }


}