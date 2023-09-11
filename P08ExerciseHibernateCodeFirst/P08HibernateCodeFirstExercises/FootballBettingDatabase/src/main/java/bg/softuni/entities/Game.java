package bg.softuni.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "games")
public class Game extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "home_team")
    private Team homeTeam;

    @OneToOne
    @JoinColumn(name = "away_team")
    private Team awayTeam;

    @Column(name = "home_goals")
    private Short homeGoals;

    @Column(name = "away_goals")
    private Short awayGoals;

    @Column
    private Date date;

    @Column(name = "home_team_win_bet_rate")
    private Double homeTeamWinBetRate;

    @Column(name = "away_team_win_bet_rate")
    private Double awayTeamWinBetRate;

    @Column(name = "draw_game_win_bet_rate")
    private Double drawGameBetRate;

    // one to one || many to one
    @ManyToOne
    @JoinColumn
    private Round round;

    @ManyToOne
    @JoinColumn
    private Competition competition;
}
