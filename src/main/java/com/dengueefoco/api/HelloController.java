package com.dengueefoco.api;

import com.dengueefoco.core.*;
import com.dengueefoco.model.Antivetorial;
import com.dengueefoco.model.Dengue;
import com.dengueefoco.model.Paleta;
import com.dengueefoco.util.ArquivoCsvUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@RestController
public class HelloController {

    @Autowired
    private AntivetorialRepository antivetorialRepository;
    @Autowired
    private DengueRepository dengueRepository;
    @Autowired
    private PaletaRepository paletaRepository;
    @Autowired
    private OvitrampaRepository ovitrampaRepository;
    @Autowired
    private ArquivoCsvRepository arquivoCsvRepository;

    @RequestMapping("/")
    public String index() {
        return "Dengue e Foco server started!";
    }

    @RequestMapping("/populate")
    public String populateDataBase() {
//        antivetorialRepository.deleteAll();
//        dengueRepository.deleteAll();
//        paletaRepository.deleteAll();
//        ovitrampaRepository.deleteAll();
//        populaAntivetoriais();
//        populaDengue();
//        populaOvitrampas();

        Antivetorial antivetorial = new Antivetorial();
        antivetorial.setIdUsuario(31014L);
        antivetorial.setDataVisita(new Date());
        antivetorial.setLarvicida("Spinosade");
        antivetorial.setQtdLarvicida(0.0);
        antivetorial.setStatusImovel("NULL");
        antivetorial.setTipoImovel("Residencial");
        antivetorial.setRegiao("Noroeste");
        antivetorial.setLongitude(-49.3821436374);
        antivetorial.setLatitude(-16.6014813145);

        return "Dados populados com sucesso!!";
    }

    private void populaAntivetoriais() {
        ArquivoCsvUtil arquivoCsvUtil = new ArquivoCsvUtil();
        ArrayList<Antivetorial> antivetoriais = arquivoCsvUtil.converteCsvEmAntivetoriais("antivetorial1.csv");
        antivetorialRepository.saveAll(antivetoriais);
    }

    private void populaDengue() {
        ArquivoCsvUtil arquivoCsvUtil = new ArquivoCsvUtil();
        ArrayList<Dengue> dengues = arquivoCsvUtil.converteCsvEmDengues("dengue1.csv");
        dengueRepository.saveAll(dengues);
    }

    private void populaOvitrampas() {
        ArquivoCsvUtil arquivoCsvUtil = new ArquivoCsvUtil();
        ArrayList<Paleta> paletas = arquivoCsvUtil.converteCsvEmOvitrampas("ovitrampas1.csv");
        paletaRepository.saveAll(paletas);
    }

}