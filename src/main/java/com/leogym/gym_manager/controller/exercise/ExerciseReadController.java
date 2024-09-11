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
    public List<ExerciseDTO> ListController() {

        try {
            return exerciseService.listExercice();
        } catch (BusinessException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @GetMapping("/id/{id}")
    public ExerciseDTO findById(@PathVariable Long id) {
        try {
            return exerciseService.findById(id);
        } catch (BusinessException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @GetMapping("/name/{name}")
    public ExerciseDTO findByName(@PathVariable String name) {
        try {
            return exerciseService.findyByName(name);
        } catch (BusinessException e) {
            throw new BusinessException(e.getMessage());
        }
    }

}