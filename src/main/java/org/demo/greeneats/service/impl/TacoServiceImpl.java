package org.demo.greeneats.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.demo.greeneats.dto.mapper.TacoMapper;
import org.demo.greeneats.dto.request.TacoRequestDTO;
import org.demo.greeneats.dto.response.TacoResponseDTO;
import org.demo.greeneats.model.Hamburguer;
import org.demo.greeneats.model.Taco;
import org.demo.greeneats.repository.TacoRepository;
import org.demo.greeneats.service.TacoService;

import java.util.List;

public class TacoServiceImpl implements TacoService {
    private final TacoRepository tacoRepository;

    private final TacoMapper tacoMapper;

    public TacoServiceImpl(TacoRepository tacoRepository, TacoMapper tacoMapper) {
        this.tacoRepository = tacoRepository;
        this.tacoMapper = tacoMapper;
    }

    @Override
    public TacoResponseDTO createTaco(TacoRequestDTO tacoRequest) {
        Taco taco = tacoMapper.requestToTaco(tacoRequest);
        taco.setStatus(true);
        tacoRepository.save(taco);
        return tacoMapper.tacoToResponse(taco);
    }

    @Override
    public TacoResponseDTO updateTaco(TacoRequestDTO tacoRequest) {
        tacoRepository.findById(tacoRequest.getId()).orElseThrow(() -> new EntityNotFoundException("Taco not found"));
        Taco taco = tacoMapper.requestToTaco(tacoRequest);
        tacoRepository.save(taco);
        return tacoMapper.tacoToResponse(taco);
    }

    @Override
    public TacoResponseDTO deactivateTaco(Long id) {
        Taco taco = tacoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Taco with id:" + id + " not found"));
        taco.setStatus(false);
        tacoRepository.save(taco);
        return tacoMapper.tacoToResponse(taco);
    }

    @Override
    public TacoResponseDTO activateTaco(Long id) {
        Taco taco = tacoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Taco with id:" + id + " not found"));
        taco.setStatus(true);
        tacoRepository.save(taco);
        return tacoMapper.tacoToResponse(taco);
    }

    @Override
    public List<TacoResponseDTO> getAllTacos() {
        List<Taco> list = tacoRepository.findAll();
        return tacoMapper.tacoToResponseList(list);
    }
}
