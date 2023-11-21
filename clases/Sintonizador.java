package clases;

public class Sintonizador {
    // constantes
    public final static double FRECUENCIA_MINIMA = 80;
    public final static double FRECUENCIA_MAXIMA = 108;
    public final static double FRECUENCIA_SALTOS = 0.5;
    public final static double FRECUENCIA_SALTOS_PRECISOS = 0.1;

    // atributos
    private double frecuencia;
    private double mem1;
    private double mem2;
    private double mem3;

    // contructores
    public Sintonizador() {
        this(80);

    }

    public Sintonizador(int frecuencia) {
        try {
            setFrecuencia(frecuencia);
        } catch (IllegalArgumentException e) {
            throw e;
        }
        mem1 = FRECUENCIA_MINIMA;
        mem2 = FRECUENCIA_MINIMA;
        mem3 = FRECUENCIA_MINIMA;
    }

    // getters y setters
    public double getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(double frecuencia) {
        if (frecuencia < FRECUENCIA_MINIMA) {
            throw new IllegalArgumentException("Frecuencia demasiado baja");
        } else if (frecuencia > FRECUENCIA_MAXIMA) {
            throw new IllegalArgumentException("Frecuencia demasiado alta");
        } else {
            this.frecuencia = frecuencia;
        }
    }

    // metodos

    public void dysplay() {
        System.out.println("La frecuencia es: " + frecuencia + " MHz");
    }

    public void up() {
        frecuencia += FRECUENCIA_SALTOS;
        if (frecuencia > FRECUENCIA_MAXIMA) {
            frecuencia = FRECUENCIA_MINIMA;
        }
    }

    public void down() {
        frecuencia -= FRECUENCIA_SALTOS;
        if (frecuencia < FRECUENCIA_MINIMA) {
            frecuencia = FRECUENCIA_MAXIMA;
        }
    }

    public void guardarMemoria(int numMemoria) {
        switch (numMemoria) {
            case 1 -> mem1 = frecuencia;
            case 2 -> mem2 = frecuencia;
            case 3 -> mem3 = frecuencia;
            default ->
                System.exit(0);
        }

    }

    public void recuparMemoria(int numMemoria) {
        switch (numMemoria) {
            case 1 -> frecuencia = mem1;
            case 2 -> frecuencia = mem2;
            case 3 -> frecuencia = mem3;
            default ->
                System.exit(0);
        }
    }

    public void upPreciso() {
        frecuencia += FRECUENCIA_SALTOS_PRECISOS;
        if (frecuencia > FRECUENCIA_MAXIMA) {
            frecuencia = FRECUENCIA_MINIMA;
        }
    }

    public void downPreciso() {
        frecuencia -= FRECUENCIA_SALTOS_PRECISOS;
        if (frecuencia < FRECUENCIA_MINIMA) {
            frecuencia = FRECUENCIA_MAXIMA;
        }
    }

}
