package com.leogym.gym_manager.service;

import com.leogym.gym_manager.domain.dto.ProgressDTO;

import java.util.List;

public interface ProgressService {

    void saveOrUpdateProgress(ProgressDTO dto);
    List<ProgressDTO> listProgress();
    ProgressDTO findrogressById(Long id);
    String deleteProgress(Long id);
}
