package bg.softuni.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Wizard {

    @Id
    @Column
    private Long id;

    @Column(length = 50)
    private String firstName;

    @Column(length = 60, nullable = false)
    private String lastName;

    @Column(length = 1000)
    private String notes;

    @Column(nullable = false)
    private int age;

    @OneToOne
    @JoinColumn
    private MagicWand magicWand;

    @OneToMany
    @JoinTable(
            name = "wizard_deposits",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "deposit_id")
    )
    private List<Deposit> deposits;
}
