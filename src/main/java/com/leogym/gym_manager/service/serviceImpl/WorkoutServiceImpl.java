package com.leogym.gym_manager.service.serviceImpl;

import com.leogym.gym_manager.domain.dto.WorkoutDTO;
import com.leogym.gym_manager.domain.entities.Workout;
import com.leogym.gym_manager.exception.BusinessException;
import com.leogym.gym_manager.mapper.WorkoutMapper;
import com.leogym.gym_manager.repository.WorkoutRepository;
import com.leogym.gym_manager.service.WorkoutService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WorkoutServiceImpl implements WorkoutService {

    private final WorkoutMapper workoutMapper;
    private final WorkoutRepository workoutRepository;

    @Override
    public String saveWorkout(WorkoutDTO workoutDTO) {
        try {
            Workout workoutEntity = new Workout();
            workoutMapper.dtoToEntity(workoutDTO, workoutEntity);
            workoutRepository.save(workoutEntity);
            return "Treino salvo com sucesso!";
        } catch (Exception ex) {
            throw new BusinessException("Não foi possivel salvar o treino!");
        }
    }
}
