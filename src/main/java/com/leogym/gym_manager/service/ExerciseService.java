package com.leogym.gym_manager.service;

import com.leogym.gym_manager.domain.dto.ExerciseDTO;
import com.leogym.gym_manager.domain.entities.Exercise;

import java.util.List;

public interface ExerciseService {

    String saveOrUpdateExercise(ExerciseDTO dto);

    List<ExerciseDTO> listExercice();
    ExerciseDTO findById(Long id);
    ExerciseDTO findyByName(String name);

}
