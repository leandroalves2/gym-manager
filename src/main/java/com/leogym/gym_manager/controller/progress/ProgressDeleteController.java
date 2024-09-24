package com.leogym.gym_manager.controller.progress;

import com.leogym.gym_manager.exception.BusinessException;
import com.leogym.gym_manager.service.ProgressService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/progress")
public class ProgressDeleteController {

    private final ProgressService progressService;

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<String> removeProgressById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(progressService.deleteProgress(id));
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }
}
