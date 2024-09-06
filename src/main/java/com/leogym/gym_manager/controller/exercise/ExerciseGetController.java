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
public class ExerciseGetController {

    private final ExerciseService exerciseService;

    @GetMapping("/find/list")
    public List<ExerciseDTO> ListController() {

        try {
            List<ExerciseDTO> list = exerciseService.listExercice();
            return list;
        } catch (BusinessException be) {
            throw new BusinessException("Erro ao localizar os exercicios!");
        }
    }

    @GetMapping("/find/{id}")
    public ExerciseDTO findById(@PathVariable Long id) {
        try {
            return exerciseService.findById(id);
        } catch (BusinessException be) {
            throw new BusinessException("Erro ao localizar o exercicio!");
        }
    }

}