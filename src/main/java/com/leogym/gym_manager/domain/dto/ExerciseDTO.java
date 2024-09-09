package com.leogym.gym_manager.domain.dto;

import com.leogym.gym_manager.domain.enuns.MuscleGroup;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "O nome não pode ser nulo")
    private String name;
    private String description;
    @NotNull(message = "O equipamento não pode ser nulo")
    private String equipment;
    @NotNull(message = "O grupo muscular não pode ser nulo")
    private MuscleGroup muscleGroup;

}
