package com.leogym.gym_manager.controller.exercise;

import com.leogym.gym_manager.domain.dto.ExerciseDTO;
import com.leogym.gym_manager.exception.BusinessException;
import com.leogym.gym_manager.service.ExerciseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/exercise")
public class ExerciseCreateAndUpdateController {

    private final ExerciseService exerciseService;

    @PostMapping
    public ResponseEntity<String> PersistController(@RequestBody @Valid ExerciseDTO exerciseDTO) {
        try {
            exerciseService.saveOrUpdateExercise(exerciseDTO);
            if (Objects.isNull(exerciseDTO.getId())) {
                return new ResponseEntity<>("Exercicio cadastrado com sucesso!", HttpStatus.CREATED);
            }
            return new ResponseEntity<>("Exercicio atualizado com sucesso!", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }
}
