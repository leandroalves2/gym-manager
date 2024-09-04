package com.leogym.gym_manager.domain.entities;


import com.leogym.gym_manager.domain.enuns.MuscleGroup;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "exercise_tb")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String description;
    private String equipment;
    private int repetitions;
    @Enumerated(EnumType.STRING)
    private MuscleGroup muscleGroup;
    private double weight;

}
