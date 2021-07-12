package Core;

import java.util.ArrayList;
import java.util.List;

public class Acao {
    private final String ticker;
    private List<Candle> serieCandles;

    public Acao() {
        this("NONE5");
    }

    public Acao(String ticker) {
        this.ticker = ticker;
        this.initSerieCandles();
    }  

    public String getTicker() {
        return ticker;
    }
    
    private void initSerieCandles() {
        serieCandles = new ArrayList<>();
    }
    
    public void addCandle(Candle c) {
        serieCandles.add(c);
    }
    
    public void removeCandle(Candle c) {
        serieCandles.remove(c);
    }
    
    public void addSerieCandles(List<Candle> serie) {
        serieCandles.clear();
        serieCandles.addAll(serie);
    }
    
    @Override
    public String toString(){
        StringBuilder strAcao = new StringBuilder(ticker);
        for (Candle candle : serieCandles) {
            strAcao.append("\n");
            strAcao.append(candle.toString());
        }
        return strAcao.toString();
    }    
    
}
