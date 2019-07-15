package com.dengueefoco.api;

import com.dengueefoco.core.PaletaRepository;
import com.dengueefoco.model.Paleta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/paletas")
public class PaletaController {

    private PaletaRepository paletaRepository;

    @Autowired
    public PaletaController(PaletaRepository paletaRepository) {
        this.paletaRepository = paletaRepository;
    }


    @PostMapping()
    public ResponseEntity criarPaleta(@RequestBody Paleta paleta) {
        return ResponseEntity.ok(paletaRepository.save(paleta));
    }

    @GetMapping()
    public ResponseEntity listarAntivetoriais() {
        return ResponseEntity.ok(paletaRepository.findAll());
    }

}
