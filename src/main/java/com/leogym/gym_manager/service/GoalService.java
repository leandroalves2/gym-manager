package com.leogym.gym_manager.service;

import com.leogym.gym_manager.domain.dto.GoalDTO;

import java.util.List;

public interface GoalService {

    void saveOrUpdateGoal(GoalDTO goalDTO);
    GoalDTO getGoalById(Long id);
    List<GoalDTO> listGoal();

}
