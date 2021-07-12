package Core;

import java.time.LocalDate;

public class Candle {
    private final double abertura;
    private final double maxima;
    private final double minima;
    private final double fechamento;
    private final double volume;
    private final TimeFrame tempo;
    private final LocalDate data;

    public Candle() {
        this(0.0, 0.0, 0.0, 0.0, 0.0, TimeFrame.DIARIO, LocalDate.now());
    }

    public Candle(double abertura, double maxima, double minima,
            double fechamento, double volume, TimeFrame tempo, LocalDate data) {
        this.abertura = abertura;
        this.maxima = maxima;
        this.minima = minima;
        this.fechamento = fechamento;
        this.volume = volume;
        this.tempo = tempo;
        this.data = data;
    }

    public double getAbertura() {
        return abertura;
    }

    public LocalDate getData() {
        return data;
    }

    public double getFechamento() {
        return fechamento;
    }

    public double getMaxima() {
        return maxima;
    }

    public double getMinima() {
        return minima;
    }

    public TimeFrame getTempo() {
        return tempo;
    }

    public double getVolume() {
        return volume;
    }
    
    @Override
    public String toString(){

        return data.toString() + "," + abertura + "," + maxima + "," +
                minima + "," + fechamento;
    }
}
