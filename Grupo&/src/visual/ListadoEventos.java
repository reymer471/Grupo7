package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.SPEC;
import logico.Evento;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListadoEventos extends JDialog {
    
    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel;
    private JTable table;
    private DefaultTableModel modelo;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private JButton btnModificar;
    private JButton btnEliminar;
    private Evento selectedEvento;
    
    public ListadoEventos() {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Listado de Eventos");
        setBounds(100, 100, 800, 500);
        setModal(true);
        setResizable(false);
        setLocationRelativeTo(null);
        
        // Panel principal
        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPanel.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPanel);
        
        // Panel para la tabla
        JPanel panelTabla = new JPanel();
        panelTabla.setBorder(BorderFactory.createTitledBorder("Eventos Registrados"));
        panelTabla.setLayout(new BorderLayout(0, 0));
        contentPanel.add(panelTabla, BorderLayout.CENTER);
        
        // Crear tabla
        String[] headers = {"Codigo", "Nombre", "Tipo", "Fecha", "Tema", "Duracion", "Capacidad"};
        modelo = new DefaultTableModel(headers, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        table = new JTable(modelo);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = table.getSelectedRow();
                if(index >= 0) {
                    btnModificar.setEnabled(true);
                    btnEliminar.setEnabled(true);
                    String codigo = table.getValueAt(index, 0).toString();
                    selectedEvento = SPEC.getInstance().buscarEventoByCodigo(codigo);
                } else {
                    btnModificar.setEnabled(false);
                    btnEliminar.setEnabled(false);
                }
            }
        });
        
        JScrollPane scrollPane = new JScrollPane(table);
        panelTabla.add(scrollPane, BorderLayout.CENTER);
        
        // Panel de botones
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        contentPanel.add(buttonPane, BorderLayout.SOUTH);
        
        btnModificar = new JButton("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(selectedEvento != null) {
                    ModificarEvento modEvento = new ModificarEvento(selectedEvento);
                    modEvento.setModal(true);
                    modEvento.setVisible(true);
                    loadEventos();
                    btnModificar.setEnabled(false);
                    btnEliminar.setEnabled(false);
                }
            }
        });
        buttonPane.add(btnModificar);
        
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(selectedEvento != null) {
                    int option = JOptionPane.showConfirmDialog(null,
                            "¿Estas seguro que desea eliminar el evento: " + selectedEvento.getNombre() + "?",
                            "Confirmar eliminacion",
                            JOptionPane.YES_NO_OPTION);
                    if(option == JOptionPane.YES_OPTION) {
                        SPEC.getInstance().eliminarEvento(selectedEvento);
                        loadEventos();
                        btnModificar.setEnabled(false);
                        btnEliminar.setEnabled(false);
                        JOptionPane.showMessageDialog(null, "Evento eliminado exitosamente", 
                            "Eliminacion exitosa", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        buttonPane.add(btnEliminar);
        
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());
        buttonPane.add(btnCerrar);
        
        // Cargar datos
        loadEventos();
    }
    
    private void loadEventos() {
        modelo.setRowCount(0);
        selectedEvento = null;
        
        try {
            for (Evento evento : SPEC.getInstance().getMisEventos()) {
                if (evento != null) {
                    Object[] row = {
                        evento.getIdEvento(),
                        evento.getNombre(),
                        evento.getTipoEvento(),
                        sdf.format(evento.getFechaEvento()),
                        evento.getInfoEvento().getTemaEvento(),
                        evento.getInfoEvento().getDuracionEvento(),
                        evento.getInfoEvento().getNumeroPersonas()
                    };
                    modelo.addRow(row);
                }
            }

            if(modelo.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, 
                    "No hay eventos registrados en el sistema", 
                    "Informacion", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Error al cargar los eventos: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}