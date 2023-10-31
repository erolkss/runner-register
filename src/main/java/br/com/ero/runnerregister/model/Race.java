package br.com.ero.runnerregister.model;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_RACE")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tb_raceId;
    @Column (nullable = false, length = 20)
    private String tb_race_runner_category;
    @Column (nullable = false, length = 20)
    private String tb_race_category;
    @Column (nullable = false, length = 3)
    private int tb_race_distance_km;



}
