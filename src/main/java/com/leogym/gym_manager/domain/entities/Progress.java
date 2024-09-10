package com.leogym.gym_manager.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "progress_tb")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToOne
    @JoinColumn(name = "exercicio_id", referencedColumnName = "id")
    private Exercise exercise;
    private int sets;
    private double weight;
    private int repetitions;


}
