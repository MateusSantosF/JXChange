/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.data.time.MovingAverage;
import org.jfree.data.xy.DefaultOHLCDataset;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author Mateus
 */
public class Acao extends CSV {
    
    DefaultOHLCDataset dataset;
    
    public Acao(CSV csv) {
        super(csv.getDiretorio(), csv.getNomeAcao());
        
        this.dataset = super.montaDataSet(super.montaDataItem());
    }
    
    public DefaultOHLCDataset getDataset() {
        return dataset;
    }
    
    public void setDataset(DefaultOHLCDataset dataset) {
        this.dataset = dataset;
    }
    
    public JFreeChart montaGrafico() {
        JFreeChart chart = ChartFactory.createCandlestickChart(super.getNomeAcao(), "Data", "Valor", getDataset(), true);
        chart.removeLegend();        
        chart.setBackgroundPaint(Color.WHITE);
        return chart;        
    }    

    public void calculaMMA(ChartPanel painel, int periodo) {
        XYPlot xyplot = (XYPlot) painel.getChart().getPlot();        
        int contDataset = xyplot.getDatasetCount();
        
        try {
            XYDataset dataset1 = MovingAverage.createMovingAverage(xyplot.getDataset(), "-MA30", periodo * 24L * 60L * 60L * 1000L, 0L);            
            xyplot.setDataset(contDataset, dataset1);
            xyplot.setRenderer(contDataset, new StandardXYItemRenderer());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Periodo muito grande para este conjunto de dados.");
        }
        
    }
    
}
