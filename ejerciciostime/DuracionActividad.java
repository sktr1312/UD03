package ejerciciostime;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DuracionActividad {
    // Desarrolla una aplicación que calcule la duración total de una actividad. La
    // actividad tiene una hora de inicio (LocalTime) y una hora de finalización
    // (LocalTime). El programa debe mostrar la duración total en horas y minutos.

    public static void main(String[] args) {
        String inicio;
        String fin;

        System.out.print("Introduzca la hora de inicio(HH:mm): ");
        inicio = new Scanner(System.in).nextLine();
        LocalTime horaInicio = LocalTime.parse(inicio, DateTimeFormatter.ofPattern("HH:mm"));

        System.out.print("Introduzca la hora de fin(HH:mm): ");
        fin = new Scanner(System.in).nextLine();
        LocalTime horaFin = LocalTime.parse(fin, DateTimeFormatter.ofPattern("HH:mm"));
        System.out.println(horaFin);
        

        long duraciónHoras = horaInicio.until(horaFin, ChronoUnit.HOURS);
        long duraciónMinutos = horaInicio.until(horaFin, ChronoUnit.MINUTES) % 60;

        System.out.println("La duracion de la actividad es de " + duraciónHoras + " horas y " + duraciónMinutos + " minutos" );

    }

}
