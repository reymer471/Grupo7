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
import logico.Participante;
import logico.Persona;

public class TablaParticipante extends JDialog {

    private static final long serialVersionUID = 1L;
    private JTable table;
    private DefaultTableModel modelo;
    private ArrayList<Participante> participantes;

    public TablaParticipante() {
    	setResizable(false);
        setTitle("Listado de Participantes");
        setBounds(100, 100, 700, 400);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(0, 0));
        getContentPane().add(panel, BorderLayout.CENTER);
        
        JScrollPane scrollPane = new JScrollPane();
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // Definir columnas
        String[] columnNames = {"Codigo", "Nombre", "Apellido", "Email", "Direccion"};
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
                modificarParticipante();
            }
        });
        panelBotones.add(btnModificar);
        
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarParticipante();
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
        
        cargarParticipantes();
    }
    
    private void cargarParticipantes() {
        modelo.setRowCount(0); // Limpiar tabla
        
        // Obtener participantes del sistema
        participantes = new ArrayList<>();
        for (Persona persona : SPEC.getInstance().getMisPersonas()) {
            if (persona instanceof Participante) {
                participantes.add((Participante) persona);
            }
        }
        
        // Llenar tabla
        for (Participante participante : participantes) {
            Object[] fila = {
                participante.getCodigo(),
                participante.getNombre(),
                participante.getApellido(),
                participante.getEmail(),
                participante.getDireccion()
            };
            modelo.addRow(fila);
        }
    }
    
    private void modificarParticipante() {
        int filaSeleccionada = table.getSelectedRow();
        if (filaSeleccionada != -1) {
            Participante participanteSeleccionado = participantes.get(filaSeleccionada);
            
            // Abrir diálogo de modificación
            ModificarParticipante modificar = new ModificarParticipante(participanteSeleccionado);
            modificar.setModal(true);
            modificar.setVisible(true);
            
            // Recargar datos
            cargarParticipantes();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Seleccione un participante para modificar", 
                "Advertencia", 
                javax.swing.JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void eliminarParticipante() {
        int filaSeleccionada = table.getSelectedRow();
        if (filaSeleccionada != -1) {
            Participante participanteSeleccionado = participantes.get(filaSeleccionada);
            
            int confirmacion = javax.swing.JOptionPane.showConfirmDialog(
                this, 
                "�Estas seguro que desea eliminar este participante?", 
                "Confirmar Eliminacion", 
                javax.swing.JOptionPane.YES_NO_OPTION
            );
            
            if (confirmacion == javax.swing.JOptionPane.YES_OPTION) {
                SPEC.getInstance().eliminarPersona(participanteSeleccionado);
                cargarParticipantes();
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Seleccione un participante para eliminar", 
                "Advertencia", 
                javax.swing.JOptionPane.WARNING_MESSAGE);
        }
    }
}