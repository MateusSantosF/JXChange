/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.data.xy.DefaultOHLCDataset;
import org.jfree.data.xy.OHLCDataItem;

import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.CandlestickRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.time.FixedMillisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.ohlc.OHLCSeries;
import org.jfree.data.time.ohlc.OHLCSeriesCollection;

/**
 *
 * @author Mateus
 */
public class CSV {

    String diretorio;
    String nomeAcao;

    public CSV() {
    }

    ;
    
    public CSV(String diretorio, String nome) {
        this.diretorio = diretorio;
        this.nomeAcao = nome;

    }

    public String getDiretorio() {
        return diretorio;
    }

    public void setDiretorio(String diretorio) {
        this.diretorio = diretorio;
    }

    public String getNomeAcao() {
        return nomeAcao;
    }

    public void setNomeAcao(String nomeAcao) {
        this.nomeAcao = nomeAcao;
    }

    //============================ Gráfico Default ====================================
    public ArrayList<OHLCDataItem> montaDataItem(String diretorio) {

        ArrayList<OHLCDataItem> serie = new ArrayList<>();
        BufferedReader br = null;
        String linha = "";

        try {

            br = new BufferedReader(new FileReader(diretorio));
            br.readLine();
            while ((linha = br.readLine()) != null) {  
                if(validaLinha(linha)){
                   serie.add(criaCandle(linha));
                }      
            }

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }

        return serie;

    }
    
    private boolean validaLinha(String linha){
        if(linha.contains("null")){
            return false;
        }else{
            return true;
        }      
    }
    
    private OHLCDataItem criaCandle(String linha) {

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String[] dados = linha.split(",");
        double abertura = 0.0;
        double maxima = 0.0;
        double minima = 0.0;
        double fechamento = 0.0;
        double volume = 0.0;

        Date data = null;
        try {
            data = formato.parse(dados[0]);

        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        if (!dados[1].equals("null")) {
            abertura = Double.parseDouble(dados[1]);
        }
        if (!dados[2].equals("null")) {
            maxima = Double.parseDouble(dados[2]);
        }
        if (!dados[3].equals("null")) {
            minima = Double.parseDouble(dados[3]);
        }
        if (!dados[4].equals("null")) {
            fechamento = Double.parseDouble(dados[4]);
        }
        if (!dados[5].equals("null")) {
            volume = Double.parseDouble(dados[5]);
        }

        return new OHLCDataItem(data, abertura, maxima, minima, fechamento, volume);
        
    }

   

    //=================================== Gráfico personalizado ========================
   
    public DefaultOHLCDataset montaDataSet(ArrayList<OHLCDataItem> candles) {

        OHLCDataItem[] itens = new OHLCDataItem[candles.size()];

        for (int i = 0; i < itens.length; i++) {
            itens[i] = candles.get(i);          
        }
        
        return new DefaultOHLCDataset(itens[0], itens);
    }
     
}

