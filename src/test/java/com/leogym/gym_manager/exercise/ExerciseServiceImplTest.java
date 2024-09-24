package com.leogym.gym_manager.exercise;

import com.leogym.gym_manager.domain.dto.ExerciseDTO;
import com.leogym.gym_manager.domain.entities.Exercise;
import com.leogym.gym_manager.exception.BusinessException;
import com.leogym.gym_manager.exception.NotFoundException;
import com.leogym.gym_manager.repository.ExerciseRepository;
import com.leogym.gym_manager.service.serviceImpl.ExerciseServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExerciseServiceImplTest {

    @InjectMocks
    private ExerciseServiceImpl exerciseService;

    @Mock
    private ExerciseRepository exerciseRepository;

    @Test
    void findById_ShouldReturnExercise_WhenIdExists () {

        //inicializando as entidades
        Exercise exerciseEntity = new Exercise();
        exerciseEntity.setId(1L);
        exerciseEntity.setName("Test Exercise");

        //definindo o comportamento do repositorio
        when(exerciseRepository.findById(1L)).thenReturn(Optional.of(exerciseEntity));

        //chamando a funcao
        ExerciseDTO exerciseDTO = exerciseService.findExerciseById(1L);

        //escrevendo o teste
        assertEquals("Test Exercise",exerciseDTO.getName() );
    }

    @Test
    void findById_ShouldReturnNotFoundException () {

        //definindo o comportamento do repositionio
        when(exerciseRepository.findById(1L)).thenReturn(Optional.empty());

        //chamando a funcao
        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            exerciseService.findExerciseById(1L); });
        //escrevendo o código
        assertEquals("Exercise not found with the id: " + 1L, exception.getMessage() );
    }

    @Test
    void findById_ShouldReturnBusinessException () {

        Exercise exerciseEntity = mock(Exercise.class);

        when(exerciseRepository.findById(1L)).thenReturn(Optional.of(exerciseEntity));

        when(exerciseEntity.getName()).thenThrow(new BusinessException("Error retrieving name"));

        BusinessException exception = assertThrows(BusinessException.class, () -> {
            exerciseService.findExerciseById(1L);
        });

        assertEquals("Error locating the exercises!", exception.getMessage());
    }

}