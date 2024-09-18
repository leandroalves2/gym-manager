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

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class ProgressServiceImpl implements ProgressService {

    @Autowired
    private final ProgressMapper progressMapper;
    private final ProgressRepository progressRepository;

    @Override
    public void saveOrUpdateProgress(ProgressDTO progressDTO) {
        if(isNull(progressDTO.getId())) {
            try {
                Progress progressEntity = new Progress();
                save(progressDTO, progressEntity);
            } catch (Exception ex) {
                throw new BusinessException("Não foi possivel salvar o progresso!");
            }
        } else {
            try {
                Progress progressEntity = progressRepository.findById(progressDTO.getId())
                        .orElseThrow((()-> new BusinessException("Progresso não encontrado com o id informado: " + progressDTO.getId())));
                save(progressDTO, progressEntity);
            } catch (Exception ex) {
                throw new BusinessException("Não foi possivel atualizar o progresso!");
            }
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
        Progress progressEntity = progressRepository.findById(id)
                .orElseThrow((()-> new BusinessException("Progresso não encontrado com o id informado: " + id)));
        try {
            return toDto(progressEntity);
        } catch (Exception ex) {
            throw new BusinessException("Erro ao localizar o progresso!");
        }
    }

    @Override
    public String deleteProgress(Long id) {
        try {
            progressRepository.deleteById(id);
            return "Progresso deletado com sucesso!";
        } catch (Exception ex) {
            throw new BusinessException("Erro deletar o progresso!");
        }
    }


    void save(ProgressDTO progressDTO, Progress progressEntity) {
        progressMapper.dtoToEntity(progressDTO, progressEntity);
        progressRepository.save(progressEntity);
    }

    ProgressDTO toDto(Progress progressEntity) {
        ProgressDTO progressDTO = new ProgressDTO();
        progressMapper.entityToDto(progressEntity, progressDTO);
        return progressDTO;
    }


}
