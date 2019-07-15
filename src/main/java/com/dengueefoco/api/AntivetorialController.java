package com.dengueefoco.api;

import com.dengueefoco.core.AntivetorialRepository;
import com.dengueefoco.model.Antivetorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/antivetoriais")
public class AntivetorialController {

    private AntivetorialRepository antivetorialRepository;

    @Autowired
    public AntivetorialController(AntivetorialRepository antivetorialRepository) {
        this.antivetorialRepository = antivetorialRepository;
    }


    @PostMapping()
    public ResponseEntity criarAntivetorial(@RequestBody Antivetorial antivetorial) {
        return ResponseEntity.ok(antivetorialRepository.save(antivetorial));
    }

    @GetMapping()
    public ResponseEntity listarAntivetoriais() {
        return ResponseEntity.ok(antivetorialRepository.findAll());
    }

}
