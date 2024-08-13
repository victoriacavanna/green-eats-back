package org.demo.greeneats.controller;

import org.demo.greeneats.dto.request.HamburguerRequestDTO;
import org.demo.greeneats.dto.response.HamburguerResponseDTO;
import org.demo.greeneats.service.HamburguerService;
import org.demo.greeneats.service.impl.HamburguerServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/hamburguer")
public class HamburguerController {
    private final HamburguerService hamburguerService;

    public HamburguerController(HamburguerService hamburguerService) {
        this.hamburguerService = hamburguerService;
    }

    @GetMapping("/")
    List<HamburguerResponseDTO> getAllActive(){
        return hamburguerService.getAllActiveHamburguers();
    }

    @GetMapping("/list")
    List<HamburguerResponseDTO> getAll(){
        return hamburguerService.getAllHamburguers();
    }

    @PostMapping("/create")
    HamburguerResponseDTO createHamburguer(@RequestBody HamburguerRequestDTO hamburguerRequest){
        return hamburguerService.createHamburguer(hamburguerRequest);
    }

    @PutMapping("/update")
    HamburguerResponseDTO updateHamburguer(@RequestBody HamburguerRequestDTO hamburguerRequest){
        return hamburguerService.updateHamburguer(hamburguerRequest);
    }

    @PutMapping("/deactivate/{id}")
    HamburguerResponseDTO deactivateHamburguer(@PathVariable Long id){
        return hamburguerService.deactivateHamburguer(id);
    }

    @PutMapping("/activate/{id}")
    HamburguerResponseDTO activateHamburguer(@PathVariable Long id){
        return hamburguerService.activateHamburguer(id);
    }
}
