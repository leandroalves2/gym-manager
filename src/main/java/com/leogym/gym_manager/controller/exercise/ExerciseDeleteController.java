package com.leogym.gym_manager.controller.exercise;

import com.leogym.gym_manager.exception.BusinessException;
import com.leogym.gym_manager.service.ExerciseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/exercise")
public class ExerciseDeleteController {

    private final ExerciseService exerciseService;

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<String> deleteExerciseId (@PathVariable Long id) {
        try {
            exerciseService.deleteExerciseById(id);
            return ResponseEntity.ok("Exercicio deletado com sucesso!");
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @DeleteMapping("/delete/name/{name}")
    public ResponseEntity<String> deleteExerciseName (@PathVariable String name) {
        try {
            exerciseService.deleteExerciseByName(name);
            return ResponseEntity.ok("Exercicio deletado com sucesso!");
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

}
