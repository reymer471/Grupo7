package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.SPEC;
import logico.Evento;

public class RegistrarEvento extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private static JTable table;
    private static DefaultTableModel modelo;
    private static Object[] row;
    private Evento selected = null;
    private JButton btnEliminar;
    private JButton btnModificar;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public RegistrarEvento() {
        setTitle("Listado de Eventos");
        setBounds(100, 100, 800, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Listado de Eventos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        contentPanel.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        modelo = new DefaultTableModel() {
            private static final long serialVersionUID = 1L;
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] headers = {"Código", "Nombre", "Tipo de Evento", "Fecha"};
        modelo.setColumnIdentifiers(headers);
        
        table = new JTable(modelo);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = table.getSelectedRow();
                if (index >= 0) {
                    btnModificar.setEnabled(true);
                    btnEliminar.setEnabled(true);
                    String codigo = table.getValueAt(index, 0).toString();
                    selected = SPEC.getInstance().buscarEventoByCodigo(codigo);
                }
            }
        });
        scrollPane.setViewportView(table);
        
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        
        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegistrarTC registrarEvento = new RegistrarTC();
                registrarEvento.setModal(true);
                registrarEvento.setVisible(true);
                loadEventos();
                btnModificar.setEnabled(false);
                btnEliminar.setEnabled(false);
            }
        });
        buttonPane.add(btnRegistrar);
        
        btnModificar = new JButton("Modificar");
        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (selected != null) {
                    // Aquí implementarás la modificación cuando tengas ModificarEvento
                    // ModificarEvento modificarEvento = new ModificarEvento(selected);
                    // modificarEvento.setModal(true);
                    // modificarEvento.setVisible(true);
                    btnModificar.setEnabled(false);
                    btnEliminar.setEnabled(false);
                    loadEventos();
                }
            }
        });
        btnModificar.setEnabled(false);
        buttonPane.add(btnModificar);
        
        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (selected != null) {
                    int option = JOptionPane.showConfirmDialog(null,
                            "¿Está seguro que desea eliminar el evento: " + selected.getNombre() + "?",
                            "Confirmar eliminación",
                            JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        SPEC.getInstance().eliminarEvento(selected);
                        loadEventos();
                        btnEliminar.setEnabled(false);
                        btnModificar.setEnabled(false);
                        JOptionPane.showMessageDialog(null, "Evento eliminado exitosamente", 
                            "Eliminación exitosa", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        btnEliminar.setEnabled(false);
        buttonPane.add(btnEliminar);
        
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonPane.add(btnCerrar);
        
        loadEventos();
    }
    
    private static void loadEventos() {
        modelo.setRowCount(0);
        row = new Object[modelo.getColumnCount()];
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        for (Evento evento : SPEC.getInstance().getMisEventos()) {
            row[0] = evento.getIdEvento();
            row[1] = evento.getNombre();
            row[2] = evento.getTipoEvento();
            row[3] = sdf.format(evento.getFechaEvento());
            modelo.addRow(row);
        }
    }
}