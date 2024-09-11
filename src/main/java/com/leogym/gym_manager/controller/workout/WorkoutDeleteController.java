package com.leogym.gym_manager.controller.workout;

import com.leogym.gym_manager.exception.BusinessException;
import com.leogym.gym_manager.service.WorkoutService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/workout")
public class WorkoutDeleteController {

    private final WorkoutService  workoutService;

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        try {

            return ResponseEntity.ok(workoutService.deleteWorkoutById(id));
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

}
