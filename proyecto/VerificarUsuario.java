package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class VerificarUsuario {

    public static void erificarUsuario() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();

        // Datos de conexión a la base de datos
        String url = "jdbc:mysql://sql.freedb.tech:3306/freedb_proyecto-1";
        String usuarioBD = "freedb_sktr1312";
        String passwordBD = "TNhm42KnY?PqkkR";

        try {
            // Establecer conexión con la base de datos
            Connection conexion = DriverManager.getConnection(url, usuarioBD, passwordBD);

            // Consulta para verificar la existencia del usuario
            String consulta = "SELECT * FROM user WHERE username = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(consulta)) {
                preparedStatement.setString(1, nombreUsuario);

                // Ejecutar la consulta
                ResultSet resultado = preparedStatement.executeQuery();

                if (resultado.next()) {
                    // El usuario existe, obtener información
                    String nombre = resultado.getString("id");
                    String correo = resultado.getString("email");

                    System.out.println("Información del usuario:");
                    System.out.println("id: " + nombre);
                    System.out.println("Correo: " + correo);
                } else {
                    System.out.println("El usuario no existe en la base de datos.");
                }
            }

            // Cerrar la conexión
            scanner.close();
            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
