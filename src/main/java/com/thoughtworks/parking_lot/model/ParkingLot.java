package com.thoughtworks.parking_lot.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Long id;

    @Column(unique = true)
    private String name;

    @Min(value = 0)
    private Long capacity;

    private String position;

    public ParkingLot() {
    }

    public ParkingLot(String name, @Length(min = 0) Long capacity, String position) {
        this.name = name;
        this.capacity = capacity;
        this.position = position;
    }

    public static List<ParkingLot> createParkingLots (){
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot("parkingLotA", 38L, "tang jia");
        ParkingLot parkingLot2 = new ParkingLot("parkingLotB", 58L, "nan ruan");
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        return parkingLots;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "id:" + this.id + "\n" + "name:" + this.name + "\n" + "capacity:"
                + this.capacity + "\n" + "position:" + this.position;
    }
}
