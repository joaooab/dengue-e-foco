package com.dengueefoco.util;

import com.dengueefoco.model.Antivetorial;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class ArquivoCsvUtilTest {

    @Test
    public void deve_importarArquivoCsv_corretamente() {
        ArrayList<Antivetorial> antivetorials = new ArquivoCsvUtil().converteCsvEmAntivetoriais("antivetorialteste.csv");
        assertEquals(50, antivetorials.size());
    }

}