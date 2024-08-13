package org.demo.greeneats.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.demo.greeneats.dto.mapper.HamburguerMapper;
import org.demo.greeneats.dto.request.HamburguerRequestDTO;
import org.demo.greeneats.dto.response.HamburguerResponseDTO;
import org.demo.greeneats.model.Hamburguer;
import org.demo.greeneats.repository.HamburguerRepository;
import org.demo.greeneats.service.HamburguerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HamburguerServiceImpl implements HamburguerService {
    private final HamburguerRepository hamburguerRepository;
    private final HamburguerMapper hamburguerMapper;

    public HamburguerServiceImpl(HamburguerRepository hamburguerRepository, HamburguerMapper hamburguerMapper) {
        this.hamburguerRepository = hamburguerRepository;
        this.hamburguerMapper = hamburguerMapper;
    }

    @Override
    public HamburguerResponseDTO createHamburguer(HamburguerRequestDTO hamburguerRequest) {
        Hamburguer hamburguer = hamburguerMapper.requestToHamburguer(hamburguerRequest);
        hamburguer.setStatus(true);
        hamburguerRepository.save(hamburguer);

        return hamburguerMapper.hamburguerToResponse(hamburguer);
    }

    @Override
    public HamburguerResponseDTO updateHamburguer(HamburguerRequestDTO hamburguerRequest) {
        hamburguerRepository.findById(hamburguerRequest.getId()).orElseThrow(()-> new EntityNotFoundException("Hamburguer not found"));
        Hamburguer hamburguer = hamburguerMapper.requestToHamburguer(hamburguerRequest);
        hamburguerRepository.save(hamburguer);
        return hamburguerMapper.hamburguerToResponse(hamburguer);
    }
    @Override
    public HamburguerResponseDTO deactivateHamburguer(Long id) {
        Hamburguer hamburguer = hamburguerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Hamburguer with id:" + id + " not found"));
        hamburguer.setStatus(false);
        hamburguerRepository.save(hamburguer);
        return hamburguerMapper.hamburguerToResponse(hamburguer);
    }

    @Override
    public HamburguerResponseDTO activateHamburguer(Long id) {
        Hamburguer hamburguer = hamburguerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Hamburguer with id:" + id + " not found"));
        hamburguer.setStatus(true);
        hamburguerRepository.save(hamburguer);
        return hamburguerMapper.hamburguerToResponse(hamburguer);
    }

    @Override
    public List<HamburguerResponseDTO> getAllActiveHamburguers() {
        List<Hamburguer> list = hamburguerRepository.getAllActive();
        return hamburguerMapper.hamburguerToResponseList(list);
    }

    @Override
    public List<HamburguerResponseDTO> getAllHamburguers() {
        List<Hamburguer> list = hamburguerRepository.findAll();
        return hamburguerMapper.hamburguerToResponseList(list);
    }
}
