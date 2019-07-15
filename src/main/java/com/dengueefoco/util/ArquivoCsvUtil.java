package com.dengueefoco.util;

import com.dengueefoco.model.Antivetorial;
import com.dengueefoco.model.Dengue;
import com.dengueefoco.model.Ovitrampa;
import com.dengueefoco.model.Paleta;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ArquivoCsvUtil {

    private SimpleDateFormat dateFormatAntivetorial = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat dateFormatDengue = new SimpleDateFormat("dd/MM/yyyy");
    private SimpleDateFormat dateFormatOvitrampas = new SimpleDateFormat("dd/MM/yy");

    public ArrayList<Antivetorial> converteCsvEmAntivetoriais(String nomeArquivo) {
        ArrayList<Antivetorial> antivetoriais = new ArrayList<>();
        try {
            Scanner scanner = getScanner(nomeArquivo);
            while (scanner.hasNext()) {
                String[] colunasTratadas = getColunasTratadas(scanner, ";");
                Antivetorial antivetorial = criarAntiVetorial(colunasTratadas);
                antivetoriais.add(antivetorial);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return antivetoriais;
    }

    private Antivetorial criarAntiVetorial(String[] colunas) throws ParseException {
        Antivetorial antivetorial = new Antivetorial();
        antivetorial.setIdUsuario(toLong(getColuna(colunas, 0)));
        antivetorial.setDataVisita(toDate(getColuna(colunas, 1), dateFormatAntivetorial));
        antivetorial.setLarvicida(getColuna(colunas, 2));
        antivetorial.setQtdLarvicida(toDouble(getColuna(colunas, 3)));
        antivetorial.setStatusImovel(getColuna(colunas, 4));
        antivetorial.setTipoImovel(getColuna(colunas, 5));
        antivetorial.setRegiao(getColuna(colunas, 6));
        antivetorial.setLongitude(toDouble(getColuna(colunas, 7)));
        antivetorial.setLatitude(toDouble(getColuna(colunas, 8)));

        return antivetorial;
    }

    public ArrayList<Dengue> converteCsvEmDengues(String nomeArquivo) {
        ArrayList<Dengue> dengues = new ArrayList<>();
        try {
            Scanner scanner = getScanner(nomeArquivo);
            while (scanner.hasNext()) {
                String[] colunasTratadas = getColunasTratadas(scanner, ",");
                Dengue dengue = criarDengue(colunasTratadas);
                dengues.add(dengue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dengues;
    }

    private Dengue criarDengue(String[] colunas) throws ParseException {
        Dengue dengue = new Dengue();
        dengue.setDataSinPri(toDate(getColuna(colunas, 0), dateFormatDengue));
        dengue.setSemPri(getColuna(colunas, 1));
        dengue.setDataNascimento(toDate(getColuna(colunas, 2), dateFormatDengue));
        dengue.setNuIdade(getColuna(colunas, 3));
        dengue.setSexo(getColuna(colunas, 4));
        dengue.setIdMinResi(getColuna(colunas, 5));
        dengue.setIdDestrito(getColuna(colunas, 6));
        dengue.setIdBairro(getColuna(colunas, 7));
        dengue.setNmBairro(getColuna(colunas, 8));
        dengue.setIdLogradouro(getColuna(colunas, 9));
        dengue.setNmLogradouro(getColuna(colunas, 10));
        dengue.setNuNumero(getColuna(colunas, 11));
        dengue.setNmComplem(getColuna(colunas, 12));
        dengue.setClassiFin(getColuna(colunas, 13));

        return dengue;
    }

    public ArrayList<Paleta> converteCsvEmOvitrampas(String nomeArquivo) {
        ArrayList<Paleta> paletas = new ArrayList<>();
        try {
            Scanner scanner = getScanner(nomeArquivo);
            String[] datas = scanner.nextLine().split(",");
            while (scanner.hasNext()) {
                String[] colunasTratadas = getColunasTratadas(scanner, ",");
                Paleta paleta = criarPaleta(colunasTratadas);
                Set<Ovitrampa> ovitrampas = criarOvitrampa(colunasTratadas, datas, paleta);
                paleta.setOvitrampaSet(ovitrampas);
                paletas.add(paleta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return paletas;
    }

    private Paleta criarPaleta(String[] colunas) throws ParseException {
        Paleta paleta = new Paleta();
        paleta.setId(toLong(getColuna(colunas, 0)));
        paleta.setDistrito(getColuna(colunas, 1));
        paleta.setLongitude(toDouble(getColuna(colunas, 64) + "." + getColuna(colunas, 65)));
        paleta.setLatitude(toDouble(getColuna(colunas, 66) + "." + getColuna(colunas, 67)));

        return paleta;
    }

    private Set<Ovitrampa> criarOvitrampa(String[] colunasTratadas, String[] datas, Paleta paleta) throws ParseException {
        Set<Ovitrampa> ovitrampas = new HashSet<>();
        for (int i = 2; i <= 63; i ++) {
            Ovitrampa ovitrampa = new Ovitrampa();
            ovitrampa.setPaleta(paleta);
            ovitrampa.setDataLeitura(toDate(getColuna(datas, i), dateFormatOvitrampas));
            ovitrampa.setQtdOvos(toLong(getColuna(colunasTratadas, i)));
            ovitrampas.add(ovitrampa);
        }

        return ovitrampas;
    }

    private String[] getColunasTratadas(Scanner scanner, String regex) {
        String linha = scanner.nextLine();
        String[] colunas = linha.split(regex);
        return tratarColunas(colunas);
    }

    private Scanner getScanner(String nomeArquivo) throws FileNotFoundException {
        File file = getArquivo(nomeArquivo);
        FileReader filereader = new FileReader(file);
        return new Scanner(filereader);
    }

    private String getColuna(String[] colunas, int i) {
        if (i >= colunas.length) return "";
        return colunas[i];
    }

    private String[] tratarColunas(String[] colunas) {
        String[] colunasTratadas = new String[colunas.length];
        int index = 0;
        for (String coluna : colunas) {
            colunasTratadas[index] = tratar(coluna);
            index++;
        }

        return colunasTratadas;
    }

    private String tratar(String coluna) {
        return coluna
                .trim()
                .replaceAll("\t", "")
                .replaceAll("\"", "")
                .replace(",", ".");
    }

    private File getArquivo(String nomeArquivo) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("csv/" + nomeArquivo);
        if (resource == null) {
            throw new IllegalArgumentException("arquivo não encontrado!");
        } else {
            return new File(resource.getFile());
        }
    }

    private static double toDouble(String coluna) {
        return Double.parseDouble(coluna);
    }

    private static Date toDate(String coluna, SimpleDateFormat simpleDateFormat) throws ParseException {
        return simpleDateFormat.parse(coluna);
    }

    private static long toLong(String coluna) {
        return Long.parseLong(coluna);
    }


}
