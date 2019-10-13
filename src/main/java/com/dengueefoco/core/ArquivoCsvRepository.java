package com.dengueefoco.core;

import com.dengueefoco.model.ArquivoCsv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArquivoCsvRepository extends JpaRepository<ArquivoCsv, Long> {

}