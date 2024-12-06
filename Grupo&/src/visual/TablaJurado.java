package visual;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import logico.SPEC;
import logico.Jurado;
import logico.Persona;

public class TablaJurado extends JDialog {

    private static final long serialVersionUID = 1L;
    private JTable table;
    private DefaultTableModel modelo;
    private ArrayList<Jurado> jurados;

    public TablaJurado() {
    	setResizable(false);
        setTitle("Listado de Jurados");
        setBounds(100, 100, 700, 400);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(0, 0));
        getContentPane().add(panel, BorderLayout.CENTER);
        
        JScrollPane scrollPane = new JScrollPane();
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // Definir columnas
        String[] columnNames = {"Codigo", "Nombre", "Apellido", "Especialidad", "Experiencia"};
        modelo = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer la tabla no editable
            }
        };
        
        table = new JTable(modelo);
        scrollPane.setViewportView(table);
        
        // Panel de botones
        JPanel panelBotones = new JPanel();
        panel.add(panelBotones, BorderLayout.SOUTH);
        
        JButton btnModificar = new JButton("Modificar");
        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarJurado();
            }
        });
        panelBotones.add(btnModificar);
        
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarJurado();
            }
        });
        panelBotones.add(btnEliminar);
        
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panelBotones.add(btnCerrar);
        
        cargarJurados();
    }
    
    private void cargarJurados() {
        modelo.setRowCount(0); // Limpiar tabla
        
        // Obtener jurados del sistema
        jurados = new ArrayList<>();
        for (Persona persona : SPEC.getInstance().getMisPersonas()) {
            if (persona instanceof Jurado) {
                jurados.add((Jurado) persona);
            }
        }
        
        // Llenar tabla
        for (Jurado jurado : jurados) {
            Object[] fila = {
                jurado.getCodigo(),
                jurado.getNombre(),
                jurado.getApellido(),
                jurado.getEspecialidad(),
                jurado.getExperiencia()
            };
            modelo.addRow(fila);
        }
    }
    
    private void modificarJurado() {
        int filaSeleccionada = table.getSelectedRow();
        if (filaSeleccionada != -1) {
            Jurado juradoSeleccionado = jurados.get(filaSeleccionada);
            
            // Abrir diálogo de modificación
            ModificarJurado modificar = new ModificarJurado(juradoSeleccionado);
            modificar.setModal(true);
            modificar.setVisible(true);
            
            // Recargar datos
            cargarJurados();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Seleccione un jurado para modificar", 
                "Advertencia", 
                javax.swing.JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void eliminarJurado() {
        int filaSeleccionada = table.getSelectedRow();
        if (filaSeleccionada != -1) {
            Jurado juradoSeleccionado = jurados.get(filaSeleccionada);
            
            int confirmacion = javax.swing.JOptionPane.showConfirmDialog(
                this, 
                "�Estas seguro que desea eliminar este jurado?", 
                "Confirmar Eliminacion", 
                javax.swing.JOptionPane.YES_NO_OPTION
            );
            
            if (confirmacion == javax.swing.JOptionPane.YES_OPTION) {
                SPEC.getInstance().eliminarPersona(juradoSeleccionado);
                cargarJurados();
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Seleccione un jurado para eliminar", 
                "Advertencia", 
                javax.swing.JOptionPane.WARNING_MESSAGE);
        }
    }
}