package com.dengueefoco.core;

import com.dengueefoco.model.Paleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaletaRepository extends JpaRepository<Paleta, Long> {

}