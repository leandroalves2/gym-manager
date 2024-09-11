package com.leogym.gym_manager.controller.workout;

import com.leogym.gym_manager.domain.dto.WorkoutDTO;
import com.leogym.gym_manager.exception.BusinessException;
import com.leogym.gym_manager.service.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/workout")
public class WorkoutReadController {

    private final WorkoutService workoutService;

    @GetMapping("/list")
    public ResponseEntity<List<WorkoutDTO>> listWorkout() {
        try {
            return ResponseEntity.ok(workoutService.listWorkout());
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<WorkoutDTO> getWorkoutById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(workoutService.findById(id));
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<WorkoutDTO> getWorkoutByName(@PathVariable String name) {
        try {
            return ResponseEntity.ok(workoutService.findByName(name));
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }
}
