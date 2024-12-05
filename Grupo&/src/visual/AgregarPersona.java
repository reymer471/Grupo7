package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

import logico.SPEC;
import logico.Jurado;
import logico.Participante;
import logico.Persona;

import java.awt.Color;
import java.awt.Toolkit;

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

    public AgregarPersona() {
        initComponents();
        setupListeners();
    }

    private void initComponents() {
        setTitle("Agregar Persona");
        setIconImage(Toolkit.getDefaultToolkit().getImage(AgregarPersona.class.getResource("/iconos/persona_icon.png")));
        setBounds(150, 150, 450, 500);
        getContentPane().setLayout(new BorderLayout());
        
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.LIGHT_GRAY));
        contentPanel.setLayout(null);
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        setLocationRelativeTo(null);

        // Crear componentes
        createCommonComponents();
        createPersonTypeComponents();
        createActionButtons();
    }

    private void createCommonComponents() {
        // Código
        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(30, 30, 100, 25);
        contentPanel.add(lblCodigo);
        
        txtCodigo = new JTextField();
        txtCodigo.setBounds(150, 30, 250, 25);
        contentPanel.add(txtCodigo);

        // Nombre
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 70, 100, 25);
        contentPanel.add(lblNombre);
        
        txtNombre = new JTextField();
        txtNombre.setBounds(150, 70, 250, 25);
        contentPanel.add(txtNombre);

        // Apellido
        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(30, 110, 100, 25);
        contentPanel.add(lblApellido);
        
        txtApellido = new JTextField();
        txtApellido.setBounds(150, 110, 250, 25);
        contentPanel.add(txtApellido);

        // Tipo de Persona
        JLabel lblTipoPersona = new JLabel("Tipo de Persona:");
        lblTipoPersona.setBounds(30, 150, 100, 25);
        contentPanel.add(lblTipoPersona);

        tipoPersonaComboBox = new JComboBox<>(new String[]{"<Seleccione>", "Participante", "Jurado"});
        tipoPersonaComboBox.setBounds(150, 150, 250, 25);
        contentPanel.add(tipoPersonaComboBox);
    }

    private void createPersonTypeComponents() {
        // Componentes para Participante
        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(30, 190, 100, 25);
        contentPanel.add(lblDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(150, 190, 250, 25);
        contentPanel.add(txtDireccion);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(30, 230, 100, 25);
        contentPanel.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(150, 230, 250, 25);
        contentPanel.add(txtEmail);

        // Componentes para Jurado
        JLabel lblExperiencia = new JLabel("Experiencia:");
        lblExperiencia.setBounds(30, 190, 100, 25);
        contentPanel.add(lblExperiencia);

        txtExperiencia = new JTextField();
        txtExperiencia.setBounds(150, 190, 250, 25);
        contentPanel.add(txtExperiencia);

        JLabel lblEspecialidad = new JLabel("Especialidad:");
        lblEspecialidad.setBounds(30, 230, 100, 25);
        contentPanel.add(lblEspecialidad);

        txtEspecialidad = new JTextField();
        txtEspecialidad.setBounds(150, 230, 250, 25);
        contentPanel.add(txtEspecialidad);
    }

    private void createActionButtons() {
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setIcon(new ImageIcon(AgregarPersona.class.getResource("/iconos/agregar_icon.png")));
        buttonPane.add(btnAgregar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setIcon(new ImageIcon(AgregarPersona.class.getResource("/iconos/cancelar_icon.png")));
        buttonPane.add(btnCancelar);
    }

    private void setupListeners() {
        // Listener para cambiar visibilidad de campos según tipo de persona
        tipoPersonaComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateFieldVisibility();
            }
        });

        // Listener para agregar persona
        getRootPane().getDefaultButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarPersona();
            }
        });

        // Listener para cancelar
        getRootPane().getDefaultButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void updateFieldVisibility() {
        String selectedType = (String) tipoPersonaComboBox.getSelectedItem();
        
        // Ocultar todos los campos
        txtDireccion.setVisible(false);
        txtEmail.setVisible(false);
        txtExperiencia.setVisible(false);
        txtEspecialidad.setVisible(false);

        // Mostrar campos según tipo seleccionado
        if ("Participante".equals(selectedType)) {
            txtDireccion.setVisible(true);
            txtEmail.setVisible(true);
        } else if ("Jurado".equals(selectedType)) {
            txtExperiencia.setVisible(true);
            txtEspecialidad.setVisible(true);
        }
    }

    private void agregarPersona() {
        // Validar campos obligatorios
        if (!validarCamposObligatorios()) {
            return;
        }

        Persona persona = null;
        String tipoPersona = (String) tipoPersonaComboBox.getSelectedItem();

        try {
            if ("Participante".equals(tipoPersona)) {
                persona = crearParticipante();
            } else if ("Jurado".equals(tipoPersona)) {
                persona = crearJurado();
            } else {
                mostrarError("Debe seleccionar un tipo de persona");
                return;
            }

            // Registrar persona en el sistema
            SPEC.getInstance().insertarPersona(persona);
            
            mostrarMensaje("Persona agregada exitosamente");
            dispose();

        } catch (Exception ex) {
            mostrarError("Error al agregar persona: " + ex.getMessage());
        }
    }

    private boolean validarCamposObligatorios() {
        if (txtCodigo.getText().trim().isEmpty() || 
            txtNombre.getText().trim().isEmpty() || 
            txtApellido.getText().trim().isEmpty()) {
            mostrarError("Debe completar los campos obligatorios");
            return false;
        }
        return true;
    }

    private Participante crearParticipante() {
        Participante participante = new Participante(
            txtCodigo.getText(), 
            txtNombre.getText(), 
            txtApellido.getText(),
            txtDireccion.getText(), 
            txtEmail.getText()
        );
        return participante;
    }

    private Jurado crearJurado() {
        Jurado jurado = new Jurado(
            txtCodigo.getText(), 
            txtNombre.getText(), 
            txtApellido.getText(),
            txtExperiencia.getText(), 
            txtEspecialidad.getText()
        );
        return jurado;
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(
            this, 
            mensaje, 
            "Error", 
            JOptionPane.ERROR_MESSAGE
        );
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(
            this, 
            mensaje, 
            "Confirmación", 
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}