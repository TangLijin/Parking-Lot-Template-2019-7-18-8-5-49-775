package com.thoughtworks.parking_lot.model;

import javax.persistence.*;

@Entity
public class Order {
//    订单号
//            停车场名字
//    车牌号
//    创建时间（进来时显示屏上的时间）
//    结束时间（离开时显示屏上的时间）
//    订单状态（默认开启）

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private String parkingLotName;

    private String carId;

    private String startTime;

    private String endTime;

    @Column(columnDefinition = "OPEN")
    private String state;

    public Order() {
    }

    public Order(String parkingLotName, String carId, String startTime, String endTime, String state) {
        this.parkingLotName = parkingLotName;
        this.carId = carId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.state = state;
    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    public void setParkingLotName(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "id:" + this.id + "\n" +
                "parkingLotName:" + this.parkingLotName + "\n" +
                "carId:" + this.carId + "\n" +
                "startTime:" + this.startTime + "\n" +
                "endTime:" + this.endTime + "\n" +
                "state:" + this.state + "\n";
    }
}
