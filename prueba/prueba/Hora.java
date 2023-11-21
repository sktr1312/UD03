package prueba;

public class Hora {
        // atributos
        private int hora;
        private int minuto;
        private int segundo;

        // constructors
        public Hora(int hora, int minuto, int segundo) {
                setHora(hora);
                setMinuto(minuto);
                setSegundo(segundo);
        }

        // getters y setters

        public int getHora() {
                return hora;
        }

        private void setHora(int hora) {
                if (hora >= 0 && hora < 24) {
                        this.hora = hora;
                } else {
                        System.out.println("La hora es incorrecta y se inicializara a 0");
                        this.hora = 0;
                }
        }

        public int getMinuto() {
                return minuto;
        }

        private void setMinuto(int minuto) {
                if (minuto >= 0 && minuto < 60) {
                        this.minuto = minuto;
                } else {
                        System.out.println("Los minutos son incorrectos y se inicializaran a 0");
                        this.minuto = 0;

                }

        }

        public int getSegundo() {
                return segundo;
        }

        private void setSegundo(int segundo) {
                if (segundo >= 0 && segundo < 60) {
                        this.segundo = segundo;
                } else {
                        System.out.println("Los segundos son incorrectos y se inicializaran a 0");
                        this.segundo = 0;
                }
        }

        // metodos

        public void mostrarHora() {
                System.out.printf("La hora es: %02d:%02d:%02d%n", hora, minuto, segundo);
          
        }

        public void sumarSegundos(int n) {
                for (int i = 0; i < n; i++) {
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
                        mostrarHora();

                }
        }

        public static void main(String[] args) {
                Hora h = new Hora(2, 0, 0);
                h.sumarSegundos(3600);
               
        }
}