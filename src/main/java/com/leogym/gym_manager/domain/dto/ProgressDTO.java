package com.leogym.gym_manager.domain.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProgressDTO {

    private Long id;
    @NotNull(message = "O exercicio não pode ser nulo")
    private Long exerciseId;
    private double weight;
    private int repetitions;

}
