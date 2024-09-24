package com.leogym.gym_manager.controller.progress;

import com.leogym.gym_manager.domain.dto.ProgressDTO;
import com.leogym.gym_manager.service.ProgressService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@AllArgsConstructor
@RestController
@RequestMapping("/progress")
public class ProgressCreaterAndUpdateController {

    private final ProgressService progressService;

    @PostMapping
    public ResponseEntity<String> upsertProgress(@Valid @RequestBody ProgressDTO progressDTO) {
        progressService.saveOrUpdateProgress(progressDTO);
        if(Objects.isNull(progressDTO.getId())) {
            return new ResponseEntity<>("Progresso cadastrado com sucesso!", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Progresso atualizado com sucesso!", HttpStatus.ACCEPTED);
    }



}
