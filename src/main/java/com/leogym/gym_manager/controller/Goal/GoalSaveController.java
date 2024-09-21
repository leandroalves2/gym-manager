package com.leogym.gym_manager.controller.Goal;

import com.leogym.gym_manager.domain.dto.GoalDTO;
import com.leogym.gym_manager.exception.BusinessException;
import com.leogym.gym_manager.service.GoalService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/goal")
public class GoalSaveController {

    private final GoalService goalService;

    @PostMapping
    public ResponseEntity<String> saveGoal(@RequestBody GoalDTO goalDTO) {
        try {
            goalService.saveGoal(goalDTO);
            return new ResponseEntity<>("Meta cadastrada com sucesso!", HttpStatus.CREATED);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

}
