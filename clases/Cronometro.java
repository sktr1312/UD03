package clases;

import java.util.Scanner;

public class Cronometro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long inicioCronometro = 0;
        long tiempoParcial = 0;

        System.out.println("Bienvenido al cronómetro. Pulsa ENTER para iniciar o introduce 0 para salir.");

        while (true) {
            String entrada = scanner.nextLine();

            if (entrada.equals("")) { // Usuario pulsa ENTER
                if (inicioCronometro == 0) {
                    // Iniciar el cronómetro
                    inicioCronometro = System.currentTimeMillis();
                    System.out.println("Cronómetro iniciado. Pulsa ENTER de nuevo para detener.");
                } else {
                    // Detener el cronómetro y mostrar el tiempo transcurrido
                    long tiempoActual = System.currentTimeMillis();
                    long tiempoTotal = (tiempoActual - inicioCronometro) / 1000; // Convertir a segundos
                    long tiempoParcialSegundos = (tiempoActual - (inicioCronometro + tiempoParcial)) / 1000;

                    System.out.println(
                            "Tiempo total: " + tiempoTotal / 60 + " minutos y " + tiempoTotal % 60 + " segundos.");
                    System.out.println("Tiempo parcial desde la última vez: " + tiempoParcialSegundos + " segundos.");
                    tiempoParcial = tiempoActual - inicioCronometro;
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