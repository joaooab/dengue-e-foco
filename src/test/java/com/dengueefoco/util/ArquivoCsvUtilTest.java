package com.dengueefoco.util;

import com.dengueefoco.model.Antivetorial;
import com.dengueefoco.model.Dengue;
import com.dengueefoco.model.Paleta;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class ArquivoCsvUtilTest {

    @Test
    public void deve_importarAntivetorialArquivoCsv_corretamente() {
        ArrayList<Antivetorial> antivetorials = new ArquivoCsvUtil().converteCsvEmAntivetoriais("antivetorial1.csv");
        assertEquals(300, antivetorials.size());
    }

    @Test
    public void deve_importarDengueArquivoCsv_corretamente() {
        ArrayList<Dengue> dengues = new ArquivoCsvUtil().converteCsvEmDengues("dengue1.csv");
        assertEquals(300, dengues.size());
    }

    @Test
    public void deve_importarPaletasArquivoCsv_corretamente() {
        ArrayList<Paleta> paletas = new ArquivoCsvUtil().converteCsvEmOvitrampas("ovitrampas1.csv");
        assertEquals(300, paletas.size());
    }


}