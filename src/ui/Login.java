package ui;
import controlers.CtrlLogin;
import entity.Persona;


import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Canvas;
import java.awt.Font;
import java.awt.SystemColor;

public class Login extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CtrlLogin ctrl=new CtrlLogin();

	private JPanel contentPane;
	private JPasswordField passFieldPass;
	private JTextField txtUsuario;

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
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 301, 146);
		contentPane = new JPanel();
		
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setBounds(19, 14, 74, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasena = new JLabel("Contrasena:");
		lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblContrasena.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasena.setBounds(12, 45, 81, 14);
		contentPane.add(lblContrasena);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnIngresar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				btnIngresarClick();
				
			}
		});
		btnIngresar.setBounds(105, 73, 89, 23);
		contentPane.add(btnIngresar);
		
		JLabel label = new JLabel("-");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(105, 222, 213, 14);
		contentPane.add(label);
		
		passFieldPass = new JPasswordField();
		passFieldPass.setFont(new Font("Tahoma", Font.PLAIN, 11));
		passFieldPass.setEchoChar('*');
		passFieldPass.setBounds(103, 42, 108, 20);
		contentPane.add(passFieldPass);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtUsuario.setBounds(103, 11, 108, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
	}
	
	@SuppressWarnings("deprecation")
	private void btnIngresarClick(){
		Persona p = new Persona();
		p.setUsuario(txtUsuario.getText());
		p.setContrasena(passFieldPass.getText());
		Persona per=null;
		per =ctrl.compara(p);
		if (per == null){JOptionPane.showMessageDialog(contentPane, "Usuario o contraseña incorrectos");}
		
		if(per!=null){
			int idper = per.getId();
			Menu menu = new Menu(idper);
			menu.setVisible(true);

			dispose();
					
		}
	}
}