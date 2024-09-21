package com.leogym.gym_manager.service;

import com.leogym.gym_manager.domain.dto.GoalDTO;

public interface GoalService {

    void saveGoal(GoalDTO goalDTO);
    GoalDTO getGoalById(Long id);

}
