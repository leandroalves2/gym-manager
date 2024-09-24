package com.leogym.gym_manager.controller.exercise;

import com.leogym.gym_manager.domain.dto.ExerciseDTO;
import com.leogym.gym_manager.exception.BusinessException;
import com.leogym.gym_manager.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/exercise")
public class ExerciseReadController {

    private final ExerciseService exerciseService;

    @GetMapping("/list")
    public List<ExerciseDTO> listExercises() {

        try {
            return exerciseService.listExercice();
        } catch (BusinessException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @GetMapping("/id/{id}")
    public ExerciseDTO findxerciseById(@PathVariable Long id) {
        try {
            return exerciseService.findExerciseById(id);
        } catch (BusinessException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @GetMapping("/name/{name}")
    public ExerciseDTO findxerciseByName(@PathVariable String name) {
        try {
            return exerciseService.findyExerciseByName(name);
        } catch (BusinessException e) {
            throw new BusinessException(e.getMessage());
        }
    }

}