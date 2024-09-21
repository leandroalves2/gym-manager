package com.leogym.gym_manager.controller.Goal;

import com.leogym.gym_manager.domain.dto.GoalDTO;
import com.leogym.gym_manager.exception.BusinessException;
import com.leogym.gym_manager.service.GoalService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.isNull;

@AllArgsConstructor
@RestController
@RequestMapping("/goal")
public class GoalSaveOrUpdateController {

    private final GoalService goalService;

    @PostMapping
    public ResponseEntity<String> saveGoal(@RequestBody GoalDTO goalDTO) {
        try {
            goalService.saveOrUpdateGoal(goalDTO);
            if (isNull(goalDTO.getId())) {
                return new ResponseEntity<>("Meta cadastrada com sucesso!", HttpStatus.CREATED);
            }
            return new ResponseEntity<>("Meta atualizada com sucesso!", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

}
