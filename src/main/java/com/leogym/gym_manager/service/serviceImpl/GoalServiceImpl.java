package com.leogym.gym_manager.service.serviceImpl;

import com.leogym.gym_manager.domain.dto.GoalDTO;
import com.leogym.gym_manager.domain.entities.Goal;
import com.leogym.gym_manager.exception.BusinessException;
import com.leogym.gym_manager.mapper.GoalMapper;
import com.leogym.gym_manager.repository.GoalRepository;
import com.leogym.gym_manager.service.GoalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class GoalServiceImpl implements GoalService {

    private final GoalMapper goalMapper;
    private final GoalRepository goalRepository;

    @Override
    public void saveOrUpdateGoal(GoalDTO goalDTO) {
        if (isNull(goalDTO.getId())) {
            try {
                Goal goalEntity = new Goal();
                saveGoal(goalDTO, goalEntity);
            } catch (Exception e) {
                throw new BusinessException("Não foi possivel cadastrar a meta!");
            }
        }
        try {
            Goal goalEntity = goalRepository.findById(goalDTO.getId())
                    .orElseThrow(() -> new BusinessException("Meta não encontrada com o id: " + goalDTO.getId()));
            saveGoal(goalDTO, goalEntity);
        } catch (Exception e) {
            throw new BusinessException("Não foi possivel cadastrar a meta!");
        }

    }

    private void saveGoal(GoalDTO goalDTO, Goal goalEntity) {
        goalMapper.dtoToEntity(goalDTO, goalEntity);
        goalRepository.save(goalEntity);
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

    @Override
    public List<GoalDTO> listGoal() {
        try {
            List<Goal> goalEntityList = goalRepository.findAll();
            List<GoalDTO> goalDTOList = new ArrayList<>();
            for (Goal goal : goalEntityList) {
                GoalDTO goalDTO = new GoalDTO();
                goalMapper.entityToDto(goal, goalDTO);
                goalDTOList.add(goalDTO);
            }
            return goalDTOList;
        } catch (Exception e) {
            throw new BusinessException("Não foi possivel listar as meta!");
        }
    }

}
