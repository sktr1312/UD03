package ejerciciosmath;

import java.util.Scanner;

public class Circulo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Radio del circulo/esfera: ");
        double radio = sc.nextDouble();
        sc.close();
        
        System.out.println("El area sera: " + Math.PI * Math.pow(radio, 2));

        System.out.println("El perimetro será: " + 2 * Math.PI * radio);

        System.out.println("El volumen será: " + 4 / 3.0 * Math.PI * Math.pow(radio, 3));
    }
}
