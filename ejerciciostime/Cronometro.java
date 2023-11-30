package ejerciciostime;

import java.time.*;
import java.util.Scanner;

public class Cronometro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LocalDateTime inicioCronometro = null;
        LocalDateTime ultimaVezPulsado = null;
        LocalDateTime ahora;
        Duration tiempoTotal;
        Duration tiempoParcial;

        System.out.println("Bienvenido al cronómetro. Pulsa ENTER para iniciar o introduce 0 para salir.");

        while (true) {
            String entrada = scanner.nextLine();

            if (entrada.equals("")) { // Usuario pulsa ENTER
                if (inicioCronometro == null) {
                    // Iniciar el cronómetro
                    inicioCronometro = LocalDateTime.now();
                    ultimaVezPulsado = inicioCronometro;
                    System.out.println("Cronómetro iniciado. Pulsa ENTER de nuevo para detener.");
                } else {
                    // Detener el cronómetro y mostrar el tiempo transcurrido
                    ahora = LocalDateTime.now();
                    tiempoTotal = Duration.between(inicioCronometro, ahora);
                    tiempoParcial = Duration.between(ultimaVezPulsado, ahora);

                    System.out.println("Tiempo total: " + tiempoTotal.toMinutes() + " minutos y "
                            + tiempoTotal.getSeconds() % 60 + " segundos.");
                    System.out.println("Tiempo parcial desde la última vez: " + tiempoParcial.toMinutes()
                            + " minutos y " + tiempoParcial.getSeconds() % 60 + " segundos.");
                    ultimaVezPulsado = ahora;
                    System.out.println("Pulsa ENTER de nuevo para continuar o introduce 0 para salir.");
                }
            } else if (entrada.equals("0")) {
                // Salir del programa
                System.out.println("Saliendo del cronómetro. ¡Hasta luego!");
                break;
            } else {
                System.out.println("Entrada no válida. Pulsa ENTER para iniciar o introduce 0 para salir.");
            }
        }

        scanner.close();
    }

}