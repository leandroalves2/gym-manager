package com.leogym.gym_manager.mapper;

import com.leogym.gym_manager.domain.dto.GoalDTO;
import com.leogym.gym_manager.domain.entities.Goal;
import org.springframework.stereotype.Component;

@Component
public class GoalMapper {

    public void dtoToEntity(GoalDTO goalDTO, Goal goalEntity) {
        goalEntity.setDescription(goalDTO.getDescription());
        goalEntity.setTargetDate(goalDTO.getTargetDate());
        goalEntity.setCompleted(goalDTO.isCompleted());
    }

    public void entityToDto(Goal goalEntity, GoalDTO goalDTO) {
        goalDTO.setDescription(goalEntity.getDescription());
        goalDTO.setTargetDate(goalEntity.getTargetDate());
        goalDTO.setCompleted(goalEntity.isCompleted());
    }

}