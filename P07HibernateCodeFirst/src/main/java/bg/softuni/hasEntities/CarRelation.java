package bg.softuni.hasEntities;

import jakarta.persistence.*;

@Entity
@Table(name = "car_relations")
public class CarRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "plate_number_id", referencedColumnName = "id")
    private PlateNumber plateNumber;

    public CarRelation() {

    }

    public CarRelation(PlateNumber plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
