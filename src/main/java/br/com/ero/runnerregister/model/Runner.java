package br.com.ero.runnerregister.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_RUNNER")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Runner implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID tb_runnerId;
    @Column (nullable = false, length = 40)

    private String tb_runner_name;
    @Column (nullable = false, length = 2)
    private int tb_runner_age;
    @Column (nullable = false, length = 50)
    private String tb_runner_address;
    @Column (nullable = false, unique = true, length = 5)
    private int tb_runner_number;
    @ManyToOne
    @JoinColumn(name = "tb_raceId")
    private Race race;



}
