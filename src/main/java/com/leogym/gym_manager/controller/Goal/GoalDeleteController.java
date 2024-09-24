package com.leogym.gym_manager.controller.Goal;

import com.leogym.gym_manager.exception.BusinessException;
import com.leogym.gym_manager.service.GoalService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/goal")
public class GoalDeleteController {

    private final GoalService goalService;

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> removeGoalById(@PathVariable Long id) {
        try {
            goalService.deleteGoalById(id);
            return ResponseEntity.ok("Meta deletada com sucesso!");
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

}
