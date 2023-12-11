package proyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VerificarUsuarioGUI extends JFrame {
    private JTextField textFieldUsuario;
    private JLabel labelResultado;

    public VerificarUsuarioGUI() {
        super("Verificar Usuario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel labelUsuario = new JLabel("Ingrese el nombre de usuario:");
        labelUsuario.setBounds(20, 20, 200, 25);
        panel.add(labelUsuario);

        textFieldUsuario = new JTextField();
        textFieldUsuario.setBounds(220, 20, 200, 25);
        panel.add(textFieldUsuario);

        JButton buttonVerificar = new JButton("Verificar Usuario");
        buttonVerificar.setBounds(20, 50, 200, 25);
        buttonVerificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarUsuario();
            }
        });
        panel.add(buttonVerificar);

        labelResultado = new JLabel("");
        labelResultado.setBounds(20, 80, 400, 25);
        panel.add(labelResultado);

        add(panel);
        setSize(450, 150);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void verificarUsuario() {
        String nombreUsuario = textFieldUsuario.getText();

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
                    String idUsuario = resultado.getString("id");
                    String correoUsuario = resultado.getString("email");

                    labelResultado.setText("Información del usuario: id=" + idUsuario + ", Correo=" + correoUsuario);
                } else {
                    labelResultado.setText("El usuario no existe en la base de datos.");
                    String nuevoEmail = JOptionPane.showInputDialog(this, "Ingrese el correo del nuevo usuario:");
                    String nuevoPassword = JOptionPane.showInputDialog(this,
                            "Ingrese la contraseña del nuevo usuario:");
                    String nuevoRoles = JOptionPane.showInputDialog(this,
                            "Ingrese su rol:"); // Puedes ajustar los roles según tus
                                                                         // necesidades

                    // Realiza la inserción con los datos proporcionados por el usuario
                    String insertarUsuario = "INSERT INTO user (email, roles, password, is_verified, username, created_at, updated_at, last_login, enabled, photo_filename) VALUES (?, ?, ?, ?, ?, NOW(), NOW(), NOW(), ?, ?)";
                    try (PreparedStatement insertStatement = conexion.prepareStatement(insertarUsuario)) {
                        insertStatement.setString(1, nuevoEmail);
                        insertStatement.setString(2, nuevoRoles);
                        insertStatement.setString(3, nuevoPassword);
                        insertStatement.setBoolean(4, true);
                        insertStatement.setString(5, nombreUsuario);
                        insertStatement.setBoolean(6, true);
                        insertStatement.setString(7, "default.jpg");

                        int filasAfectadas = insertStatement.executeUpdate();

                        if (filasAfectadas > 0) {
                            labelResultado.setText("Nuevo usuario creado con éxito.");
                        } else {
                            labelResultado.setText("Error al crear el nuevo usuario.");
                        }
                    }
                }
            }

            conexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar a la base de datos", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new VerificarUsuarioGUI();
    }
}