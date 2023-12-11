package ejerciciostime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class cumple {
    // Escribe un programa que solicite al usuario su fecha de nacimiento
    // (LocalDate) y calcule el tiempo restante hasta su próximo cumpleaños. Muestra
    // el resultado en días, horas y minutos.

    public static void main(String[] args) {
        String fechaCumpleaños;
        LocalDate fechaActual;


        System.out.println("Introduzca su fecha de cumpleaños(dd/MM/yyyy): ");
        fechaCumpleaños = new Scanner(System.in).nextLine();
        LocalDate cumpleaños = LocalDate.parse(fechaCumpleaños, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println(cumpleaños);
        fechaActual = LocalDate.now();
        System.out.println(fechaActual);

        long diasRestantes = fechaActual.until(cumpleaños, )



    }

}
