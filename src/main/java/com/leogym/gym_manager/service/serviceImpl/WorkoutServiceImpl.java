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

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class WorkoutServiceImpl implements WorkoutService {

    private final WorkoutMapper workoutMapper;
    private final WorkoutRepository workoutRepository;

    @Override
    public void saveOrUpdateWorkout(WorkoutDTO workoutDTO) {
        if (isNull(workoutDTO.getId())) {
            try {
                Workout workoutEntity = new Workout();
                save(workoutDTO, workoutEntity);
            } catch (Exception e) {
                throw new BusinessException("Não foi possivel cadastrar a meta!");
            }
        } else {
            Workout workoutEntity = workoutRepository.findById(workoutDTO.getId())
                    .orElseThrow(() -> new BusinessException("Treino não encontrado com o id: " + workoutDTO.getId()));
            try {
                save(workoutDTO, workoutEntity);
            } catch (Exception e) {
                throw new BusinessException("Não foi possivel cadastrar a meta!");
            }
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
    public WorkoutDTO findWorkoutById(Long id) {
        Workout workoutEntity = workoutRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Treino não encontrado com o id: " + id));
        return toDto(workoutEntity);
    }

    @Override
    public WorkoutDTO findWorkoutByName(String name) {
        Workout workoutEntity = workoutRepository.findByName(name);
        if (workoutEntity == null) {
            throw new BusinessException("Treino não encontrado com o nome: " + name);
        }
        return toDto(workoutEntity);
    }

    @Override
    public String deleteWorkoutById(Long id) {
        try {
            workoutRepository.deleteById(id);
            return "Treino deletado com sucesso!";
        } catch (Exception ex) {
            throw new BusinessException("Não foi possivel salvar o treino!");
        }
    }

    public void save(WorkoutDTO workoutDTO, Workout workoutEntity) {
        workoutMapper.dtoToEntity(workoutDTO, workoutEntity);
        workoutRepository.save(workoutEntity);
    }

    private WorkoutDTO toDto(Workout workoutEntity) {
        WorkoutDTO workoutDTO = new WorkoutDTO();
        workoutMapper.entityToDto(workoutEntity, workoutDTO);
        return workoutDTO;
    }

}
