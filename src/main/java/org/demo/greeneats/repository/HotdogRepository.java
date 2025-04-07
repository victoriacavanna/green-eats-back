package org.demo.greeneats.repository;

import org.demo.greeneats.model.Hamburguer;
import org.demo.greeneats.model.Hotdog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotdogRepository extends JpaRepository<Hotdog,Long> {
    @Query("SELECT h from Hotdog h WHERE h.status = TRUE ")
    List<Hotdog> getAllActive();
}
