package com.leogym.gym_manager.service;

import com.leogym.gym_manager.domain.dto.WorkoutDTO;

import java.util.List;

public interface WorkoutService {

    String saveWorkout(WorkoutDTO workoutDTO);
    List<WorkoutDTO> listWorkout();
    WorkoutDTO findById(Long id);
    WorkoutDTO findByName(String name);

}
