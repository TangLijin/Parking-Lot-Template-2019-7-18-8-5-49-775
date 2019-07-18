package com.thoughtworks.parking_lot.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private String name;

    @Length(min = 0)
    private int capacity;

    private String position;

    public ParkingLot() {
    }

    public ParkingLot(String name, @Length(min = 0) int capacity, String position) {
        this.name = name;
        this.capacity = capacity;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
