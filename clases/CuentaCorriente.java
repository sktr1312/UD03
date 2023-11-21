package clases;

public class CuentaCorriente {
    // variables
    String nombre;
    String dni;
    double saldo;

    // contructor
    CuentaCorriente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    // metodos

    boolean sacarDinero(int cantidadDeRetirada) {
        boolean dineroSacado = false;

        if (cantidadDeRetirada <= saldo) {
            saldo -= cantidadDeRetirada;
            dineroSacado = true;
        }

        return dineroSacado;
    }

    void ingresarDinero(int dineroIngresado) {
        saldo += dineroIngresado;
    }

    void mostrarInformacion() {
        System.out.println("-----------------------------------");
        System.out.println("| El titular de la cuenta es: " + nombre + " |");
        System.out.println("| Con DNI: " + dni + "               |");
        System.out.println("| Y tiene de saldo: " + saldo + "€" + "          |");
        System.out.println("-----------------------------------");

    }
public static void main(String[] args) {
    CuentaCorriente c1 = new CuentaCorriente("agv", "5386538z");

    c1.mostrarInformacion();
}
}
