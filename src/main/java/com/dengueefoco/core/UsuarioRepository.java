package com.dengueefoco.core;

import com.dengueefoco.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM usuario u WHERE LOWER(u.email)=LOWER(:email) ")
    Usuario findByEmail(@Param("email") String email);

}