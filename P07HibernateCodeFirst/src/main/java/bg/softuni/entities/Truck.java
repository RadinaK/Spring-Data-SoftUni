package bg.softuni.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "trucks")
public class Truck extends Vehicle {
    private final static String TRUCK_TYPE = "TRUCK";

    @Basic
    private double loadCapacity;

    public Truck() {
        super(TRUCK_TYPE);
    }

    public Truck(String model, String fuelType, double loadCapacity) {
        this();
        super.model = model;
        super.fuelType = fuelType;
        this.loadCapacity = loadCapacity;
    }
}
