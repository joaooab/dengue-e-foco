package com.dengueefoco.core;

import com.dengueefoco.model.Ovitrampa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OvitrampaRepository extends JpaRepository<Ovitrampa, Long> {

}