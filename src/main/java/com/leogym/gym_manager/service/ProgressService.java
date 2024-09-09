package com.leogym.gym_manager.service;

import com.leogym.gym_manager.domain.dto.ProgressDTO;
import org.springframework.stereotype.Service;

public interface ProgressService {

    String saveProgress(ProgressDTO dto);

}
