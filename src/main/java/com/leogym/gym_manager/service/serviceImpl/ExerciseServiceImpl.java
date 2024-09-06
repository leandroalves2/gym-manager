package com.leogym.gym_manager.service.serviceImpl;

import com.leogym.gym_manager.domain.dto.ExerciseDTO;
import com.leogym.gym_manager.domain.entities.Exercise;
import com.leogym.gym_manager.exception.BusinessException;
import com.leogym.gym_manager.mapper.ExerciseMapper;
import com.leogym.gym_manager.repository.ExerciseRepository;
import com.leogym.gym_manager.service.ExerciseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    private final ExerciseMapper mapper;

    private final ExerciseRepository repository;


    @Override
    public void saveExercise(ExerciseDTO dto) {


            Exercise entity = new Exercise();
            mapper.dtoToEntity(dto, entity);
            repository.save(entity);
    }

    @Override
    public List<ExerciseDTO> listExercice() {
        try {


            List<Exercise> exerciseList = repository.findAll();
            List<ExerciseDTO> exerciseDTOList = new ArrayList<>();
            for (Exercise exercise : exerciseList) {
                ExerciseDTO exerciseDTO = new ExerciseDTO();
                mapper.entityToDto(exercise, exerciseDTO);
                exerciseDTOList.add(exerciseDTO);
            }
            return exerciseDTOList;
        } catch (Exception e) {
            throw new BusinessException("Erro ao localizar os exercicios!");
        }
    }

    @Override
    public ExerciseDTO findById(Long id) {

        try {

            Exercise entity = repository.findById(id)
                    .orElseThrow(() -> new BusinessException("Exercício não encontrado com o id: " + id));
            ExerciseDTO dto = new ExerciseDTO();
            mapper.entityToDto(entity, dto);
            return dto;
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            throw new BusinessException("Erro ao localizar o exercicio!");
        }

    }
}
