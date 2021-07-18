/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Ferramentas | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
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
public class Ferramentas {
    
    CSV csv;
    
    public Ferramentas(){};
    
    public Ferramentas(CSV csv){
        this.csv = csv;
    }

    public CSV getCsv() {
        return csv;
    }

    public void setCsv(CSV csv) {
        this.csv = csv;
    }
    

    private Double[] criaSeriesCandle(String linha) {

        String[] dados = linha.split(",");
        Double[] ohlc = new Double[5];
        double abertura = 0.0;
        double maxima = 0.0;
        double minima = 0.0;
        double fechamento = 0.0;
        double volume = 0.0;

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

        ohlc[0] = abertura;
        ohlc[1] = maxima;
        ohlc[2] = minima;
        ohlc[3] = fechamento;
        ohlc[4] = volume;
        return ohlc;
    }

    public OHLCSeries preencheOHLCSeries() {

        OHLCSeries ohlcseries = new OHLCSeries("Valor");
        BufferedReader br = null;
        String linha = "";

        try {
            br = new BufferedReader(new FileReader(csv.getDiretorio()));
            br.readLine();

            while ((linha = br.readLine()) != null) {

                Date data = retornaData(linha);
                Double[] valores = criaSeriesCandle(linha);
                FixedMillisecond t = new FixedMillisecond(data);
                ohlcseries.add(t, valores[0], valores[1], valores[2], valores[3]);
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

        return ohlcseries;

    }

    private Date retornaData(String linha) {

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String[] dados = linha.split(",");
        Date data = null;
        try {
            data = formato.parse(dados[0]);

        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return data;

    }

    private TimeSeries retornaVolume() {

        TimeSeries volume = new TimeSeries("Volume");
        BufferedReader br = null;
        String linha = "";

        try {

            br = new BufferedReader(new FileReader(csv.getDiretorio()));
            br.readLine();
            while ((linha = br.readLine()) != null) {

                Date data = retornaData(linha);
                Double[] valores = criaSeriesCandle(linha);
                FixedMillisecond t = new FixedMillisecond(data);
                volume.add(t, valores[4]);
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
        return volume;
    }
    
    
    public JFreeChart montaOHLCSeriesChart() {

        OHLCSeriesCollection candCollection = new OHLCSeriesCollection();
        OHLCSeries ohlcseries = preencheOHLCSeries();
        candCollection.addSeries(ohlcseries);

        NumberAxis eixoX = new NumberAxis("Valor");
        eixoX.setAutoRange(true); // da zoom na região que mais possui candles

        //Modifica a largura do Candle
        CandlestickRenderer candlestickRenderer = new CandlestickRenderer(CandlestickRenderer.WIDTHMETHOD_AVERAGE);
        XYPlot candlestickSubplot = new XYPlot(candCollection, null, eixoX, candlestickRenderer);
        candlestickSubplot.setBackgroundPaint(new Color(86, 85, 89));

        //Adiciona volume
        TimeSeriesCollection volumeDataset = new TimeSeriesCollection();
        TimeSeries volumeSeries = retornaVolume();
        volumeDataset.addSeries(volumeSeries);

        NumberAxis volumeAxis = new NumberAxis("Volume");
        volumeAxis.setAutoRangeIncludesZero(false);
        volumeAxis.setNumberFormatOverride(new DecimalFormat("0"));
        XYBarRenderer timeRenderer = new XYBarRenderer();
        timeRenderer.setShadowVisible(false);
        timeRenderer.setDefaultToolTipGenerator(new StandardXYToolTipGenerator("Volume--> Time={1} Size={2}",
                new SimpleDateFormat("kk:mm"), new DecimalFormat("0")));
        XYPlot volumeSubplot = new XYPlot(volumeDataset, null, volumeAxis, timeRenderer);
        volumeSubplot.setBackgroundPaint(Color.white);

        DateAxis dateAxis = new DateAxis("Tempo");
        dateAxis.setDateFormatOverride(new SimpleDateFormat("kk:mm"));
        dateAxis.setLowerMargin(0.5);
        dateAxis.setUpperMargin(0.5);

        CombinedDomainXYPlot mainPlot = new CombinedDomainXYPlot(dateAxis);
        mainPlot.setGap(10.0);
        mainPlot.add(candlestickSubplot, 3); // o valor é referente ao tamanho total ocupado na tela 
        mainPlot.add(volumeSubplot, 1);
        mainPlot.setOrientation(PlotOrientation.VERTICAL);

        JFreeChart chart = new JFreeChart(csv.getNomeAcao(), JFreeChart.DEFAULT_TITLE_FONT, mainPlot, true);
        chart.removeLegend();

        return chart;
    }
}
