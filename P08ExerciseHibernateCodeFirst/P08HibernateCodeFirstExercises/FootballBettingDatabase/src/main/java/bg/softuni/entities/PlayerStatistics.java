package bg.softuni.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "player_statistics")
public class PlayerStatistics implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @Id
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @Column(name = "scored_goals")
    private Short scoredGoals;

    @Column(name = "player_assists")
    private Short playerAssists;

    @Column(name = "played_minutes")
    private Short playedMinutes;
}
