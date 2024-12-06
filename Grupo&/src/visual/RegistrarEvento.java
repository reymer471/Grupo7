package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.SPEC;
import logico.Evento;
import logico.infoEvento;

public class RegistrarEvento extends JDialog {
    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField txtNombre;
    private JTextField txtTema;
    private JTextField txtNumeroPersonas;
    private JTextField txtDuracion;
    private JComboBox<String> cbxTipoEvento;
    private JSpinner spnFecha;

    public RegistrarEvento() {
        setTitle("Registrar Evento");
        setBounds(100, 100, 600, 400);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 30, 80, 25);
        contentPanel.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(120, 30, 400, 25);
        contentPanel.add(txtNombre);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(20, 70, 80, 25);
        contentPanel.add(lblTipo);

        cbxTipoEvento = new JComboBox<>();
        cbxTipoEvento.setModel(new DefaultComboBoxModel<>(new String[] {
            "Conferencia", "Seminario", "Taller", "Congreso"
        }));
        cbxTipoEvento.setBounds(120, 70, 200, 25);
        contentPanel.add(cbxTipoEvento);

        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setBounds(20, 110, 80, 25);
        contentPanel.add(lblFecha);

        spnFecha = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spnFecha, "dd/MM/yyyy");
        spnFecha.setEditor(dateEditor);
        spnFecha.setBounds(120, 110, 150, 25);
        contentPanel.add(spnFecha);

        JLabel lblTema = new JLabel("Tema:");
        lblTema.setBounds(20, 150, 80, 25);
        contentPanel.add(lblTema);

        txtTema = new JTextField();
        txtTema.setBounds(120, 150, 400, 25);
        contentPanel.add(txtTema);

        JLabel lblDuracion = new JLabel("Duración:");
        lblDuracion.setBounds(20, 190, 80, 25);
        contentPanel.add(lblDuracion);

        txtDuracion = new JTextField();
        txtDuracion.setBounds(120, 190, 150, 25);
        contentPanel.add(txtDuracion);

        JLabel lblCapacidad = new JLabel("Capacidad:");
        lblCapacidad.setBounds(20, 230, 80, 25);
        contentPanel.add(lblCapacidad);

        txtNumeroPersonas = new JTextField();
        txtNumeroPersonas.setBounds(120, 230, 150, 25);
        contentPanel.add(txtNumeroPersonas);

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarEvento();
            }
        });
        buttonPane.add(btnRegistrar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());
        buttonPane.add(btnCancelar);
    }

    private void registrarEvento() {
        try {
            // Validaciones
            if (txtNombre.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un nombre para el evento", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (txtTema.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un tema para el evento", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (txtDuracion.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar la duración del evento", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (txtNumeroPersonas.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar la capacidad del evento", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Date fechaSeleccionada = (Date) spnFecha.getValue();
            if (fechaSeleccionada.before(new Date())) {
                JOptionPane.showMessageDialog(null, "La fecha debe ser posterior a hoy", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Crear el objeto infoEvento con una clase concreta que extienda de infoEvento
            infoEvento info = new infoEventoImpl(
                txtTema.getText().trim(),
                txtNumeroPersonas.getText().trim(),
                txtDuracion.getText().trim()
            );

            // Crear el evento
            String idEvento = "EVT-" + SPEC.codEvento;
            Evento nuevoEvento = new Evento(
                txtNombre.getText().trim(),
                idEvento,
                fechaSeleccionada,
                cbxTipoEvento.getSelectedItem().toString(),
                info
            );

            // Registrar el evento
            SPEC.getInstance().insertarEvento(nuevoEvento);
            
            // Guardar en archivo
            SPEC.getInstance().guardarDatos("SPEC.dat");

            JOptionPane.showMessageDialog(null, 
                "Evento registrado exitosamente\nCódigo: " + idEvento, 
                "Registro exitoso", 
                JOptionPane.INFORMATION_MESSAGE);
            
           

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                "Error al registrar el evento: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}

// Implementación concreta de infoEvento
class infoEventoImpl extends infoEvento {
    private static final long serialVersionUID = 1L;

    public infoEventoImpl(String temaEvento, String numeroPersonas, String duracionEvento) {
        super(temaEvento, numeroPersonas, duracionEvento);
    }
}//que duro
