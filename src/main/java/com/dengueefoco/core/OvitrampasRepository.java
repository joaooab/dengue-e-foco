package com.dengueefoco.core;

import com.dengueefoco.model.Ovitrampas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OvitrampasRepository extends JpaRepository<Ovitrampas, Long> {


}
