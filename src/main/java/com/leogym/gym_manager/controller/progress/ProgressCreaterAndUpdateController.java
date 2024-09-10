package com.leogym.gym_manager.controller.progress;

import com.leogym.gym_manager.domain.dto.ProgressDTO;
import com.leogym.gym_manager.service.ProgressService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/progress")
public class ProgressCreaterAndUpdateController {

    private final ProgressService progressService;

    @PostMapping
    public ResponseEntity<String> PersistController(@Valid @RequestBody ProgressDTO progressDTO) {
        try {
            return ResponseEntity.ok(progressService.saveOrUpdateProgress(progressDTO));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



}
