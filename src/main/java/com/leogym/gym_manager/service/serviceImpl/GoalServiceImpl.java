package com.leogym.gym_manager.service.serviceImpl;

import com.leogym.gym_manager.domain.dto.GoalDTO;
import com.leogym.gym_manager.domain.entities.Goal;
import com.leogym.gym_manager.exception.BusinessException;
import com.leogym.gym_manager.mapper.GoalMapper;
import com.leogym.gym_manager.repository.GoalRepository;
import com.leogym.gym_manager.service.GoalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GoalServiceImpl implements GoalService {

    private final GoalMapper goalMapper;
    private final GoalRepository goalRepository;

    @Override
    public void saveGoal(GoalDTO goalDTO) {
        try {
            Goal goalEntity = new Goal();
            goalMapper.dtoToEntity(goalDTO, goalEntity);
            goalRepository.save(goalEntity);
        } catch (Exception e) {
            throw new BusinessException("Não foi possivel cadastrar a meta!");
        }
    }

    @Override
    public GoalDTO getGoalById(Long id) {
        try {
            Goal goalEntity = goalRepository.findById(id)
                    .orElseThrow(() -> new BusinessException("Meta não encontrada com o id: " + id));
            GoalDTO goalDTO = new GoalDTO();
            goalMapper.entityToDto(goalEntity, goalDTO);
            return goalDTO;
        } catch (Exception e) {
            throw new BusinessException("Não foi possivel encontrar a meta!");
        }
    }
}
