package org.demo.greeneats.dto.mapper;

import org.demo.greeneats.dto.request.HamburguerRequestDTO;
import org.demo.greeneats.dto.response.HamburguerResponseDTO;
import org.demo.greeneats.model.Hamburguer;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface HamburguerMapper {
    Hamburguer requestToHamburguer(HamburguerRequestDTO hamburguerRequest);

    HamburguerResponseDTO hamburguerToResponse(Hamburguer hamburguer);
    List<HamburguerResponseDTO> hamburguerToResponseList(List<Hamburguer> hamburguerList);
}
