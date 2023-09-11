package bg.softuni.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "competitions")
public class Competition extends BaseEntity {

    @Column(nullable = false)
    private String name;


}
