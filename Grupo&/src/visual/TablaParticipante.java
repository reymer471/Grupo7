package visual;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import logico.Participante;

import java.awt.*;

public class TablaParticipante extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private JButton btnCerrar;

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

    public TablaParticipante() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(TablaParticipante.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
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
        btnCerrar.addActionListener(e -> dispose());
        buttonPane.add(btnCerrar);
    }

    public void agregarParticipantes(Participante participante) {
        model.addRow(new Object[]{participante.getCodigo(), participante.getNombre(), participante.getApellido(), participante.getDireccion(), participante.getEmail()});
    }
}

