package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
import logico.Recurso;

public class ListadoRecursos extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private static JTable table;
    private static DefaultTableModel modelo;
    private static Object[] row;
    private Recurso selected = null;
    private JButton btnEliminar;
    private JButton btnModificar;

    public ListadoRecursos() {
        setTitle("Listado de Recursos");
        setBounds(100, 100, 650, 400);
        setLocationRelativeTo(null);
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Listado de Recursos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
        String[] headers = {"Codigo", "Tipo de Recurso", "Nombre", "Cantidad Disponible"};
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
                    selected = SPEC.getInstance().buscarRecursoById(codigo);
                }
            }
        });
        scrollPane.setViewportView(table);
        
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        
        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AgregarRecurso agregarRecurso = new AgregarRecurso(null);
                agregarRecurso.setModal(true);
                agregarRecurso.setVisible(true);
                loadRecursos();
            }
        });
        buttonPane.add(btnAgregar);
        
        btnModificar = new JButton("Modificar");
        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (selected != null) {
                    AgregarRecurso modificarRecurso = new AgregarRecurso(selected);
                    modificarRecurso.setModal(true);
                    modificarRecurso.setVisible(true);
                    btnModificar.setEnabled(false);
                    btnEliminar.setEnabled(false);
                    loadRecursos();
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
                            "¿Estas¡ seguro que desea eliminar el recurso: " + selected.getNombre() + "?",
                            "Confirmar eliminacion",
                            JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        SPEC.getInstance().eliminarRecurso(selected);
                        btnEliminar.setEnabled(false);
                        btnModificar.setEnabled(false);
                        loadRecursos();
                        JOptionPane.showMessageDialog(null, "Recurso eliminado exitosamente", "Eliminacion exitosa", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        btnEliminar.setEnabled(false);
        buttonPane.add(btnEliminar);
        
        JButton btnCancelar = new JButton("Cerrar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonPane.add(btnCancelar);
        
        loadRecursos();
    }
    
    public static void loadRecursos() {
        modelo.setRowCount(0);
        row = new Object[modelo.getColumnCount()];
        
        for (Recurso recurso : SPEC.getInstance().getMisRecursos()) {
            row[0] = recurso.getId();
            row[1] = recurso.getTiporecurso();
            row[2] = recurso.getNombre();
            row[3] = recurso.getCantidadTotal();
            modelo.addRow(row);
        }
    }
}