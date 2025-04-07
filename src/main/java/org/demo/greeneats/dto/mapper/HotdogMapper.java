package org.demo.greeneats.dto.mapper;

import org.demo.greeneats.dto.request.HamburguerRequestDTO;
import org.demo.greeneats.dto.request.HotdogRequestDTO;
import org.demo.greeneats.dto.response.HamburguerResponseDTO;
import org.demo.greeneats.dto.response.HotdogResponseDTO;
import org.demo.greeneats.model.Hamburguer;
import org.demo.greeneats.model.Hotdog;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface HotdogMapper {
    Hotdog requestToHotdog(HotdogRequestDTO hotdogRequest);

    HotdogResponseDTO hotdogToResponse(Hotdog hotdog);
    List<HotdogResponseDTO> hotdogResponseList(List<Hotdog> hotdogList);
}
