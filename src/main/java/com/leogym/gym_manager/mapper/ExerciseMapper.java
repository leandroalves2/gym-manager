package com.leogym.gym_manager.mapper;

import com.leogym.gym_manager.domain.dto.ExerciseDTO;
import com.leogym.gym_manager.domain.entities.Exercise;
import org.springframework.stereotype.Component;

@Component
public class ExerciseMapper {

    public void dtoToEntity(ExerciseDTO dto, Exercise entity) {

        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setEquipment(dto.getEquipment());
        entity.setRepetitions(dto.getRepetitions());
        entity.setMuscleGroup(dto.getMuscleGroup());
        entity.setWeight(dto.getWeight());

    }

}
