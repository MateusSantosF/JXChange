package data;

import Core.Candle;
import Core.TimeFrame;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProcessaCsv {
    private String caminhoArquivo;
    private File arquivo;

    public ProcessaCsv(String caminhoArquivo) {
        this.setArquivo(caminhoArquivo);
    }

    public ProcessaCsv() {
        //this("");
    }
    
    public void setArquivo(String caminho) {
        this.caminhoArquivo = caminho;
        arquivo = new File(this.caminhoArquivo);
    }

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public File getArquivo() {
        return arquivo;
    }
    
    public List<Candle> gerarSerieCandles() {
        List<Candle> serie = new ArrayList<>();
        try {            
            Scanner dados = new Scanner(arquivo);
            dados.nextLine(); // descarta primeira linha
            while (dados.hasNext()){
                serie.add(criarCandle(dados.nextLine()));
            }
            
        } catch (FileNotFoundException ex) {
            System.err.println("Erro ao tentar ler arquivo CSV.");
            System.err.println(">> Arquivo: " + getCaminhoArquivo());
            System.err.println(ex);
        }
        
        return serie;
    }
    
    private Candle criarCandle(String linha){
        String [] dados = linha.split(",");
        LocalDate data = gerarData(dados[0]);
        double abertura = Double.parseDouble(dados[1]);
        double maxima = Double.parseDouble(dados[2]);
        double minima = Double.parseDouble(dados[3]);
     
        double volume = Double.parseDouble(dados[5]);
        return new Candle(abertura, maxima, minima, volume, volume,
                TimeFrame.DIARIO, data);
    }
    
    private LocalDate gerarData(String campo) {
        String [] strData = campo.split("-");
        LocalDate data = LocalDate.of(
                Integer.parseInt(strData[0]),
                Integer.parseInt(strData[1]),
                Integer.parseInt(strData[2]));
        
        return data;
    }
}
