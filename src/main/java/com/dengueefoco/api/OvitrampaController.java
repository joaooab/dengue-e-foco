package com.dengueefoco.api;

import com.dengueefoco.core.OvitrampaRepository;
import com.dengueefoco.model.Ovitrampa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OvitrampaController {

    private OvitrampaRepository ovitrampaRepository;

    @Autowired
    public OvitrampaController(OvitrampaRepository ovitrampaRepository) {
        this.ovitrampaRepository = ovitrampaRepository;
    }

    @PostMapping("/ovitrampa")
    public ResponseEntity<Ovitrampa> criarOvitrampas(@RequestBody Ovitrampa ovitrampa) {
        return ResponseEntity.ok(ovitrampaRepository.save(ovitrampa));
    }


    @GetMapping()
    public ResponseEntity listarAntivetoriais() {
        return ResponseEntity.ok(ovitrampaRepository.findAll());
    }


}
