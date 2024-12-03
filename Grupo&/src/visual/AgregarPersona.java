package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JDialog;
import javax.swing.border.EmptyBorder;

import logico.Jurado;
import logico.Participante;
import logico.Persona;

import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

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
    	setTitle("Agregar tipo de Persona");
    	setIconImage(Toolkit.getDefaultToolkit().getImage(AgregarPersona.class.getResource("/com/sun/javafx/scene/web/skin/Copy_16x16_JFX.png")));
        setBounds(150, 150, 413, 432);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setLayout(null);
        contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.YELLOW));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        
        // Etiquetas comunes
        JLabel lblCodigo = new JLabel("Codigo:");
        lblCodigo.setBounds(10, 20, 100, 20);
        contentPanel.add(lblCodigo);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(10, 60, 100, 20);
        contentPanel.add(lblNombre);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(10, 100, 100, 20);
        contentPanel.add(lblApellido);

        // Campos comunes
        txtCodigo = new JTextField();
        txtCodigo.setBounds(120, 20, 200, 20);
        contentPanel.add(txtCodigo);

        txtNombre = new JTextField();
        txtNombre.setBounds(120, 60, 200, 20);
        contentPanel.add(txtNombre);

        txtApellido = new JTextField();
        txtApellido.setBounds(120, 100, 200, 20);
        contentPanel.add(txtApellido);

        // Seleccion de tipo de persona 
        JLabel lblTipoPersona = new JLabel("Tipo de Persona:");
        lblTipoPersona.setBounds(10, 140, 100, 20);
        contentPanel.add(lblTipoPersona);

        tipoPersonaComboBox = new JComboBox<>();
        tipoPersonaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Participante", "Jurado" }));
        tipoPersonaComboBox.setBounds(120, 140, 200, 20);
        contentPanel.add(tipoPersonaComboBox);

        // Campos especificos para Participante
        JLabel lblDireccion = new JLabel("Direccion:");
        lblDireccion.setBounds(10, 180, 100, 20);
        contentPanel.add(lblDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(120, 180, 200, 20);
        contentPanel.add(txtDireccion);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(10, 220, 100, 20);
        contentPanel.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(120, 220, 200, 20);
        contentPanel.add(txtEmail);

        // Campos específicos para Jurado
        JLabel lblExperiencia = new JLabel("Experiencia:");
        lblExperiencia.setBounds(10, 260, 100, 20);
        contentPanel.add(lblExperiencia);

        txtExperiencia = new JTextField();
        txtExperiencia.setBounds(120, 260, 200, 20);
        contentPanel.add(txtExperiencia);

        JLabel lblEspecialidad = new JLabel("Especialidad:");
        lblEspecialidad.setBounds(10, 300, 100, 20);
        contentPanel.add(lblEspecialidad);

        txtEspecialidad = new JTextField();
        txtEspecialidad.setBounds(120, 300, 200, 20);
        contentPanel.add(txtEspecialidad);

        // Botones de acción 
        JPanel buttonPane = new JPanel();
        buttonPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton Agregar = new JButton("Agregar");
        Agregar.setIcon(new ImageIcon(AgregarPersona.class.getResource("/javax/swing/plaf/metal/icons/Inform.gif")));
        Agregar.setActionCommand("Agregar");
        buttonPane.add(Agregar);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.setIcon(new ImageIcon(AgregarPersona.class.getResource("/javax/swing/plaf/metal/icons/ocean/error.png")));
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);

        // Lógica para cambiar entre campos de Participante y Jurado
        tipoPersonaComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedType = (String) tipoPersonaComboBox.getSelectedItem();
                if (selectedType.equals("Participante")) {
                    txtDireccion.setEnabled(true);
                    txtEmail.setEnabled(true);
                    txtExperiencia.setEnabled(false);
                    txtEspecialidad.setEnabled(false);
                } else if (selectedType.equals("Jurado")) {
                    txtDireccion.setEnabled(false);
                    txtEmail.setEnabled(false);
                    txtExperiencia.setEnabled(true);
                    txtEspecialidad.setEnabled(true);
                }
            }
        });

        // Acciones de los botones
        Agregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String codigo = txtCodigo.getText();
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                
                
                if (codigo.isEmpty() || nombre.isEmpty() || apellido.isEmpty()) {
                    javax.swing.JOptionPane.showMessageDialog(
                        null,
                        "Por favor, complete todos los campos obligatorios.",
                        "Error",
                        javax.swing.JOptionPane.ERROR_MESSAGE
                    );
                    return; 
                }

                // Crear la persona según el tipo seleccionado
                Persona persona = null;
                if (tipoPersonaComboBox.getSelectedItem().equals("Participante")) {
                    persona = new Participante(txtCodigo.getText(), txtNombre.getText(), txtApellido.getText(),txtDireccion.getText(),txtEmail.getText());
                    ((Participante) persona).setDireccion(txtDireccion.getText());
                    ((Participante) persona).setEmail(txtEmail.getText());
                } else if (tipoPersonaComboBox.getSelectedItem().equals("Jurado")) {
                	persona = new Jurado(txtCodigo.getText(), txtNombre.getText(), txtApellido.getText(), txtExperiencia.getText(), txtEspecialidad.getText());
                    ((Jurado) persona).setExperiencia(txtExperiencia.getText());
                    ((Jurado) persona).setEspecialidad(txtEspecialidad.getText());
                    
                    if (persona != null) {
                        // Muestra un mensaje de confirmación
                        javax.swing.JOptionPane.showMessageDialog(
                            null, 
                            "Se ha agregado correctamente a " + persona.getNombre() + " " + persona.getApellido(), 
                            "Confirmación", 
                            javax.swing.JOptionPane.INFORMATION_MESSAGE
                 );}
                }
             
                persona.setCodigo(codigo);
                persona.setNombre(nombre);
                persona.setApellido(apellido);
               

                dispose();
            }
            
        });
        

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}


