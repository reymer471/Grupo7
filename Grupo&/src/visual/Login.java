package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import logico.Control;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setBackground(Color.BLACK);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-information@2x.png")));
		setTitle("Gestion PUCMM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 400, 305);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.YELLOW));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("\u00A1Bienvenido al gestor de eventos de nuestra alma mater!");
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setFont(new Font("Calisto MT", Font.ITALIC, 13));
		lblNewLabel.setBounds(40, 13, 304, 20);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario:");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaTimeThumb.png")));
		lblNewLabel_1.setBounds(29, 75, 90, 14);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(131, 72, 152, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaTimeThumb.png")));
		lblNewLabel_2.setBounds(29, 164, 93, 14);
		panel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(131, 161, 152, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Loggin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Control.getInstance().confirmLogin(textField.getText(), textField_1.getText())) {
					Principal frame = new Principal();
					dispose();
					frame.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(235, 212, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Inserte su nombre de usuario");
		lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		lblNewLabel_3.setBounds(29, 49, 213, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Inserte su contrase\u00F1a:");
		lblNewLabel_4.setIcon(new ImageIcon(Login.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		lblNewLabel_4.setBounds(29, 130, 159, 14);
		panel.add(lblNewLabel_4);
		
		
	}
}
