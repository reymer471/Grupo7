package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import logico.Evento;
import logico.SPEC;

import java.awt.Color;
import javax.swing.border.CompoundBorder;
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;

public class ModificarEvento extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtNombre;
    private JTextField txtEventoCodigo;
    private JComboBox<String> cbxTipoEvento;
    private JSpinner spnFecha;
    private Evento miEvento;

    public ModificarEvento(Evento evento) {
        miEvento = evento;
        if (miEvento == null) {
            dispose();
            return;
        }

        setTitle("Modificar evento");
        setBounds(100, 100, 452, 292);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(SystemColor.menu);
        contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.YELLOW));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblCodEvento = new JLabel("Evento código:");
        lblCodEvento.setBounds(10, 26, 100, 14);
        contentPanel.add(lblCodEvento);

        txtEventoCodigo = new JTextField();
        txtEventoCodigo.setText(miEvento.getIdEvento());
        txtEventoCodigo.setEditable(false);
        txtEventoCodigo.setBounds(99, 23, 120, 20);
        contentPanel.add(txtEventoCodigo);
        txtEventoCodigo.setColumns(10);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(10, 77, 100, 14);
        contentPanel.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setText(miEvento.getNombre());
        txtNombre.setBounds(99, 74, 300, 20);
        contentPanel.add(txtNombre);
        txtNombre.setColumns(10);

        JLabel lblTipoEvento = new JLabel("Tipo de evento:");
        lblTipoEvento.setBounds(10, 120, 100, 14);
        contentPanel.add(lblTipoEvento);

        cbxTipoEvento = new JComboBox<>();
        cbxTipoEvento.setBounds(99, 117, 120, 20);
        cbxTipoEvento.addItem("Conferencia");
        cbxTipoEvento.addItem("Seminario");
        cbxTipoEvento.addItem("Taller");
        cbxTipoEvento.addItem("Congreso");
        cbxTipoEvento.setSelectedItem(miEvento.getTipoEvento());
        contentPanel.add(cbxTipoEvento);

        JLabel lblFechas = new JLabel("Fecha:");
        lblFechas.setBounds(229, 120, 100, 14);
        contentPanel.add(lblFechas);

        SpinnerDateModel dateModel = new SpinnerDateModel();
        spnFecha = new JSpinner(dateModel);
        spnFecha.setValue(miEvento.getFechaEvento());
        spnFecha.setBounds(289, 117, 120, 20);
        contentPanel.add(spnFecha);

        JPanel buttonPane = new JPanel();
        buttonPane.setBorder(new CompoundBorder());
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton cancelarButton = new JButton("Cancelar");
        cancelarButton.addActionListener(e -> dispose());
        buttonPane.add(cancelarButton);

        JButton guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(e -> modificarEvento());
        buttonPane.add(guardarButton);
    }

    private void modificarEvento() {
        try {
            String nombre = txtNombre.getText().trim();
            String tipoEvento = (String) cbxTipoEvento.getSelectedItem();
            Date fecha = (Date) spnFecha.getValue();

            // Validaciones
            if (nombre.isEmpty()) {
                mostrarMensaje("El nombre del evento es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Date hoy = new Date();
            if (fecha.before(hoy)) {
                mostrarMensaje("La fecha del evento debe ser futura.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Modificar el evento
            miEvento.setNombre(nombre);
            miEvento.setTipoEvento(tipoEvento);
            miEvento.setFechaEvento(fecha);

            // Guardar cambios
            SPEC.getInstance().guardarDatos("gestion.dat");
            
            // Confirmación
            mostrarMensaje("Evento modificado exitosamente.", "Modificación exitosa", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            
        } catch (Exception ex) {
            mostrarMensaje("Ocurrió un error inesperado. Intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarMensaje(String mensaje, String titulo, int tipo) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, tipo);
    }
}