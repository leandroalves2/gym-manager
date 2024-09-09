package com.leogym.gym_manager.controller.progress;

import com.leogym.gym_manager.domain.dto.ProgressDTO;
import com.leogym.gym_manager.exception.BusinessException;
import com.leogym.gym_manager.service.ProgressService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/progress")
public class ProgressReadController {

    private final ProgressService progressService;

    @GetMapping("/list")
    public ResponseEntity<List<ProgressDTO>> listProgress() {
        try {
            return ResponseEntity.ok(progressService.listProgress());
        } catch (BusinessException e) {
            throw new BusinessException("Erro ao localizar os exercicios!");
        }
    }
    
}
