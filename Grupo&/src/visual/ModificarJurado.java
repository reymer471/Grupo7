package visual;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logico.Jurado;

public class ModificarJurado extends JDialog {
    
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtEspecialidad;
    private JTextField txtExperiencia;
    private Jurado jurado;

    public ModificarJurado(Jurado jurado) {
        this.jurado = jurado;
        
        setTitle("Modificar Jurado");
        setBounds(100, 100, 400, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);
        setModal(true);
        
        JLabel lblCodigo = new JLabel("Codigo:");
        lblCodigo.setBounds(30, 30, 100, 20);
        contentPane.add(lblCodigo);
        
        txtCodigo = new JTextField(jurado.getCodigo());
        txtCodigo.setEditable(false);
        txtCodigo.setBounds(150, 30, 200, 20);
        contentPane.add(txtCodigo);
        txtCodigo.setColumns(10);
        
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 70, 100, 20);
        contentPane.add(lblNombre);
        
        txtNombre = new JTextField(jurado.getNombre());
        txtNombre.setBounds(150, 70, 200, 20);
        contentPane.add(txtNombre);
        txtNombre.setColumns(10);
        
        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(30, 110, 100, 20);
        contentPane.add(lblApellido);
        
        txtApellido = new JTextField(jurado.getApellido());
        txtApellido.setBounds(150, 110, 200, 20);
        contentPane.add(txtApellido);
        txtApellido.setColumns(10);
        
        JLabel lblEspecialidad = new JLabel("Especialidad:");
        lblEspecialidad.setBounds(30, 150, 100, 20);
        contentPane.add(lblEspecialidad);
        
        txtEspecialidad = new JTextField(jurado.getEspecialidad());
        txtEspecialidad.setBounds(150, 150, 200, 20);
        contentPane.add(txtEspecialidad);
        txtEspecialidad.setColumns(10);
        
        JLabel lblExperiencia = new JLabel("Experiencia:");
        lblExperiencia.setBounds(30, 190, 100, 20);
        contentPane.add(lblExperiencia);
        
        txtExperiencia = new JTextField(jurado.getExperiencia());
        txtExperiencia.setBounds(150, 190, 200, 20);
        contentPane.add(txtExperiencia);
        txtExperiencia.setColumns(10);
        
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(validarCampos()) {
                    guardarCambios();
                }
            }
        });
        btnGuardar.setBounds(100, 230, 100, 25);
        contentPane.add(btnGuardar);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnCancelar.setBounds(220, 230, 100, 25);
        contentPane.add(btnCancelar);
    }
    
    private boolean validarCampos() {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String especialidad = txtEspecialidad.getText();
        String experiencia = txtExperiencia.getText();
        
        if(nombre.isEmpty() || apellido.isEmpty() || especialidad.isEmpty() || experiencia.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Todos los campos son obligatorios", 
                "Error de Validacion", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    private void guardarCambios() {
        jurado.setNombre(txtNombre.getText().trim());
        jurado.setApellido(txtApellido.getText().trim());
        jurado.setEspecialidad(txtEspecialidad.getText().trim());
        jurado.setExperiencia(txtExperiencia.getText().trim());
        
        JOptionPane.showMessageDialog(this, 
            "Jurado modificado exitosamente", 
            "Modificacion Exitosa", 
            JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }
}