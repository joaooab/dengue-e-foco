package com.dengueefoco.api;

import com.dengueefoco.core.DengueRepository;
import com.dengueefoco.model.Dengue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/dengues")
public class DengueController {

    private DengueRepository dengueRepository;

    @Autowired
    public DengueController(DengueRepository dengueRepository) {
        this.dengueRepository = dengueRepository;
    }


    @PostMapping()
    public ResponseEntity criarDengue(@RequestBody Dengue dengue) {
        return ResponseEntity.ok(dengueRepository.save(dengue));
    }

    @GetMapping()
    public ResponseEntity listarAntivetoriais() {
        return ResponseEntity.ok(dengueRepository.findAll());
    }

}
