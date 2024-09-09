package com.leogym.gym_manager.mapper;

import com.leogym.gym_manager.domain.dto.ExerciseDTO;
import com.leogym.gym_manager.domain.dto.ProgressDTO;
import com.leogym.gym_manager.domain.entities.Exercise;
import com.leogym.gym_manager.domain.entities.Progress;
import com.leogym.gym_manager.service.ExerciseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ProgressMapper {

    private final ExerciseService exerciseService;
    private final ExerciseMapper exerciseMapper;


    public void dtoToEntity(ProgressDTO dto, Progress entity) {
            ExerciseDTO exercisedto = exerciseService.findById(dto.getExerciseId());
            Exercise exerciseEntity = new Exercise();
            exerciseMapper.dtoToEntity(exercisedto, exerciseEntity);
            entity.setExercise(exerciseEntity);
            entity.setRepetitions( dto.getRepetitions());
            entity.setWeight(dto.getWeight());
    }


}
