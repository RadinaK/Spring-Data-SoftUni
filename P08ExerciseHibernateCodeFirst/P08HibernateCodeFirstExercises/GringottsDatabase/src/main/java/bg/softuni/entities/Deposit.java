package bg.softuni.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Deposit {

    @Id
    @Column
    private Long id;

    @Column(length = 20)
    private String group;

    @Column()
    private LocalDate startDay;

    @Column()
    private Double amount;

    @Column()
    private Double interest;

    @Column()
    private Double charge;

    @Column()
    private LocalDate expirationDate;

    @Column()
    private boolean isDepositExpired;
}
