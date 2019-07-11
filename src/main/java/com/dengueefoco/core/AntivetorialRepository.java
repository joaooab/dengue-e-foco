package com.dengueefoco.core;

import com.dengueefoco.model.Antivetorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AntivetorialRepository extends JpaRepository<Antivetorial, Long> {

}
