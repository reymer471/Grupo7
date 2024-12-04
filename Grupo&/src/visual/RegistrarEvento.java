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
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import java.awt.Toolkit;

public class RegistrarEvento extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtNombre;
    private JTextField txtEventoCodigo;
    private JComboBox<String> cbxTipoEvento;
    private JSpinner spnFecha;
    private JSpinner spnCapacidad;
    private JSpinner spnDuracion;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            RegistrarEvento dialog = new RegistrarEvento();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public RegistrarEvento() {
    	setForeground(Color.GRAY);
    	setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrarEvento.class.getResource("/javax/swing/plaf/metal/icons/sortDown.png")));
        setTitle("Registrar Evento");
        setBounds(100, 100, 452, 309);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(Color.LIGHT_GRAY);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblCodEvento = new JLabel("Evento código:");
        lblCodEvento.setBounds(10, 26, 100, 14);
        contentPanel.add(lblCodEvento);

        txtEventoCodigo = new JTextField();
        txtEventoCodigo.setBounds(110, 23, 120, 20);
        contentPanel.add(txtEventoCodigo);
        txtEventoCodigo.setColumns(10);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(10, 77, 100, 14);
        contentPanel.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(110, 74, 300, 20);
        contentPanel.add(txtNombre);
        txtNombre.setColumns(10);

        JLabel lblTipoEvento = new JLabel("Tipo de evento:");
        lblTipoEvento.setBounds(10, 120, 100, 14);
        contentPanel.add(lblTipoEvento);

        cbxTipoEvento = new JComboBox<>();
        cbxTipoEvento.setBounds(110, 117, 120, 20);
        cbxTipoEvento.addItem("Conferencia");
        cbxTipoEvento.addItem("Seminario");
        cbxTipoEvento.addItem("Taller");
        cbxTipoEvento.addItem("Congreso");
        contentPanel.add(cbxTipoEvento);

        JLabel lblFechas = new JLabel("Fecha:");
        lblFechas.setBounds(244, 120, 100, 14);
        contentPanel.add(lblFechas);

        spnFecha = new JSpinner(new SpinnerDateModel());
        spnFecha.setBounds(300, 117, 120, 20);
        contentPanel.add(spnFecha);

        JLabel lblCapacidad = new JLabel("Capacidad:");
        lblCapacidad.setBounds(10, 163, 100, 14);
        contentPanel.add(lblCapacidad);

        spnCapacidad = new JSpinner();
        spnCapacidad.setBounds(110, 160, 120, 20);
        contentPanel.add(spnCapacidad);

        JLabel lblDuracion = new JLabel("Duración (hrs):");
        lblDuracion.setBounds(244, 163, 100, 14);
        contentPanel.add(lblDuracion);

        spnDuracion = new JSpinner();
        spnDuracion.setBounds(330, 160, 90, 20);
        contentPanel.add(spnDuracion);

        // Botones de acción
        JPanel buttonPane = new JPanel();
        buttonPane.setBorder(new CompoundBorder());
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton cancelarButton = new JButton("Cancelar");
        cancelarButton.addActionListener(e -> dispose());
        buttonPane.add(cancelarButton);

        JButton registrarButton = new JButton("Registrar");
        registrarButton.addActionListener(e -> registrarEvento());
        buttonPane.add(registrarButton);
    }

    private void registrarEvento() {
        try {
            // Obtener los valores
            String codigo = txtEventoCodigo.getText().trim();
            String nombre = txtNombre.getText().trim();
            String tipoEvento = (String) cbxTipoEvento.getSelectedItem();
            Date fecha = (Date) spnFecha.getValue();
            int capacidad = (Integer) spnCapacidad.getValue();
            int duracion = (Integer) spnDuracion.getValue();

            // Validaciones
            if (codigo.isEmpty()) {
                mostrarMensaje("El código del evento es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (nombre.isEmpty()) {
                mostrarMensaje("El nombre del evento es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (capacidad <= 0) {
                mostrarMensaje("La capacidad debe ser un número mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (duracion <= 0) {
                mostrarMensaje("La duración debe ser un número mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Date hoy = new Date();
            if (fecha.before(hoy)) {
                mostrarMensaje("La fecha del evento debe ser futura.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (tipoEvento == null || tipoEvento.isEmpty()) {
                mostrarMensaje("Debe seleccionar un tipo de evento.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Crear el evento
            Evento evento = new Evento(nombre, codigo, fecha, tipoEvento, null);

            // Confirmación
            mostrarMensaje("Evento registrado exitosamente.", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);

            // Cerrar la ventana
            dispose();
        } catch (Exception ex) {
            mostrarMensaje("Ocurrió un error inesperado. Intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarMensaje(String mensaje, String titulo, int tipo) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, tipo);
    }
}
