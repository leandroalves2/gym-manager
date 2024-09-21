package com.leogym.gym_manager.controller.Goal;

import com.leogym.gym_manager.domain.dto.GoalDTO;
import com.leogym.gym_manager.exception.BusinessException;
import com.leogym.gym_manager.service.GoalService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/goal")
public class GoalReadController {

    private final GoalService goalService;

    @GetMapping("/id/{id}")
    public ResponseEntity<GoalDTO> findByIdController(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(goalService.getGoalById(id));
        } catch (Exception e) {
            throw  new BusinessException(e.getMessage());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<GoalDTO>> findAllController() {
        try {
            return ResponseEntity.ok(goalService.listGoal());
        } catch (Exception e) {
            throw  new BusinessException(e.getMessage());
        }
    }
}
