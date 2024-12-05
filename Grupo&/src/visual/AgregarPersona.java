package visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import logico.Jurado;
import logico.Persona;
import logico.Participante;

import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

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
        this.model = model;  // Se pasa el modelo de la tabla como parámetro
        setTitle("Agregar tipo de persona");
        setIconImage(Toolkit.getDefaultToolkit().getImage(AgregarPersona.class.getResource("/com/sun/javafx/scene/web/skin/Copy_16x16_JFX.png")));
        setBounds(150, 150, 413, 432);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(Color.LIGHT_GRAY);
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

        // Selección de tipo de persona
        JLabel lblTipoPersona = new JLabel("Tipo de Persona:");
        lblTipoPersona.setBounds(10, 140, 100, 20);
        contentPanel.add(lblTipoPersona);

        tipoPersonaComboBox = new JComboBox<>();
        tipoPersonaComboBox.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Participante", "Jurado"}));
        tipoPersonaComboBox.setBounds(120, 140, 200, 20);
        contentPanel.add(tipoPersonaComboBox);

        // Campos específicos para Participante
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
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Persona persona = null;
                if (tipoPersonaComboBox.getSelectedItem().equals("Participante")) {
                    persona = new Participante(codigo, nombre, apellido, txtDireccion.getText(), txtEmail.getText());
                } else if (tipoPersonaComboBox.getSelectedItem().equals("Jurado")) {
                    persona = new Jurado(codigo, nombre, apellido, txtExperiencia.getText(), txtEspecialidad.getText());
                }

                if (persona != null) {
                    // Agregar la persona a la tabla
                    model.addRow(new Object[]{persona.getCodigo(), persona.getNombre(), persona.getApellido(),
                            persona instanceof Jurado ? ((Jurado) persona).getExperiencia() : "",
                            persona instanceof Jurado ? ((Jurado) persona).getEspecialidad() : ""});
                    
                    JOptionPane.showMessageDialog(null, "Se ha agregado correctamente a " + persona.getNombre() + " " + persona.getApellido(), "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                    dispose();  // Cierra el diálogo
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}


