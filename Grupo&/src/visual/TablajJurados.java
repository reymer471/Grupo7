package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TablaJurado extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private JButton btnCerrar;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TablaJurado frame = new TablaJurado();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public TablaJurado() {
        setTitle("Tabla de Jurados");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        // Tabla para mostrar los jurados
        String[] columnNames = {"Código", "Nombre", "Apellido", "Experiencia", "Especialidad"};
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        // Botón para cerrar
        JPanel buttonPane = new JPanel();
        contentPane.add(buttonPane, BorderLayout.SOUTH);
        
        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose()); // Cierra la ventana
        buttonPane.add(btnCerrar);
    }
}
