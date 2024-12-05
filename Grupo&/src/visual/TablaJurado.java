package visual;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import logico.SPEC;
import logico.Jurado;
import logico.Persona;

public class TablaJurado extends JDialog {
    private JTable table;
    private DefaultTableModel model;
    private JButton btnAgregar;
    private JButton btnEliminar;
    private JButton btnEditar;

    public TablaJurado() {
        initComponents();
        cargarJurados();
    }

    private void initComponents() {
        setTitle("Listado de Jurados");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Configurar modelo de tabla
        String[] columnNames = {"Código", "Nombre", "Apellido", "Experiencia", "Especialidad"};
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
        // Listener para agregar nuevo jurado
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarPersona dialog = new AgregarPersona();
                dialog.setModal(true);
                dialog.setVisible(true);
                cargarJurados(); // Recargar lista después de agregar
            }
        });

        // Listener para eliminar jurado
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    String codigo = (String) model.getValueAt(selectedRow, 0);
                    Jurado jurado = SPEC.getInstance().buscarJuradoById(codigo);
                    
                    if (jurado != null) {
                        int confirmacion = JOptionPane.showConfirmDialog(
                            TablaJurado.this, 
                            "¿Está seguro que desea eliminar este jurado?", 
                            "Confirmar Eliminación", 
                            JOptionPane.YES_NO_OPTION
                        );
                        
                        if (confirmacion == JOptionPane.YES_OPTION) {
                            SPEC.getInstance().eliminarPersona(jurado);
                            cargarJurados();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(
                        TablaJurado.this, 
                        "Seleccione un jurado para eliminar", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        // Listener para editar jurado
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    String codigo = (String) model.getValueAt(selectedRow, 0);
                    Jurado jurado = SPEC.getInstance().buscarJuradoById(codigo);
                    
                    if (jurado != null) {
                        // TODO: Implementar diálogo de edición de jurado
                        JOptionPane.showMessageDialog(
                            TablaJurado.this, 
                            "Funcionalidad de edición pendiente", 
                            "Información", 
                            JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                } else {
                    JOptionPane.showMessageDialog(
                        TablaJurado.this, 
                        "Seleccione un jurado para editar", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
    }

    private void cargarJurados() {
        // Limpiar tabla
        model.setRowCount(0);
        
        // Obtener lista de jurados
        ArrayList<Jurado> jurados = obtenerJurados();
        
        // Llenar tabla
        for (Jurado jurado : jurados) {
            Object[] rowData = {
                jurado.getCodigo(),
                jurado.getNombre(),
                jurado.getApellido(),
                jurado.getExperiencia(),
                jurado.getEspecialidad()
            };
            model.addRow(rowData);
        }
    }

    private ArrayList<Jurado> obtenerJurados() {
        ArrayList<Jurado> jurados = new ArrayList<>();
        
        // Filtrar solo jurados de la lista de personas
        for (Persona persona : SPEC.getInstance().getMisPersonas()) {
            if (persona instanceof Jurado) {
                jurados.add((Jurado) persona);
            }
        }
        
        return jurados;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TablaJurado dialog = new TablaJurado();
                dialog.setVisible(true);
            }
        });
    }
}