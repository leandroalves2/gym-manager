package com.leogym.gym_manager.mapper;

import com.leogym.gym_manager.domain.dto.ExerciseDTO;
import com.leogym.gym_manager.domain.entities.Exercise;
import org.springframework.stereotype.Component;

@Component
public class ExerciseMapper {

    public void dtoToEntity(ExerciseDTO exerciseDTO, Exercise exerciseEntity) {
        if(exerciseDTO.getId() != null) {
            exerciseEntity.setId(exerciseDTO.getId());
        }
        exerciseEntity.setName(exerciseDTO.getName());
        exerciseEntity.setDescription(exerciseDTO.getDescription());
        exerciseEntity.setEquipment(exerciseDTO.getEquipment());
        exerciseEntity.setMuscleGroup(exerciseDTO.getMuscleGroup());
    }

    public void entityToDto(Exercise exerciseEntity, ExerciseDTO exerciseDTO) {
        exerciseDTO.setId(exerciseEntity.getId());
        exerciseDTO.setName(exerciseEntity.getName());
        exerciseDTO.setDescription(exerciseEntity.getDescription());
        exerciseDTO.setEquipment(exerciseEntity.getEquipment());
        exerciseDTO.setMuscleGroup(exerciseEntity.getMuscleGroup());
    }
}