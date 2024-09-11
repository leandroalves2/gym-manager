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
    private final ProgressMapper progressMapper;

    public void dtoToEntity(WorkoutDTO workoutDTO, Workout workoutEntity) {
        if (workoutDTO.getId() != null) {
            workoutEntity.setId(workoutDTO.getId());
        }
        workoutEntity.setName(workoutDTO.getName());
        workoutEntity.setData(workoutDTO.getData());
        List<Progress> progressList = new ArrayList<>();
        for(Long progressDTOId : workoutDTO.getProgressDTOList()) {
            Progress progressEntity = progressRepository.findById(progressDTOId)
                    .orElseThrow((()-> new BusinessException("Progresso não encontrado com o id informado: " + progressDTOId)));
            progressList.add(progressEntity);
        }
        workoutEntity.setProgressIdList(progressList);
    }

    public void entityToDto(Workout workoutEntity, WorkoutDTO workoutDTO) {
        workoutDTO.setId(workoutEntity.getId());
        workoutDTO.setName(workoutEntity.getName());
        workoutDTO.setData(workoutEntity.getData());
        List<Long> progressDTOIdList = new ArrayList<>();
        for(Progress progress : workoutEntity.getProgressIdList()) {
            ProgressDTO progressDTO = new ProgressDTO();
            progressMapper.entityToDto(progress, progressDTO);
            progressDTOIdList.add(progressDTO.getId());
        }
        workoutDTO.setProgressDTOList(progressDTOIdList);
    }
}
