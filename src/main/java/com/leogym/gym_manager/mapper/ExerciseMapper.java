package com.leogym.gym_manager.mapper;

import com.leogym.gym_manager.domain.dto.ExerciseDTO;
import com.leogym.gym_manager.domain.entities.Exercise;
import org.springframework.stereotype.Component;

@Component
public class ExerciseMapper {

    public void dtoToEntity(ExerciseDTO dto, Exercise entity) {
        if(dto.getId() != null) {
            entity.setId(dto.getId());
        }
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setEquipment(dto.getEquipment());
        entity.setMuscleGroup(dto.getMuscleGroup());
    }

    public void entityToDto(Exercise entity, ExerciseDTO dto) {
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setEquipment(entity.getEquipment());
        dto.setMuscleGroup(entity.getMuscleGroup());
    }
}