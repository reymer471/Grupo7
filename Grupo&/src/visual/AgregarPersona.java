package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logico.SPEC;
import logico.Participante;
import logico.Jurado;
import logico.Persona;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class AgregarPersona extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtDireccionEmail;
    private JTextField txtEspecificoUno;
    private JComboBox<String> cbTipoPersona;
    private JLabel lblEspecificoUno;
    private JLabel lblEspecificoDos;

    public AgregarPersona() {
    	setResizable(false);
        setTitle("Agregar persona");
        setBounds(100, 100, 426, 341);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.YELLOW));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        setLocationRelativeTo(null);
        
        JLabel lblCodigo = new JLabel("Codigo:");
        lblCodigo.setBounds(30, 30, 100, 20);
        contentPanel.add(lblCodigo);
        
        txtCodigo = new JTextField();
        txtCodigo.setBounds(126, 30, 250, 20);
        contentPanel.add(txtCodigo);
        txtCodigo.setColumns(10);
        
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 70, 100, 20);
        contentPanel.add(lblNombre);
        
        txtNombre = new JTextField();
        txtNombre.setColumns(10);
        txtNombre.setBounds(126, 70, 250, 20);
        contentPanel.add(txtNombre);
        
        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(30, 110, 100, 20);
        contentPanel.add(lblApellido);
        
        txtApellido = new JTextField();
        txtApellido.setColumns(10);
        txtApellido.setBounds(126, 110, 250, 20);
        contentPanel.add(txtApellido);
        
        JLabel lblTipoPersona = new JLabel("Tipo Persona:");
        lblTipoPersona.setBounds(30, 150, 100, 20);
        contentPanel.add(lblTipoPersona);
        
        cbTipoPersona = new JComboBox<>();
        cbTipoPersona.setBounds(126, 150, 250, 20);
        cbTipoPersona.addItem("Participante");
        cbTipoPersona.addItem("Jurado");
        contentPanel.add(cbTipoPersona);
        
        lblEspecificoUno = new JLabel("Direccion:");
        lblEspecificoUno.setBounds(30, 190, 100, 20);
        contentPanel.add(lblEspecificoUno);
        
        txtDireccionEmail = new JTextField();
        txtDireccionEmail.setColumns(10);
        txtDireccionEmail.setBounds(126, 190, 250, 20);
        contentPanel.add(txtDireccionEmail);
        
        lblEspecificoDos = new JLabel("Email:");
        lblEspecificoDos.setBounds(30, 230, 100, 20);
        contentPanel.add(lblEspecificoDos);
        
        txtEspecificoUno = new JTextField();
        txtEspecificoUno.setColumns(10);
        txtEspecificoUno.setBounds(126, 230, 250, 20);
        contentPanel.add(txtEspecificoUno);
        
        cbTipoPersona.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarCampos();
            }
        });
        
        // Botones
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        
        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarPersona();
            }
        });
        buttonPane.add(btnRegistrar);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonPane.add(btnCancelar);
        
        actualizarCampos();
    }
    
    private void actualizarCampos() {
        String tipoSeleccionado = (String) cbTipoPersona.getSelectedItem();
        
        if ("Participante".equals(tipoSeleccionado)) {
            lblEspecificoUno.setText("Direccion:");
            lblEspecificoDos.setText("Email:");
            txtEspecificoUno.setVisible(true);
            lblEspecificoUno.setVisible(true);
            lblEspecificoDos.setVisible(true);
        } else {
            lblEspecificoUno.setText("Experiencia:");
            lblEspecificoDos.setText("Especialidad:");
            txtEspecificoUno.setVisible(true);
            lblEspecificoUno.setVisible(true);
            lblEspecificoDos.setVisible(true);
        }
    }
    
    private void registrarPersona() {
        String codigo = txtCodigo.getText();
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String tipoPersona = (String) cbTipoPersona.getSelectedItem();
        
        // Validaciones básicas
        if (codigo.isEmpty() || nombre.isEmpty() || apellido.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Persona nuevaPersona = null;
        
        if ("Participante".equals(tipoPersona)) {
            String direccion = txtDireccionEmail.getText();
            String email = txtEspecificoUno.getText();
            
            nuevaPersona = new Participante(codigo, nombre, apellido, direccion, email);
        } else {
            String experiencia = txtDireccionEmail.getText();
            String especialidad = txtEspecificoUno.getText();
            
            nuevaPersona = new Jurado(codigo, nombre, apellido, experiencia, especialidad);
        }
        
        // Insertar en el sistema
        SPEC.getInstance().insertarPersona(nuevaPersona);
        
        JOptionPane.showMessageDialog(this, tipoPersona + " registrado exitosamente", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
        
        // Limpiar campos
        limpiarCampos();
    }
    
    private void limpiarCampos() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtDireccionEmail.setText("");
        txtEspecificoUno.setText("");
    }
}