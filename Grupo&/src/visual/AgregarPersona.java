package visual;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AgregarPersona extends JDialog {

    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtDireccion;
    private JTextField txtEmail;
    private JTextField txtExperiencia;
    private JTextField txtEspecialidad;
    private JComboBox<String> tipoPersonaComboBox;

    public AgregarPersona() {
        initializeDialog();
        initializeComponents();
    }

    private void initializeDialog() {
        setTitle("Agregar Persona");
        setBounds(150, 150, 450, 500);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new BorderLayout());
    }

    private void initializeComponents() {
        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.LIGHT_GRAY));
        contentPanel.setLayout(null);
        getContentPane().add(contentPanel, BorderLayout.CENTER);

       
        addFormComponents(contentPanel);

        
        addButtonPanel();

      
        updateFieldState();
    }

    private void addFormComponents(JPanel contentPanel) {
        // Código
        addLabelAndTextField(contentPanel, "Código:", txtCodigo = new JTextField(), 30, 30);
        
        // Nombre
        addLabelAndTextField(contentPanel, "Nombre:", txtNombre = new JTextField(), 30, 70);
        
        // Apellido
        addLabelAndTextField(contentPanel, "Apellido:", txtApellido = new JTextField(), 30, 110);
        
        // Tipo de Persona
        JLabel lblTipoPersona = new JLabel("Tipo de Persona:");
        lblTipoPersona.setBounds(30, 150, 100, 25);
        contentPanel.add(lblTipoPersona);

        tipoPersonaComboBox = new JComboBox<>(new String[]{"<Seleccione>", "Participante", "Jurado"});
        tipoPersonaComboBox.setBounds(150, 150, 250, 25);
        tipoPersonaComboBox.addActionListener(e -> updateFieldState());
        contentPanel.add(tipoPersonaComboBox);
        
        // Dirección
        addLabelAndTextField(contentPanel, "Dirección:", txtDireccion = new JTextField(), 30, 190);
        
        // Email
        addLabelAndTextField(contentPanel, "Email:", txtEmail = new JTextField(), 30, 230);
        
        // Experiencia
        addLabelAndTextField(contentPanel, "Experiencia:", txtExperiencia = new JTextField(), 30, 270);
        
        // Especialidad
        addLabelAndTextField(contentPanel, "Especialidad:", txtEspecialidad = new JTextField(), 30, 310);
    }

    private void addLabelAndTextField(JPanel panel, String labelText, JTextField textField, int x, int y) {
        JLabel label = new JLabel(labelText);
        label.setBounds(x, y, 100, 25);
        panel.add(label);

        textField.setBounds(x + 120, y, 250, 25);
        panel.add(textField);
    }

    private void addButtonPanel() {
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(e -> agregarPersona());
        buttonPane.add(btnAgregar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());
        buttonPane.add(btnCancelar);
    }

    private void updateFieldState() {
        String selectedType = (String) tipoPersonaComboBox.getSelectedItem();

        // Desactivar todos los campos adicionales
        txtDireccion.setEnabled(false);
        txtEmail.setEnabled(false);
        txtExperiencia.setEnabled(false);
        txtEspecialidad.setEnabled(false);

        // Activar según el tipo de persona
        if ("Participante".equals(selectedType)) {
            txtDireccion.setEnabled(true);
            txtEmail.setEnabled(true);
        } else if ("Jurado".equals(selectedType)) {
            txtExperiencia.setEnabled(true);
            txtEspecialidad.setEnabled(true);
        }
    }

    private void agregarPersona() {
        String codigo = txtCodigo.getText().trim();
        String nombre = txtNombre.getText().trim();
        String apellido = txtApellido.getText().trim();

        if (codigo.isEmpty() || nombre.isEmpty() || apellido.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe completar los campos obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String tipoPersona = (String) tipoPersonaComboBox.getSelectedItem();

        if ("<Seleccione>".equals(tipoPersona)) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de persona", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Simulación de agregar la persona
        JOptionPane.showMessageDialog(this, "Persona agregada exitosamente: " + tipoPersona, "Confirmación", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                AgregarPersona dialog = new AgregarPersona();
                dialog.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}