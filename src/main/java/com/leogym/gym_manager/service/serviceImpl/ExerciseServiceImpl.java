package com.leogym.gym_manager.service.serviceImpl;

import com.leogym.gym_manager.domain.dto.ExerciseDTO;
import com.leogym.gym_manager.domain.entities.Exercise;
import com.leogym.gym_manager.mapper.ExerciseMapper;
import com.leogym.gym_manager.repository.ExerciseRepository;
import com.leogym.gym_manager.service.ExerciseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
