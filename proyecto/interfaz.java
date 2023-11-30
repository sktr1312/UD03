package proyecto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class interfaz extends JFrame {

    private JTextField nombreTextField;
    private JTextField apellidoTextField;

    public interfaz() {
        super("Agregar Usuario");

        // Crear componentes
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreTextField = new JTextField(20);

        JLabel apellidoLabel = new JLabel("Apellido:");
        apellidoTextField = new JTextField(20);

        JButton agregarButton = new JButton("Agregar");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para agregar el usuario (puedes implementar esto según tus necesidades)
                String nombre = nombreTextField.getText();
                String apellido = apellidoTextField.getText();

                // Puedes imprimir los valores o realizar alguna acción con ellos
                System.out.println("Nombre: " + nombre);
                System.out.println("Apellido: " + apellido);
            }
        });

        // Configurar el diseño de la interfaz
        setLayout(new GridLayout(3, 2));
        add(nombreLabel);
        add(nombreTextField);
        add(apellidoLabel);
        add(apellidoTextField);
        add(new JLabel()); // Espacio en blanco
        add(agregarButton);

        // Configuración de la ventana
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en la pantalla
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new interfaz();
            }
        });
    }
}
