package clases;

import java.util.Scanner;
import java.util.InputMismatchException;

public class PedirHora {
    public static void main(String[] args) {
        // variables del programa
        int hora = 0;
        int minuto = 0;
        int segundo = 0;
        int segundosIncremento = 0;
        Hora h;
        Boolean numCorrecto = false;
        Scanner sc = new Scanner(System.in);

        do {
            try {
                System.out.print("Introduzca la hora: ");
                hora = sc.nextInt();
                numCorrecto = true;

            } catch (InputMismatchException e) {
                System.out.println("El dato introducido no es correcto");
                sc.next();
            }
        } while (!numCorrecto);

        do {
            try {
                numCorrecto = false;
                System.out.print("Introduzca los minutos: ");
                minuto = sc.nextInt();
                numCorrecto = true;

            } catch (InputMismatchException e) {
                System.out.println("El dato introducido no es correcto");
                sc.next();
            }
        } while (!numCorrecto);

        do {
            try {
                numCorrecto = false;
                System.out.print("Introduzca los segundos: ");
                segundo = sc.nextInt();
                numCorrecto = true;

            } catch (InputMismatchException e) {
                System.out.println("El dato introducido no es correcto");
                sc.next();
            }
        } while (!numCorrecto);

        h = new Hora(hora, minuto, segundo);
        do {
            try {
                numCorrecto = false;
                System.out.print("Introduzca la cantidad de segundos a sumar: ");
                segundosIncremento = sc.nextInt();
                numCorrecto = true;

            } catch (InputMismatchException e) {
                System.out.println("El dato introducido no es correcto");
                sc.next();
            }
        } while (!numCorrecto);
        sc.close();
        h.incrementoHora(segundosIncremento);


    }
}
