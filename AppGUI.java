import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AppGUI extends JFrame {

    private JTextField inputField;
    private JButton btnAgregar, btnLimpiar;
    private DefaultListModel<String> listModel;
    private JList<String> listaDatos;

    public AppGUI() {
        // Configuración de la ventana principal
        setTitle("Aplicación GUI Básica - Gestión de Datos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar ventana
        setLayout(new BorderLayout(10, 10));

        // Panel superior con etiqueta y campo de texto
        JPanel panelSuperior = new JPanel(new FlowLayout());
        JLabel lblTexto = new JLabel("Ingrese un dato:");
        inputField = new JTextField(20);
        panelSuperior.add(lblTexto);
        panelSuperior.add(inputField);

        // Panel central con la lista
        listModel = new DefaultListModel<>();
        listaDatos = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(listaDatos);

        // Panel inferior con botones
        JPanel panelInferior = new JPanel(new FlowLayout());
        btnAgregar = new JButton("Agregar");
        btnLimpiar = new JButton("Limpiar");
        panelInferior.add(btnAgregar);
        panelInferior.add(btnLimpiar);

        // Agregar los paneles a la ventana
        add(panelSuperior, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        // Eventos de botones
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String texto = inputField.getText().trim();
                if (!texto.isEmpty()) {
                    listModel.addElement(texto);
                    inputField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "El campo está vacío. Ingrese un dato válido.");
                }
            }
        });

        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inputField.setText(""); // limpia campo de texto
                listModel.clear();     // limpia toda la lista
            }
        });

        // Evento de selección en la lista (opcional)
        listaDatos.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String seleccionado = listaDatos.getSelectedValue();
                if (seleccionado != null) {
                    System.out.println("Seleccionado: " + seleccionado);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AppGUI().setVisible(true);
        });
    }
}
