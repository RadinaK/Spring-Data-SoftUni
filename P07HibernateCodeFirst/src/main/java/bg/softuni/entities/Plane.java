package bg.softuni.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "planes")
public class Plane extends Vehicle {
    private final static String PLANE_TYPE = "PLANE";

    @Basic
    private int passengerCapacity;

    public Plane() {
        super(PLANE_TYPE);
    }

    public Plane(String model, String fuelType, int passengerCapacity) {
        this();
        super.model = model;
        super.fuelType = fuelType;
        this.passengerCapacity = passengerCapacity;
    }
}
