package com.leogym.gym_manager.service;

import com.leogym.gym_manager.domain.dto.WorkoutDTO;

import java.util.List;

public interface WorkoutService {

    void saveOrUpdateWorkout(WorkoutDTO workoutDTO);
    List<WorkoutDTO> listWorkout();
    WorkoutDTO findWorkoutById(Long id);
    WorkoutDTO findWorkoutByName(String name);
    String deleteWorkoutById(Long id);

}
