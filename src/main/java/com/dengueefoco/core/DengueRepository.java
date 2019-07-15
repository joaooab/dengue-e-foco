package com.dengueefoco.core;

import com.dengueefoco.model.Dengue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DengueRepository extends JpaRepository<Dengue, Long> {
}
