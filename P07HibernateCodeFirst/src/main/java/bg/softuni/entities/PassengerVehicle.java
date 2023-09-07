package bg.softuni.entities;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class PassengerVehicle extends Vehicle {

    private int numOfPassengers;

    public PassengerVehicle() {
    }

    public PassengerVehicle(String type, int numOfPassengers) {
        super(type);
        this.numOfPassengers = numOfPassengers;
    }

    // Getters and setters
}


