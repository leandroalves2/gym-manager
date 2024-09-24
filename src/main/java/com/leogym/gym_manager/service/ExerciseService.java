package com.leogym.gym_manager.service;

import com.leogym.gym_manager.domain.dto.ExerciseDTO;

import java.util.List;

public interface ExerciseService {

    void saveOrUpdateExercise(ExerciseDTO exerciseDTO);

    List<ExerciseDTO> listExercice();
    ExerciseDTO findExerciseById(Long id);
    ExerciseDTO findyExerciseByName(String name);
    void deleteExerciseById(Long id);
    void deleteExerciseByName(String name);


}
