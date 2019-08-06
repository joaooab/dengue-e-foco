package com.dengueefoco;

import com.dengueefoco.core.*;
import com.dengueefoco.model.*;
import com.dengueefoco.util.ArquivoCsvUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PopulaBancoComArquivosCsv implements ApplicationRunner {

    private static final boolean RODAR_POPULATE_LIMPO = false;
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

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Usuario usuario = new Usuario();
        usuario.setEmail("joao@gmail");
        usuario.setNome("Joao");
        usuario.setSenha("1234");
        usuario.setTipoUsuario(TipoUsuario.ADMIM);
        usuarioRepository.save(usuario);

        if (RODAR_POPULATE_LIMPO) {
            populaAntivetoriais();
            populaDengue();
            populaOvitrampas();
        }

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
