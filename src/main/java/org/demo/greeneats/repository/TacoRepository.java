package org.demo.greeneats.repository;

import org.demo.greeneats.model.Taco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TacoRepository extends JpaRepository<Taco,Long> {

    @Query("SELECT t from Taco t where t.status = true")
    List<Taco> getAllActive();
}
