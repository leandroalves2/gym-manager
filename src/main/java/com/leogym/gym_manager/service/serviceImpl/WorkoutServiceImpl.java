package com.leogym.gym_manager.service.serviceImpl;

import com.leogym.gym_manager.domain.dto.WorkoutDTO;
import com.leogym.gym_manager.domain.entities.Workout;
import com.leogym.gym_manager.exception.BusinessException;
import com.leogym.gym_manager.mapper.WorkoutMapper;
import com.leogym.gym_manager.repository.WorkoutRepository;
import com.leogym.gym_manager.service.WorkoutService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<WorkoutDTO> listWorkout() {
        try {
            List<Workout> workoutList = workoutRepository.findAll();
            List<WorkoutDTO> workoutDTOList = new ArrayList<>();
            for (Workout workout : workoutList) {
                WorkoutDTO workoutDTO = new WorkoutDTO();
                workoutMapper.entityToDto(workout, workoutDTO);
                workoutDTOList.add(workoutDTO);
            }
            return workoutDTOList;
        } catch (Exception ex) {
            throw new BusinessException("Não foi possivel salvar o treino!");
        }

    }

    @Override
    public WorkoutDTO findById(Long id) {
        Workout workoutEntity = workoutRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Treino não encontrado com o id: " + id));
        return save(workoutEntity);
    }

    @Override
    public WorkoutDTO findByName(String name) {
        Workout workoutEntity = workoutRepository.findByName(name);
        if (workoutEntity == null) {
            throw new BusinessException("Treino não encontrado com o nome: " + name);
        }
        return save(workoutEntity);
    }

    private WorkoutDTO save(Workout workoutEntity) {
        WorkoutDTO workoutDTO = new WorkoutDTO();
        workoutMapper.entityToDto(workoutEntity, workoutDTO);
        return workoutDTO;
    }

}
