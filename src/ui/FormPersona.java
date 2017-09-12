package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlers.CtrlPersona;
import entity.Persona;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormPersona extends JFrame {
	
	private CtrlPersona ctrl = new CtrlPersona();
	
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtUsuario;
	private JTextField txtContrasena;
	private JTextField txtDni;
	private JTextField txtId;
	private JCheckBox chbHabilitado;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormPersona frame = new FormPersona();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public FormPersona() {
		setTitle("Persona");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Persona p = new Persona();
		CtrlPersona ctrl = new CtrlPersona();
		
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(129, 57, 144, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		txtApellido.setBounds(129, 88, 144, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setEditable(false);
		txtUsuario.setBounds(129, 155, 144, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContrasena = new JTextField();
		txtContrasena.setEditable(false);
		txtContrasena.setBounds(129, 186, 144, 20);
		contentPane.add(txtContrasena);
		txtContrasena.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(38, 63, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(38, 94, 46, 14);
		contentPane.add(lblApellido);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(38, 161, 46, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasena = new JLabel("Contrasena");
		lblContrasena.setBounds(38, 192, 76, 14);
		contentPane.add(lblContrasena);
		
		JCheckBox chbHabilitado = new JCheckBox("Habilitado");
		chbHabilitado.setSelected(true);
		chbHabilitado.setBounds(38, 217, 97, 23);
		contentPane.add(chbHabilitado);
		
		JRadioButton rdbtnUsuario = new JRadioButton("Usuario");
		rdbtnUsuario.setBounds(38, 243, 109, 23);
		contentPane.add(rdbtnUsuario);
		
		JRadioButton rdbtnEncargado = new JRadioButton("Encargado");
		rdbtnEncargado.setBounds(164, 243, 109, 23);
		contentPane.add(rdbtnEncargado);
		
		JRadioButton rdbtnAdministrador = new JRadioButton("Administrador");
		rdbtnAdministrador.setBounds(300, 243, 109, 23);
		contentPane.add(rdbtnAdministrador);
		
		JLabel lblDni = new JLabel("Dni");
		lblDni.setBounds(38, 130, 46, 14);
		contentPane.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setBounds(129, 124, 144, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
	
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscarClick();
			}

			
		});
		btnBuscar.setBounds(129, 292, 144, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(38, 29, 46, 14);
		contentPane.add(lblId);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(129, 26, 144, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
			
		
		
		
	}
	
	protected void buscarClick() {
		this.mapearAForm(ctrl.getbydni(this.mapearDeForm()));
		}
	
	private void mapearAForm(Persona p){
		this.txtDni.setText(p.getDni());
		this.txtNombre.setText(p.getNombre());
		this.txtApellido.setText(p.getApellido());
		this.chbHabilitado.setSelected(p.isHabilitado());
		this.txtId.setText(String.valueOf(p.getId()));
	}
	
	private Persona mapearDeForm(){
		
		Persona p = new Persona();
		p.setDni(this.txtDni.getText());
		p.setApellido(this.txtApellido.getText());
		p.setNombre(this.txtNombre.getText());
		p.setUsuario(this.txtUsuario.getText());
		p.setContrasena(this.txtContrasena.getText());
		p.setHabilitado(this.chbHabilitado.isSelected());
		return p;
		
	}
	
	
	
}
