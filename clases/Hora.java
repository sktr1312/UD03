package clases;

public class Hora {
    // atributos
    private int hora;
    private int minuto;
    private int segundo;

    // contructor
    public Hora(int hora, int minuto, int segundo) {
        setHora(hora);
        setMinuto(minuto);
        setSegundo(segundo);
    }

    // getters y setters
    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        if (hora > 0 && hora < 24) {
            this.hora = hora;
        } else {
            this.hora = 0;
        }
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        if (minuto > 0 && minuto < 60) {
            this.minuto = minuto;
        } else {
            minuto = 0;
        }
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        if (segundo > 0 && segundo < 60) {
            this.segundo = segundo;
        } else {
            this.segundo = 0;
        }
    }

    // metodos

    public String mostrarHora() {
        String horaFormateda = String.format("%02d:%02d:%02d", hora, minuto, segundo);
        return horaFormateda;

    }

    public void incrementoHora(int n) {

        for (int i = 0; i <= n; i++) {
          String horaFormateada = mostrarHora();
          System.out.println("La hora es: " + horaFormateada);
            segundo++;
            if (segundo == 60) {
                segundo = 0;
                minuto++;
                if (minuto == 60) {
                    minuto = 0;
                    hora++;
                    if (hora == 24) {
                        hora = 0;
                    }
                }
            }
        }
    }
}
