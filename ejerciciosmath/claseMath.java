package ejerciciosmath;

public class claseMath {

    static double generaNumeros(double VALOR_MINIMO, double VALOR_MAXIMO) {
        return (double) (Math.random() * (VALOR_MAXIMO - VALOR_MINIMO + 1) + VALOR_MINIMO);
    }

    public static void main(String[] args) {
        final int VALOR_MAXIMO = 360;
        final int VALOR_MINIMO = -360;
        double aleatorio = generaNumeros(VALOR_MINIMO, VALOR_MAXIMO);

        System.out.println("El numero aleatorio es : " + aleatorio);

        System.out.println("La raiz cuadrada es : " + Math.sqrt(aleatorio));
        System.out.println("Redondeo al entero mas cercano: " + Math.round(aleatorio));
        System.out.println("");
    
    }
}
