package com.SGE.service;

import com.SGE.exceptions.BusinessException;
import com.SGE.model.Area;
import com.SGE.repository.AreaRepository;
import com.SGE.exceptions.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AreaService {

    private final AreaRepository areaRepository;

    public AreaService(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    @Transactional
    public Area salvar(Area area) throws BusinessException {
        return areaRepository.save(area);
    }

    @Transactional(readOnly = true)
    public List<Area> listarTodos() {
        return areaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Area buscarPorId(Long id) throws NotFoundException {
        return areaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Área não encontrada"));
    }

    @Transactional
    public void excluir(Long id) throws NotFoundException {
        if (!areaRepository.existsById(id)) {
            throw new NotFoundException("Área não encontrada");
        }
        areaRepository.deleteById(id);
    }
}