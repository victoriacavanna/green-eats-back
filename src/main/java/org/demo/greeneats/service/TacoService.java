package org.demo.greeneats.service;

import org.demo.greeneats.dto.request.TacoRequestDTO;
import org.demo.greeneats.dto.response.TacoResponseDTO;

import java.util.List;

public interface TacoService {
    TacoResponseDTO createTaco(TacoRequestDTO tacoRequest);

    TacoResponseDTO updateTaco(TacoRequestDTO tacoRequestDTO);

    TacoResponseDTO deactivateTaco(Long id);

    TacoResponseDTO activateTaco(Long id);

    List<TacoResponseDTO> getAllTacos();
}
