package bg.softuni.hasEntities;

import jakarta.persistence.*;

@Entity
@Table(name = "plate_numbers")
public class PlateNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private String plateNumber;

    @OneToOne(targetEntity = CarRelation.class, mappedBy = "plateNumber")
    private CarRelation carRelation;

    public PlateNumber(){

    }

    public PlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
