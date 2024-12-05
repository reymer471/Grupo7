package visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import logico.Jurado;
import logico.Participante;
import logico.Persona;

public class AgregarPersona extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtDireccion;
    private JTextField txtEmail;
    private JTextField txtExperiencia;
    private JTextField txtEspecialidad;
    private JComboBox<String> tipoPersonaComboBox;
    private DefaultTableModel model;

    public static void main(String[] args) {
        try {
            AgregarPersona dialog = new AgregarPersona();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AgregarPersona() {
        // Crear un modelo de tabla si no se pasa como parámetro
        model = new DefaultTableModel(new Object[]{"Código", "Nombre", "Apellido", "Experiencia", "Especialidad"}, 0);

        setTitle("Agregar Persona");
        setBounds(150, 150, 450, 450);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.YELLOW));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        // Campos comunes
        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(10, 20, 100, 20);
        contentPanel.add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(120, 20, 200, 20);
        contentPanel.add(txtCodigo);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(10, 60, 100, 20);
        contentPanel.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(120, 60, 200, 20);
        contentPanel.add(txtNombre);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(10, 100, 100, 20);
        contentPanel.add(lblApellido);

        txtApellido = new JTextField();
        txtApellido.setBounds(120, 100, 200, 20);
        contentPanel.add(txtApellido);

        // Selección de tipo de persona
        JLabel lblTipoPersona = new JLabel("Tipo de Persona:");
        lblTipoPersona.setBounds(10, 140, 100, 20);
        contentPanel.add(lblTipoPersona);

        tipoPersonaComboBox = new JComboBox<>(new String[]{"<Seleccione>", "Participante", "Jurado"});
        tipoPersonaComboBox.setBounds(120, 140, 200, 20);
        contentPanel.add(tipoPersonaComboBox);

        // Campos específicos para Participante
        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(10, 180, 100, 20);
        contentPanel.add(lblDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(120, 180, 200, 20);
        txtDireccion.setEnabled(false); // Inicialmente deshabilitado
        contentPanel.add(txtDireccion);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(10, 220, 100, 20);
        contentPanel.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(120, 220, 200, 20);
        txtEmail.setEnabled(false); // Inicialmente deshabilitado
        contentPanel.add(txtEmail);

        // Campos específicos para Jurado
        JLabel lblExperiencia = new JLabel("Experiencia:");
        lblExperiencia.setBounds(10, 260, 100, 20);
        contentPanel.add(lblExperiencia);

        txtExperiencia = new JTextField();
        txtExperiencia.setBounds(120, 260, 200, 20);
        txtExperiencia.setEnabled(false); // Inicialmente deshabilitado
        contentPanel.add(txtExperiencia);

        JLabel lblEspecialidad = new JLabel("Especialidad:");
        lblEspecialidad.setBounds(10, 300, 100, 20);
        contentPanel.add(lblEspecialidad);

        txtEspecialidad = new JTextField();
        txtEspecialidad.setBounds(120, 300, 200, 20);
        txtEspecialidad.setEnabled(false); // Inicialmente deshabilitado
        contentPanel.add(txtEspecialidad);

        // Panel de botones
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(e -> registrarPersona());
        buttonPane.add(btnAgregar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());
        buttonPane.add(btnCancelar);

        // Listener para habilitar/deshabilitar campos según el tipo de persona
        tipoPersonaComboBox.addActionListener(e -> ajustarCampos());
    }

    private void ajustarCampos() {
        String tipoSeleccionado = (String) tipoPersonaComboBox.getSelectedItem();
        boolean esParticipante = "Participante".equals(tipoSeleccionado);
        boolean esJurado = "Jurado".equals(tipoSeleccionado);

        txtDireccion.setEnabled(esParticipante);
        txtEmail.setEnabled(esParticipante);

        txtExperiencia.setEnabled(esJurado);
        txtEspecialidad.setEnabled(esJurado);
    }

    private void registrarPersona() {
        String codigo = txtCodigo.getText().trim();
        String nombre = txtNombre.getText().trim();
        String apellido = txtApellido.getText().trim();
        String tipoSeleccionado = (String) tipoPersonaComboBox.getSelectedItem();

        if (codigo.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || "<Seleccione>".equals(tipoSeleccionado)) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Persona persona = null;
        if ("Participante".equals(tipoSeleccionado)) {
            String direccion = txtDireccion.getText().trim();
            String email = txtEmail.getText().trim();
            if (direccion.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete todos los campos de Participante.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            persona = new Participante(codigo, nombre, apellido, direccion, email);
        } else if ("Jurado".equals(tipoSeleccionado)) {
            String experiencia = txtExperiencia.getText().trim();
            String especialidad = txtEspecialidad.getText().trim();
            if (experiencia.isEmpty() || especialidad.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete todos los campos de Jurado.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            persona = new Jurado(codigo, nombre, apellido, experiencia, especialidad);
        }

        if (persona != null) {
            model.addRow(new Object[]{persona.getCodigo(), persona.getNombre(), persona.getApellido()});
            JOptionPane.showMessageDialog(this, "Persona registrada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }
    }
}