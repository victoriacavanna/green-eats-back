package org.demo.greeneats.repository;

import org.demo.greeneats.dto.request.HamburguerRequestDTO;
import org.demo.greeneats.model.Hamburguer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface HamburguerRepository extends JpaRepository<Hamburguer, Long> {

    @Query("SELECT h from Hamburguer h WHERE h.status = TRUE ")
    List<Hamburguer> getAllActive();

}
