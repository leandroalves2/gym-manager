package com.leogym.gym_manager.mapper;

import com.leogym.gym_manager.domain.dto.ProgressDTO;
import com.leogym.gym_manager.domain.dto.WorkoutDTO;
import com.leogym.gym_manager.domain.entities.Progress;
import com.leogym.gym_manager.domain.entities.Workout;
import com.leogym.gym_manager.exception.BusinessException;
import com.leogym.gym_manager.repository.ProgressRepository;
import com.leogym.gym_manager.repository.WorkoutRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.swing.plaf.ProgressBarUI;
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
        for(ProgressDTO progressDTO : workoutDTO.getProgressDTOList()) {
            Progress progressEntity = progressRepository.findById(progressDTO.getId())
                    .orElseThrow((()-> new BusinessException("Progresso não encontrado com o id informado: " + progressDTO.getId())));
            progressList.add(progressEntity);
        }
        workoutEntity.setProgressList(progressList);
    }

    public void entityToDto(Workout workoutEntity, WorkoutDTO workoutDTO) {
        workoutDTO.setId(workoutEntity.getId());
        workoutDTO.setName(workoutEntity.getName());
        workoutDTO.setData(workoutEntity.getData());
        List<ProgressDTO> progressDTOList = new ArrayList<>();
        for(Progress progress : workoutEntity.getProgressList()) {
            ProgressDTO progressDTO = new ProgressDTO();
            progressMapper.entityToDto(progress, progressDTO);
            progressDTOList.add(progressDTO);
        }
        workoutDTO.setProgressDTOList(progressDTOList);
    }
}
