package com.leogym.gym_manager.service;

import com.leogym.gym_manager.domain.dto.ExerciseDTO;

import java.util.List;

public interface ExerciseService {

    void saveExercise(ExerciseDTO dto);

    List<ExerciseDTO> listExercice();
    ExerciseDTO findById(Long id);
}
