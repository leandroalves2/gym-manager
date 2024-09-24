package com.leogym.gym_manager.service.serviceImpl;

import com.leogym.gym_manager.domain.dto.ExerciseDTO;
import com.leogym.gym_manager.domain.entities.Exercise;
import com.leogym.gym_manager.exception.BusinessException;
import com.leogym.gym_manager.exception.NotFoundException;
import com.leogym.gym_manager.mapper.ExerciseMapper;
import com.leogym.gym_manager.repository.ExerciseRepository;
import com.leogym.gym_manager.service.ExerciseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    private final ExerciseMapper mapper;

    private final ExerciseRepository exerciseRepository;


    @Override
    public void saveOrUpdateExercise(ExerciseDTO exerciseDTO) {
        if (isNull(exerciseDTO.getId())) {
            try {
                Exercise exerciseEntity = new Exercise();
                saveExercise(exerciseDTO, exerciseEntity);
            } catch (Exception e) {
                throw new BusinessException("Não foi possivel cadastrar a meta!");
            }
        }
        try {
            Exercise entity = exerciseRepository.findById(exerciseDTO.getId())
                    .orElseThrow(() -> new BusinessException("Exercício não encontrado com o id: " + exerciseDTO.getId()));
            saveExercise(exerciseDTO, entity);
        } catch (Exception e) {
            throw new BusinessException("Não foi possivel cadastrar a meta!");
        }
    }

    @Override
    public List<ExerciseDTO> listExercice() {
        try {
            List<Exercise> exerciseList = exerciseRepository.findAll();
            List<ExerciseDTO> exerciseDTOList = new ArrayList<>();
            for (Exercise exercise : exerciseList) {
                exerciseDTOList.add(toDto(exercise));
            }
            return exerciseDTOList;
        } catch (Exception e) {
            throw new BusinessException("Erro ao localizar os exercicios!");
        }
    }

    public ExerciseDTO findExerciseById(Long id) {
        Exercise exerciseEntity = exerciseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Exercise not found with the id: " + id));
        try {
            ExerciseDTO exerciseDTO = new ExerciseDTO();

            exerciseDTO.setId(exerciseEntity.getId());
            exerciseDTO.setName(exerciseEntity.getName());
            exerciseDTO.setDescription(exerciseEntity.getDescription());
            exerciseDTO.setEquipment(exerciseEntity.getEquipment());
            exerciseDTO.setMuscleGroup(exerciseEntity.getMuscleGroup());

            return exerciseDTO;
        } catch (Exception ex) {
            throw new BusinessException("Error locating the exercises!");
        }
    }

    @Override
    public ExerciseDTO findyByName(String name) {
        Exercise exerciseEntity = exerciseRepository.findByName(name);
        if (exerciseEntity == null) {
            throw new BusinessException("Exercicio não encontrado com o nome: " + name);
        }
        try {
            return toDto(exerciseEntity);
        } catch (Exception ex) {
            throw new BusinessException("Erro ao localizar o exercicio!");
        }
    }

    @Override
    public void deleteExerciseById(Long id) {
        try {
            exerciseRepository.deleteById(id);
        } catch (Exception ex) {
            throw new BusinessException("Erro ao deletar o exercicio!");
        }
    }

    @Override
    public void deleteExerciseByName(String name) {
        try {
            Exercise exerciseEntity = exerciseRepository.findByName(name);
            exerciseRepository.deleteById(exerciseEntity.getId());
        } catch (Exception ex) {
            throw new BusinessException("Erro ao deletar o exercicio!");
        }
    }

    private void saveExercise(ExerciseDTO exerciseDTO, Exercise exerciseEntity) {
        mapper.dtoToEntity(exerciseDTO, exerciseEntity);
        exerciseRepository.save(exerciseEntity);
    }

    private ExerciseDTO toDto(Exercise exerciseEntity) {
        ExerciseDTO exerciseDTO = new ExerciseDTO();
        mapper.entityToDto(exerciseEntity, exerciseDTO);
        return exerciseDTO;
    }

}
