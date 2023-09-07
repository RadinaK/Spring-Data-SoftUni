package bg.softuni.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cars")
public class Car extends PassengerVehicle {
    private final static String CAR_TYPE = "CAR";

    @Basic
    private int seats;

    public Car() {
//        super(CAR_TYPE);
    }

    public Car(String type,int numOfPassengers){
        super(type, numOfPassengers);
    }

    public Car(String model, String fuelType, int seats) {
        this();
        super.model = model;
        super.fuelType = fuelType;
        this.seats = seats;
    }
}
