package clases;

public class Bombilla {
    // atributos
    private boolean estadoBombilla;
    private static boolean estadoGeneral;

    // constructor
    public Bombilla(boolean estadoBombilla) {
        setEstadoBombilla(estadoBombilla);
    }

    public Bombilla() {
        this.estadoBombilla = true;
    }

    // getters y setters
    public boolean isEstadoBombilla() {
        return estadoBombilla;
    }

    public void setEstadoBombilla(boolean estadoBombilla) {
        if (estadoGeneral = false) {
            this.estadoBombilla = false;
        } else {
            this.estadoBombilla = estadoBombilla;
        }

    }

    public boolean isEstadoGeneral() {
        return estadoGeneral;
    }

    // metodos

    public void estadoBombilla() {
        if (estadoGeneral && estadoBombilla) {
            System.out.println("El estado de la bombilla es encendido");
        } else {
            System.out.println("El estado de la bombilla es apagado");
        }
    }

    public void encenderBombilla() {
            this.estadoBombilla = true;

        }

    public void apagarBombilla() {
        this.estadoBombilla = false;
    }

    public static void encenderInterruptor() {
        estadoGeneral = true;
    }

    public static void apagarInterruptor() {
        estadoGeneral = false;
    }

    public static void estadoGeneral() {
        System.out.println("El estado del interruptor general es: " + estadoGeneral);
    }

    public static void main(String[] args) {
        Bombilla bCocina, bSalon, bDormitorio;

        // crear bombillas
        bCocina = new Bombilla();
        bSalon = new Bombilla();
        bDormitorio = new Bombilla();

        // enciende interruptor general
        Bombilla.encenderInterruptor();

        // enciende y apaga bombillas
        bCocina.encenderBombilla();
        bSalon.apagarBombilla();
        bDormitorio.encenderBombilla();

        // muestra el estado

        bCocina.estadoBombilla();
        bSalon.estadoBombilla();
        bDormitorio.estadoBombilla();

        // apagar interruptor
        Bombilla.apagarInterruptor();

        // mostrarestado
        bCocina.estadoBombilla();
        bSalon.estadoBombilla();
        bDormitorio.estadoBombilla();

    }

}
