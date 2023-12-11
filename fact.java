public class fact {
    // Este método calcula el factorial de un número entero n usando recursividad
public static int factorial(int n) {
    // Caso base: si n es 0 o 1, el factorial es 1
    if (n == 0 || n == 1) {
      return 1;
    }
    // Caso recursivo: si n es mayor que 1, el factorial es n * factorial de n-1
    else {
      return n * factorial(n - 1);
    }
  }
  
  // Este método prueba el método factorial con algunos ejemplos
  public static void main(String[] args) {
    // Imprimir el factorial de 5
    System.out.println("El factorial de 5 es " + factorial(5));
    // Imprimir el factorial de 10
    System.out.println("El factorial de 10 es " + factorial(10));
    // Imprimir el factorial de 15
    System.out.println("El factorial de 15 es " + factorial(105));
  }
}
