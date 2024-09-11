package com.leogym.gym_manager.controller.workout;

import com.leogym.gym_manager.domain.dto.WorkoutDTO;
import com.leogym.gym_manager.exception.BusinessException;
import com.leogym.gym_manager.service.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/workout")
public class WorkoutCreateAndUpdateController {

    private final WorkoutService workoutService;

    @PostMapping
    public ResponseEntity<String> createWorkout(@RequestBody WorkoutDTO workoutDTO) {
        try {
            return ResponseEntity.ok(workoutService.saveOrUpdateWorkout(workoutDTO));
        } catch (BusinessException e) {
            throw new BusinessException(e.getMessage());
        }
    }

}
