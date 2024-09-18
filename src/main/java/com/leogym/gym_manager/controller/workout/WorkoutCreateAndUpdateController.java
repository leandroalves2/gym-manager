package com.leogym.gym_manager.controller.workout;

import com.leogym.gym_manager.domain.dto.WorkoutDTO;
import com.leogym.gym_manager.exception.BusinessException;
import com.leogym.gym_manager.service.WorkoutService;
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
@RequestMapping("/workout")
public class WorkoutCreateAndUpdateController {

    private final WorkoutService workoutService;

    @PostMapping
    public ResponseEntity<String> createWorkout(@RequestBody WorkoutDTO workoutDTO) {
        workoutService.saveOrUpdateWorkout(workoutDTO);
        if(Objects.isNull(workoutDTO.getId())) {
            return new ResponseEntity<>("Treino cadastrado com sucesso!", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Treino atualizado com sucesso!", HttpStatus.ACCEPTED);
    }

}
