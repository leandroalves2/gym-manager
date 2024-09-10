package com.leogym.gym_manager.controller.exercise;

import com.leogym.gym_manager.domain.dto.ExerciseDTO;
import com.leogym.gym_manager.exception.BusinessException;
import com.leogym.gym_manager.service.ExerciseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/exercise")
public class ExerciseCreateAndUpdateController {

    private final ExerciseService exerciseService;

    @PostMapping
    public ResponseEntity<String> PersistController(@RequestBody @Valid ExerciseDTO exerciseDTO) {
        try {
            return ResponseEntity.ok(exerciseService.saveOrUpdateExercise(exerciseDTO));
        } catch (BusinessException be) {
            throw new BusinessException("Erro ao cadastrar exercicio!");
        }
    }
}
