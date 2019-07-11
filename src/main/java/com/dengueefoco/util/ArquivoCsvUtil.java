package com.dengueefoco.util;

import com.dengueefoco.model.Antivetorial;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ArquivoCsvUtil {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public ArrayList<Antivetorial> converteCsvEmAntivetoriais(String nomeArquivo) {
        ArrayList<Antivetorial> antivetoriais = new ArrayList<>();
        try {
            File file = getArquivo(nomeArquivo);
            FileReader filereader = new FileReader(file);
            CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
            CSVReader csvReader = new CSVReaderBuilder(filereader).withCSVParser(parser).build();
            String[] proximoRegistro;
            while ((proximoRegistro = csvReader.readNext()) != null) {
                Antivetorial antivetorial  = criarAntiVetorial(proximoRegistro);
                antivetoriais.add(antivetorial);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return antivetoriais;
    }

    private Antivetorial criarAntiVetorial(String[] proximoRegistro) throws ParseException {
        Antivetorial antivetorial = new Antivetorial();
        int index = 0;
        for (String coluna : proximoRegistro) {
            switch (index) {
                case 0:
                    antivetorial.setIdUsuario(Long.parseLong(coluna));
                    break;
                case 1:
                    antivetorial.setDataVisita(simpleDateFormat.parse(coluna));
                    break;
                case 2:
                    antivetorial.setLarvicida(coluna);
                    break;
                case 3:
                    antivetorial.setQtdLarvicida(Double.parseDouble(coluna));
                    break;
                case 4:
                    antivetorial.setStatusImovel(coluna);
                    break;
                case 5:
                    antivetorial.setTipoImovel(coluna);
                    break;
                case 6:
                    antivetorial.setRegiao(coluna);
                    break;
                case 7:
                    antivetorial.setLongitude(converteColunaEmLatLon(coluna));
                    break;
                case 8:
                    antivetorial.setLatitude(converteColunaEmLatLon(coluna));
                    break;

            }
            index++;
        }

        return antivetorial;
    }


    private double converteColunaEmLatLon(String coluna) {
        return Double.parseDouble(coluna
                .replace("\t", "")
                .replace("\"", "")
                .replace(",", "."));
    }

    public File getArquivo(String nomeArquivo) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("csv/" + nomeArquivo);
        if (resource == null) {
            throw new IllegalArgumentException("arquivo não encontrado!");
        } else {
            return new File(resource.getFile());
        }
    }

}
