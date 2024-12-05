package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;
import java.awt.Color;

public class TablaParticipante extends JFrame {

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
                    TablaParticipante frame = new TablaParticipante();
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
    public TablaParticipante() {
    	setForeground(Color.WHITE);
    	setIconImage(Toolkit.getDefaultToolkit().getImage(TablaParticipante.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-more-details@2x.png")));
        setTitle("Tabla de Participantes");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        // Tabla para mostrar los participantes
        String[] columnNames = {"Código", "Nombre", "Apellido", "Dirección", "Email"};
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

