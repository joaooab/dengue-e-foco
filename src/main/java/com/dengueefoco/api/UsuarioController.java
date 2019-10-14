package com.dengueefoco.api;

import com.dengueefoco.core.UsuarioRepository;
import com.dengueefoco.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping()
    public void criarUsuario(@RequestBody Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @GetMapping()
    public ResponseEntity listarUsuarios() {
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

}