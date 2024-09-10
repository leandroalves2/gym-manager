package com.leogym.gym_manager.mapper;

import com.leogym.gym_manager.domain.dto.ExerciseDTO;
import com.leogym.gym_manager.domain.dto.ProgressDTO;
import com.leogym.gym_manager.domain.entities.Exercise;
import com.leogym.gym_manager.domain.entities.Progress;
import com.leogym.gym_manager.exception.BusinessException;
import com.leogym.gym_manager.repository.ExerciseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ProgressMapper {

    private final ExerciseRepository exerciseRepository;


    public void dtoToEntity(ProgressDTO progressDTO, Progress progressEntity) {
        Exercise exerciseEntity = exerciseRepository.findById(progressDTO.getExerciseId())
                .orElseThrow(() -> new BusinessException("Exercício não encontrado com o id: " +
                        progressDTO.getExerciseId()));
        progressEntity.setExercise(exerciseEntity);
        progressEntity.setWeight(progressDTO.getWeight());
        progressEntity.setRepetitions( progressDTO.getRepetitions());
    }

    public void entityToDto(Progress progressEntity, ProgressDTO progressDTO) {
        progressDTO.setId(progressEntity.getId());
        progressDTO.setExerciseId(progressEntity.getExercise().getId());
        progressEntity.setSets(progressDTO.getSets());
        progressDTO.setWeight(progressEntity.getWeight());
        progressDTO.setRepetitions(progressEntity.getRepetitions());
    }


}
