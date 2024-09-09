package com.leogym.gym_manager.service.serviceImpl;

import com.leogym.gym_manager.domain.dto.ProgressDTO;
import com.leogym.gym_manager.domain.entities.Progress;
import com.leogym.gym_manager.exception.BusinessException;
import com.leogym.gym_manager.mapper.ProgressMapper;
import com.leogym.gym_manager.repository.ProgressRepository;
import com.leogym.gym_manager.service.ProgressService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProgressServiceImpl implements ProgressService {

    @Autowired
    private final ProgressMapper progressMapper;
    private final ProgressRepository progressRepository;

    @Override
    public String saveProgress(ProgressDTO dto) {
        try {
            Progress entity = new Progress();
            save(dto, entity);
            return "Progresso salvo com sucesso!";
        } catch (Exception ex) {
            throw new BusinessException("Não foi possivel salvar o progresso!");
        }
    }

    @Override
    public List<ProgressDTO> listProgress() {
        List<Progress> listEntity = progressRepository.findAll();
        List<ProgressDTO> listDto = new ArrayList<>();
        for (Progress entity : listEntity) {
            listDto.add(toDto(entity));
        }
        return listDto;
    }

    @Override
    public ProgressDTO findById(Long id) {
        Progress entity = progressRepository.findById(id)
                .orElseThrow((()-> new BusinessException("Progresso não encontrado com o id informado: " + id)));
        try {
            return toDto(entity);
        } catch (Exception ex) {
            throw new BusinessException("Erro ao localizar o progresso!");
        }
    }

    void save(ProgressDTO dto, Progress entity) {
        progressMapper.dtoToEntity(dto, entity);
        progressRepository.save(entity);
    }

    ProgressDTO toDto(Progress entity) {
        ProgressDTO dto = new ProgressDTO();
        progressMapper.entityToDto(entity, dto);
        return dto;
    }


}
