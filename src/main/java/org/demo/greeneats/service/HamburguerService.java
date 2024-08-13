package org.demo.greeneats.service;

import org.demo.greeneats.dto.request.HamburguerRequestDTO;
import org.demo.greeneats.dto.response.HamburguerResponseDTO;

import java.util.*;
public interface HamburguerService {
    HamburguerResponseDTO createHamburguer(HamburguerRequestDTO hamburguerRequest);

    HamburguerResponseDTO updateHamburguer(HamburguerRequestDTO hamburguerRequest);

    HamburguerResponseDTO deactivateHamburguer(Long id);

    HamburguerResponseDTO activateHamburguer(Long id);

    List<HamburguerResponseDTO> getAllActiveHamburguers();

    List<HamburguerResponseDTO> getAllHamburguers();
    
}
