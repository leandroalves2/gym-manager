package com.leogym.gym_manager.service;

import com.leogym.gym_manager.domain.dto.ProgressDTO;

import java.util.List;

public interface ProgressService {

    String saveOrUpdateProgress(ProgressDTO dto);
    List<ProgressDTO> listProgress();
    ProgressDTO findById(Long id);
    String deleteProgress(Long id);
}
