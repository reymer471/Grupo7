package visual;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import logico.SPEC;
import logico.Participante;
import logico.Persona;

public class TablaParticipante extends JDialog {
    private JTable table;
    private DefaultTableModel model;
    private JButton btnAgregar;
    private JButton btnEliminar;
    private JButton btnEditar;

    public TablaParticipante() {
        initComponents();
        cargarParticipantes();
    }

    private void initComponents() {
        setTitle("Listado de Participantes");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Configurar modelo de tabla
        String[] columnNames = {"Código", "Nombre", "Apellido", "Dirección", "Email"};
        model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Crear tabla
        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        btnAgregar = new JButton("Agregar");
        btnEliminar = new JButton("Eliminar");
        btnEditar = new JButton("Editar");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        add(panelBotones, BorderLayout.SOUTH);

        // Configurar listeners
        setupListeners();
    }

    private void setupListeners() {
        // Listener para agregar nuevo participante
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarPersona dialog = new AgregarPersona();
                dialog.setModal(true);
                dialog.setVisible(true);
                cargarParticipantes(); // Recargar lista después de agregar
            }
        });

        // Listener para eliminar participante
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    String codigo = (String) model.getValueAt(selectedRow, 0);
                    Participante participante = SPEC.getInstance().buscarParticipanteById(codigo);
                    
                    if (participante != null) {
                        int confirmacion = JOptionPane.showConfirmDialog(
                            TablaParticipante.this, 
                            "¿Está seguro que desea eliminar este participante?", 
                            "Confirmar Eliminación", 
                            JOptionPane.YES_NO_OPTION
                        );
                        
                        if (confirmacion == JOptionPane.YES_OPTION) {
                            SPEC.getInstance().eliminarPersona(participante);
                            cargarParticipantes();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(
                        TablaParticipante.this, 
                        "Seleccione un participante para eliminar", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        // Listener para editar participante
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    String codigo = (String) model.getValueAt(selectedRow, 0);
                    Participante participante = SPEC.getInstance().buscarParticipanteById(codigo);
                    
                    if (participante != null) {
                        // TODO: Implementar diálogo de edición de participante
                        JOptionPane.showMessageDialog(
                            TablaParticipante.this, 
                            "Funcionalidad de edición pendiente", 
                            "Información", 
                            JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                } else {
                    JOptionPane.showMessageDialog(
                        TablaParticipante.this, 
                        "Seleccione un participante para editar", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
    }

    private void cargarParticipantes() {
        // Limpiar tabla
        model.setRowCount(0);
        
        // Obtener lista de participantes
        ArrayList<Participante> participantes = obtenerParticipantes();
        
        // Llenar tabla
        for (Participante participante : participantes) {
            Object[] rowData = {
                participante.getCodigo(),
                participante.getNombre(),
                participante.getApellido(),
                participante.getDireccion(),
                participante.getEmail()
            };
            model.addRow(rowData);
        }
    }

    private ArrayList<Participante> obtenerParticipantes() {
        ArrayList<Participante> participantes = new ArrayList<>();
        
        // Filtrar solo participantes de la lista de personas
        for (Persona persona : SPEC.getInstance().getMisPersonas()) {
            if (persona instanceof Participante) {
                participantes.add((Participante) persona);
            }
        }
        
        return participantes;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TablaParticipante dialog = new TablaParticipante();
                dialog.setVisible(true);
            }
        });
    }
}
