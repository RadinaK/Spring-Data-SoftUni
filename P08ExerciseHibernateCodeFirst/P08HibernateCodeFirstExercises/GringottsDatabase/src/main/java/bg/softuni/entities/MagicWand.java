package bg.softuni.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "magic_wand")
public class MagicWand {

    @Id
    @Column
    private Long id;

    @Column(length = 100)
    private String creator;

    @Column
    private Long size;
}
