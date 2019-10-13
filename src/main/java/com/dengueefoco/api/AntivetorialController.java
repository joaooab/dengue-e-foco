package com.dengueefoco.api;

import com.dengueefoco.core.Antivetorial2Repository;
import com.dengueefoco.core.AntivetorialRepository;
import com.dengueefoco.model.Antivetorial;
import com.dengueefoco.model.Antivetorial2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/antivetoriais")
public class AntivetorialController {

    @Autowired
    private AntivetorialRepository antivetorialRepository;
    @Autowired
    private Antivetorial2Repository antivetorial2Repository;

    @PostMapping()
    public ResponseEntity criarAntivetorial(@RequestBody Antivetorial antivetorial) {
        return ResponseEntity.ok(antivetorialRepository.save(antivetorial));
    }

    @PostMapping("2")
    public ResponseEntity criarAntivetorial2(@RequestBody Antivetorial2 antivetorial2) {
        return ResponseEntity.ok(antivetorial2Repository.save(antivetorial2));
    }

    @GetMapping()
    public ResponseEntity listarAntivetoriais() {
        return ResponseEntity.ok(antivetorialRepository.findAll());
    }

}