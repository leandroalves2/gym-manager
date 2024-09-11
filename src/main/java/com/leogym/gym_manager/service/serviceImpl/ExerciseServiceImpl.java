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

@Service
@AllArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    private final ExerciseMapper mapper;

    private final ExerciseRepository repository;


    @Override
    public String saveOrUpdateExercise(ExerciseDTO exerciseDTO) {
        if(exerciseDTO.getId() == null){
            Exercise exerciseEntity = new Exercise();
            saveExercise(exerciseDTO, exerciseEntity);
            return "Exercicio cadastrado com sucesso!";
        } else {
            Exercise entity = repository.findById(exerciseDTO.getId())
                    .orElseThrow(() -> new BusinessException("Exercício não encontrado com o id: " + exerciseDTO.getId()));
            saveExercise(exerciseDTO, entity);
            return "Exercicio atualizado com sucesso!";
        }
    }

    @Override
    public List<ExerciseDTO> listExercice() {
        try {
            List<Exercise> exerciseList = repository.findAll();
            List<ExerciseDTO> exerciseDTOList = new ArrayList<>();
            for (Exercise exercise : exerciseList) {
                exerciseDTOList.add(toDto(exercise));
            }
            return exerciseDTOList;
        } catch (Exception e) {
            throw new BusinessException("Erro ao localizar os exercicios!");
        }
    }

    public ExerciseDTO findById(Long id) {
        Exercise exerciseEntity = repository.findById(id)
                .orElseThrow(() -> new BusinessException("Exercício não encontrado com o id: " + id));
        try {
            return toDto(exerciseEntity);
        } catch (Exception ex) {
            throw new BusinessException("Erro ao localizar o exercicio!");
        }
    }

    @Override
    public ExerciseDTO findyByName(String name) {
        Exercise exerciseEntity = repository.findByName(name);
        if (exerciseEntity == null){
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
            repository.deleteById(id);
        } catch (Exception ex) {
            throw new BusinessException("Erro ao deletar o exercicio!");
        }
    }

    @Override
    public void deleteExerciseByName(String name) {
        try {
            Exercise exerciseEntity = repository.findByName(name);
            repository.deleteById(exerciseEntity.getId());
        } catch (Exception ex) {
            throw new BusinessException("Erro ao deletar o exercicio!");
        }
    }

    private void saveExercise(ExerciseDTO exerciseDTO, Exercise exerciseEntity) {
        mapper.dtoToEntity(exerciseDTO, exerciseEntity);
        repository.save(exerciseEntity);
    }

    private ExerciseDTO toDto(Exercise exerciseEntity) {
        ExerciseDTO exerciseDTO = new ExerciseDTO();
        mapper.entityToDto(exerciseEntity, exerciseDTO);
        return exerciseDTO;
    }

}
