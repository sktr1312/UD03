package prueba;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PedirHora {
    public static void main(String[] args) {
        int hora = 0;
        int minuto = 0;
        int segundo = 0;
        Hora h;
        Scanner sc = new Scanner(System.in);
        boolean numCorrecto = false;
        int n = 0;

        do {
            try {
                System.out.print("Introduzca la hora: ");
                hora = sc.nextInt();
                numCorrecto = true;

            } catch (InputMismatchException e) {
                System.out.println("El dato introducida no es adecuado");
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
                System.out.println("El dato introducida no es adecuado");
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
                System.out.println("El dato introducida no es adecuado");
                sc.next();

            }
        } while (!numCorrecto);
        h = new Hora(hora, minuto, segundo);

        do {
            try {
                numCorrecto = false;
                System.out.print("Ahora introduzca la cantidad de segundos a sumar: ");
                n = sc.nextInt();
                numCorrecto = true;
            } catch (InputMismatchException e) {
                System.out.println("El dato introducida no es adecuado");
                sc.next();

            }
        } while (!numCorrecto);
        sc.close();
        h.sumarSegundos(n);

    }
}