package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import logico.Comision;
import logico.Participante;
import logico.SPEC;
import logico.TrabajoCientifico;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class RegistrarTC extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtTItuloTc;
    private JTextField txtCodigoTc;
    private JTextField txtEntradaParticipante;
    private JTextField txtDescripTc;
    private JComboBox<String> cbxComision;
    private ArrayList<Participante> participantesAux;
    private ArrayList<String> opcionesComision;

    public static void main(String[] args) {
        try {
            RegistrarTC dialog = new RegistrarTC();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public RegistrarTC() {
    	setResizable(false);
        setTitle("Registrar trabajo cient\u00EDfico");
        setBounds(100, 100, 500, 307);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.YELLOW));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

        participantesAux = new ArrayList<>();
        opcionesComision = new ArrayList<>();

        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(null);
        contentPanel.add(panelCentral, BorderLayout.CENTER);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(10, 20, 80, 25);
        panelCentral.add(lblCodigo);

        txtCodigoTc = new JTextField("TC-" + SPEC.getInstance().codTrajCientifico);
        txtCodigoTc.setEditable(false);
        txtCodigoTc.setBounds(100, 20, 120, 25);
        panelCentral.add(txtCodigoTc);

        JLabel lblTitulo = new JLabel("Título:");
        lblTitulo.setBounds(10, 60, 80, 25);
        panelCentral.add(lblTitulo);

        txtTItuloTc = new JTextField();
        txtTItuloTc.setBounds(100, 60, 350, 25);
        panelCentral.add(txtTItuloTc);

        JLabel lblDescripcion = new JLabel("Descripción:");
        lblDescripcion.setBounds(10, 100, 80, 25);
        panelCentral.add(lblDescripcion);

        txtDescripTc = new JTextField();
        txtDescripTc.setBounds(100, 100, 350, 25);
        panelCentral.add(txtDescripTc);

        JLabel lblComision = new JLabel("Comisión:");
        lblComision.setBounds(10, 140, 80, 25);
        panelCentral.add(lblComision);

        cbxComision = new JComboBox<>();
        cbxComision.setBounds(100, 140, 350, 25);
        panelCentral.add(cbxComision);

        JLabel lblParticipante = new JLabel("Participante:");
        lblParticipante.setBounds(10, 180, 80, 25);
        panelCentral.add(lblParticipante);

        txtEntradaParticipante = new JTextField();
        txtEntradaParticipante.setBounds(100, 180, 200, 25);
        panelCentral.add(txtEntradaParticipante);

        JButton btnAgregarParticipante = new JButton("Agregar");
        btnAgregarParticipante.setBounds(320, 180, 130, 25);
        btnAgregarParticipante.addActionListener(e -> agregarParticipante());
        panelCentral.add(btnAgregarParticipante);

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(e -> registrarTrabajoCientifico());
        buttonPane.add(btnRegistrar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());
        buttonPane.add(btnCancelar);

        cargarComisiones();
    }

    private void cargarComisiones() {
        opcionesComision.clear();
        opcionesComision.add("<Seleccione>");
        if (!SPEC.getInstance().getMisComisiones().isEmpty()) {
            for (Comision comision : SPEC.getInstance().getMisComisiones()) {
                opcionesComision.add(comision.getNombreComision());
            }
        } else {
            opcionesComision.add("No disponible");
        }
        cbxComision.setModel(new DefaultComboBoxModel<>(opcionesComision.toArray(new String[0])));
    }

    private void agregarParticipante() {
        String idParticipante = txtEntradaParticipante.getText().trim();
        if (idParticipante.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un ID de participante.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Participante participante = SPEC.getInstance().buscarParticipanteById(idParticipante);
        if (participante == null) {
            JOptionPane.showMessageDialog(this, "Participante no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        participantesAux.add(participante);
        JOptionPane.showMessageDialog(this, "Participante agregado con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
        txtEntradaParticipante.setText("");
    }

    private void registrarTrabajoCientifico() {
        String codigo = txtCodigoTc.getText().trim();
        String titulo = txtTItuloTc.getText().trim();
        String descripcion = txtDescripTc.getText().trim();
        int indiceComision = cbxComision.getSelectedIndex();

        if (codigo.isEmpty() || titulo.isEmpty() || descripcion.isEmpty() || indiceComision == 0) {
            JOptionPane.showMessageDialog(this, "Debe completar todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nombreComision = (String) cbxComision.getSelectedItem();
        Comision comision = SPEC.getInstance().buscarComisionByNombre(nombreComision);
        if (comision == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una comisión válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        TrabajoCientifico nuevoTrabajo = new TrabajoCientifico(codigo, titulo, descripcion, comision);
        SPEC.getInstance().insertarTrabajoCientifico(nuevoTrabajo);

        JOptionPane.showMessageDialog(this, "Trabajo Científico registrado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }
}