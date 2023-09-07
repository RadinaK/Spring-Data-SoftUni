package bg.softuni.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "bikes")
public class Bike extends Vehicle {
    private final static String BIKE_TYPE = "BIKE";

    public Bike() {
        super(BIKE_TYPE);
    }
}
