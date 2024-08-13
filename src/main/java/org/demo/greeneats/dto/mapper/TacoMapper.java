package org.demo.greeneats.dto.mapper;

import org.demo.greeneats.dto.request.TacoRequestDTO;
import org.demo.greeneats.dto.response.HamburguerResponseDTO;
import org.demo.greeneats.dto.response.TacoResponseDTO;
import org.demo.greeneats.model.Taco;
import java.util.*;
public interface TacoMapper {

    Taco requestToTaco(TacoRequestDTO tacoRequest);
    TacoResponseDTO tacoToResponse(Taco taco);
    List<TacoResponseDTO> tacoToResponseList(List<Taco> list);
}
