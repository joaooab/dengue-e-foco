package com.dengueefoco.api;

import com.dengueefoco.core.OvitrampasRepository;
import com.dengueefoco.model.Ovitrampas;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OvitrampasController {

    private OvitrampasRepository ovitrampasRepository;

    @PostMapping("/ovitrampas")
    public void criarOvitrampas(@RequestBody Ovitrampas ovitrampas) {
        ovitrampasRepository.save(ovitrampas);
    }

}
