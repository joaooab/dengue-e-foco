package com.dengueefoco;

import com.dengueefoco.core.AntivetorialRepository;
import com.dengueefoco.core.ArquivoCsvRepository;
import com.dengueefoco.model.Antivetorial;
import com.dengueefoco.util.ArquivoCsvUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;

@Component
public class PopulaBancoComArquivosCsv implements ApplicationRunner {

    @Autowired
    private AntivetorialRepository antivetorialRepository;
    @Autowired
    private ArquivoCsvRepository arquivoCsvRepository;

    private static final boolean RODAR_POPULATE_LIMPO = true;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        if (RODAR_POPULATE_LIMPO) {
            ArquivoCsvUtil arquivoCsvUtil = new ArquivoCsvUtil();
            ArrayList<Antivetorial> antivetoriais = arquivoCsvUtil.converteCsvEmAntivetoriais("antivetorial_100000.csv");
            for (Antivetorial antivetorial : antivetoriais) {
                antivetorialRepository.save(antivetorial);
            }
        }

    }

}
