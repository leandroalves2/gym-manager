package com.leogym.gym_manager.domain.dto;

import com.leogym.gym_manager.domain.enuns.MuscleGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseDTO {

    private Long id;
    private String name;
    private String description;
    private String equipment;
    private MuscleGroup muscleGroup;

}
