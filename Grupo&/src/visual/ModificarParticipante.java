package visual;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logico.Participante;

public class ModificarParticipante extends JDialog {

    private JPanel contentPane;
    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtEmail;
    private JTextField txtDireccion;
    private Participante participante;

    public ModificarParticipante(Participante participante) {
        this.participante = participante;
        
        setTitle("Modificar Participante");
        setBounds(100, 100, 400, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);
        
        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(30, 30, 100, 20);
        contentPane.add(lblCodigo);
        
        txtCodigo = new JTextField(participante.getCodigo());
        txtCodigo.setEditable(false);
        txtCodigo.setBounds(150, 30, 200, 20);
        contentPane.add(txtCodigo);
        
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 70, 100, 20);
        contentPane.add(lblNombre);
        
        txtNombre = new JTextField(participante.getNombre());
        txtNombre.setBounds(150, 70, 200, 20);
        contentPane.add(txtNombre);
        
        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(30, 110, 100, 20);
        contentPane.add(lblApellido);
        
        txtApellido = new JTextField(participante.getApellido());
        txtApellido.setBounds(150, 110, 200, 20);
        contentPane.add(txtApellido);
        
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(30, 150, 100, 20);
        contentPane.add(lblEmail);
        
        txtEmail = new JTextField(participante.getEmail());
        txtEmail.setBounds(150, 150, 200, 20);
        contentPane.add(txtEmail);
        
        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(30, 190, 100, 20);
        contentPane.add(lblDireccion);
        
        txtDireccion = new JTextField(participante.getDireccion());
        txtDireccion.setBounds(150, 190, 200, 20);
        contentPane.add(txtDireccion);
        
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarCambios();
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
    
    private void guardarCambios() {
        participante.setNombre(txtNombre.getText());
        participante.setApellido(txtApellido.getText());
        participante.setEmail(txtEmail.getText());
        participante.setDireccion(txtDireccion.getText());
        
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Participante modificado exitosamente", 
            "Modificación Exitosa", 
            javax.swing.JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }
}