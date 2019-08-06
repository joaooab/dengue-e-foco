package com.dengueefoco.api;

import com.dengueefoco.core.*;
import com.dengueefoco.model.Antivetorial;
import com.dengueefoco.model.Dengue;
import com.dengueefoco.model.Paleta;
import com.dengueefoco.model.Usuario;
import com.dengueefoco.util.ArquivoCsvUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@RestController
public class MainController {

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
    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping("/")
    public String index() {
        return "Dengue e Foco server started!";
    }


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Usuario usuarioBody, BindingResult bindingResult) {
        Usuario usuarioBanco = usuarioRepository.findByEmail(usuarioBody.getEmail());

        if (usuarioBanco != null && checarSenha(usuarioBanco.getSenha(), usuarioBody.getSenha())) {
            return ResponseEntity.ok(usuarioBanco);
//            JSONObject object = new JSONObject(usuarioBanco);
//            object.put("token", jwtService.toToken(usuarioBanco));
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.add(HttpHeaders.AUTHORIZATION, jwtService.toToken(usuarioBanco));
//
//            return (new ResponseEntity(usuarioBanco, headers, HttpStatus.OK));

        } else {
//            bindingResult.rejectValue("senha", "INVALIDA", "email ou senha invalido");
//            throw new InvalidRequestException(bindingResult);
            return ResponseEntity.badRequest().build();

        }
    }


    private boolean checarSenha(String senhaBanco, String senhaRequest) {
        return senhaBanco.equals(senhaRequest);
    }

    @RequestMapping("/populate")
    public String populateDataBase() {
        antivetorialRepository.deleteAll();
        dengueRepository.deleteAll();
        paletaRepository.deleteAll();
        ovitrampaRepository.deleteAll();
        populaAntivetoriais();
        populaDengue();
        populaOvitrampas();

        return "Populate database";
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