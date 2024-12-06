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
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;

import logico.SPEC;
import logico.Recurso;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarRecurso extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JComboBox<String> cbxTipo;
    private JSpinner spnCantidad;
    private Recurso miRecurso = null;

    public AgregarRecurso(Recurso recurso) {
        miRecurso = recurso;
        if(miRecurso == null) {
            setTitle("Registrar Recurso");
        } else {
            setTitle("Modificar Recurso");
        }
        
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        {
            JLabel lblNewLabel = new JLabel("Código:");
            lblNewLabel.setBounds(10, 25, 80, 14);
            contentPanel.add(lblNewLabel);
        }
        {
            txtCodigo = new JTextField();
            txtCodigo.setBounds(100, 22, 120, 20);
            contentPanel.add(txtCodigo);
            txtCodigo.setColumns(10);
            if(miRecurso != null) {
                txtCodigo.setText(miRecurso.getId());
                txtCodigo.setEnabled(false);
            } else {
                txtCodigo.setText("R-" + SPEC.codRecurso);
                txtCodigo.setEnabled(false);
            }
        }
        {
            JLabel lblNewLabel_1 = new JLabel("Nombre:");
            lblNewLabel_1.setBounds(10, 65, 80, 14);
            contentPanel.add(lblNewLabel_1);
        }
        {
            txtNombre = new JTextField();
            txtNombre.setBounds(100, 62, 250, 20);
            contentPanel.add(txtNombre);
            txtNombre.setColumns(10);
            if(miRecurso != null) {
                txtNombre.setText(miRecurso.getNombre());
            }
        }
        {
            JLabel lblNewLabel_2 = new JLabel("Tipo:");
            lblNewLabel_2.setBounds(10, 105, 80, 14);
            contentPanel.add(lblNewLabel_2);
        }
        {
            cbxTipo = new JComboBox<String>();
            cbxTipo.addItem("Seleccione");
            cbxTipo.addItem("Mobiliario");
            cbxTipo.addItem("Tecnológico");
            cbxTipo.addItem("Material de Oficina");
            cbxTipo.setBounds(100, 102, 250, 20);
            contentPanel.add(cbxTipo);
            if(miRecurso != null) {
                cbxTipo.setSelectedItem(miRecurso.getTiporecurso());
            }
        }
        {
            JLabel lblNewLabel_3 = new JLabel("Cantidad:");
            lblNewLabel_3.setBounds(10, 145, 80, 14);
            contentPanel.add(lblNewLabel_3);
        }
        {
            spnCantidad = new JSpinner();
            spnCantidad.setModel(new SpinnerNumberModel(1, 1, 1000, 1));
            spnCantidad.setBounds(100, 142, 80, 20);
            contentPanel.add(spnCantidad);
            if(miRecurso != null) {
                spnCantidad.setValue(miRecurso.getCantidadTotal());
            }
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("Registrar");
                if(miRecurso != null) {
                    okButton.setText("Modificar");
                }
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(validarCampos()) {
                            if(miRecurso == null) {
                                Recurso aux = new Recurso(txtCodigo.getText(), cbxTipo.getSelectedItem().toString(),
                                        txtNombre.getText(), Integer.valueOf(spnCantidad.getValue().toString()));
                                SPEC.getInstance().insertarRecurso(aux);
                                JOptionPane.showMessageDialog(null, "Registro exitoso", "Información", 
                                        JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                miRecurso.setNombre(txtNombre.getText());
                                miRecurso.setTiporecurso(cbxTipo.getSelectedItem().toString());
                                miRecurso.setCantidadTotal(Integer.valueOf(spnCantidad.getValue().toString()));
                                JOptionPane.showMessageDialog(null, "Modificación exitosa", "Información", 
                                        JOptionPane.INFORMATION_MESSAGE);
                                dispose();
                            }
                        }
                    }
                });
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancelar");
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                });
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }
    
    private boolean validarCampos() {
        String nombre = txtNombre.getText();
        String tipo = cbxTipo.getSelectedItem().toString();
        
        if(nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un nombre", "Error", 
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(tipo.equals("Seleccione")) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo", "Error", 
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
}