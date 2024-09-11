package com.leogym.gym_manager.mapper;

import com.leogym.gym_manager.domain.dto.ProgressDTO;
import com.leogym.gym_manager.domain.dto.WorkoutDTO;
import com.leogym.gym_manager.domain.entities.Progress;
import com.leogym.gym_manager.domain.entities.Workout;
import com.leogym.gym_manager.exception.BusinessException;
import com.leogym.gym_manager.repository.ProgressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class WorkoutMapper {

    private final ProgressRepository progressRepository;

    public void dtoToEntity(WorkoutDTO workoutDTO, Workout workoutEntity) {

        workoutEntity.setData(workoutDTO.getData());

        List<Progress> progressList = new ArrayList<>();
        for(ProgressDTO progressDTO : workoutDTO.getProgressDTOList()) {
            Progress progressEntity = progressRepository.findById(progressDTO.getId())
                    .orElseThrow((()-> new BusinessException("Progresso não encontrado com o id informado: " + progressDTO.getId())));
            progressList.add(progressEntity);
        }
        workoutEntity.setProgressList(progressList);
    }

}
