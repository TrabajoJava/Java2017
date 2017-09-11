package ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlers.CtrlPersona;
import entity.Persona;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class ABMCPersonaDesktop extends JInternalFrame {

	private CtrlPersona ctrl = new CtrlPersona();
	
	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JCheckBox chkHabilitado;
	private JButton btnAgregar;
	private JButton btnBuscar;
	private JButton btnBorrar;
	private JButton btnModificar;
	private JTextField txtId;
	private JTextField txtCategoria;
	private JLabel lblUsuario; 
	private JLabel lblConstrasena;
	private JTextField txtUsuario; 
	private JTextField txtContrasena; 
	private JLabel lblResultado;
	private JRadioButton rdbtnCategoriaUsuario;
	private JRadioButton rdbtnCategoriaAdministrador;
	private JRadioButton rdbtnCategoriaEncargado;
	private ButtonGroup group;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCPersonaDesktop frame = new ABMCPersonaDesktop();
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
	public ABMCPersonaDesktop() {
		setClosable(true);
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 322, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Persona p = new Persona();
		CtrlPersona controlador = new CtrlPersona();
		
		
		JLabel lblDni = new JLabel("DNI");
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		
		JLabel lblApellido = new JLabel("Apellido");
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		
		chkHabilitado = new JCheckBox("Habilitado");
		chkHabilitado.setSelected(true);
		
		lblUsuario = new JLabel("Usuario");
		
		lblConstrasena = new JLabel("Contrasena");
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		
		txtContrasena = new JTextField();
		txtContrasena.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		
		
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscarClick();
			}
		});
		
		btnAgregar = new JButton("Agregar");
		
		
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				agregarClick();
			}
		});
		
		btnBorrar = new JButton("Borrar");
		
		
		
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				borrarClick();
			}
		});
		
		btnModificar = new JButton("Modificar");
	
		
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modificarClick();
			}
		});
		
		JLabel lblId = new JLabel("ID");
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setColumns(10);
		
		txtCategoria = new JTextField();
		txtCategoria.setColumns(20);
		
		lblResultado = new JLabel("Resultado");
		
		rdbtnCategoriaUsuario = new JRadioButton("Usuario");
		rdbtnCategoriaAdministrador = new JRadioButton("Admin");
		rdbtnCategoriaEncargado = new JRadioButton("Encargado");
		
		group = new ButtonGroup(); 
		group.add(rdbtnCategoriaUsuario);
		group.add(rdbtnCategoriaAdministrador);
		group.add(rdbtnCategoriaEncargado);
		
		
		

			
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblId)
										.addComponent(lblDni)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblNombre))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblApellido))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblUsuario)))
							.addGap(37)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(txtNombre)
								.addComponent(txtUsuario, Alignment.LEADING)
								.addComponent(txtApellido, Alignment.LEADING)
								.addComponent(txtId)
								.addComponent(txtDni, Alignment.LEADING))
							.addGap(18)
							.addComponent(btnBuscar))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(chkHabilitado)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblConstrasena)
									.addGap(18)
									.addComponent(txtContrasena, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(rdbtnCategoriaUsuario)
									.addGap(18)
									.addComponent(rdbtnCategoriaAdministrador)
									.addGap(18)
									.addComponent(rdbtnCategoriaEncargado)))))
					.addGap(138))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAgregar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBorrar, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnModificar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(151))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(164)
					.addComponent(lblResultado, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDni)
						.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblApellido))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsuario))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConstrasena)
						.addComponent(txtContrasena, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chkHabilitado)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnCategoriaUsuario)
						.addComponent(rdbtnCategoriaAdministrador)
						.addComponent(rdbtnCategoriaEncargado))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAgregar)
						.addComponent(btnBorrar)
						.addComponent(btnModificar))
					.addGap(18)
					.addComponent(lblResultado)
					.addContainerGap(40, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	
	protected void buscarClick() {
		this.mapearAForm(ctrl.getbydni(this.mapearDeForm()));
		}
	
	protected void agregarClick(){
		Persona p = this.mapearDeForm();
		ctrl.add(p);
		this.txtId.setText(String.valueOf(p.getId()));
		}
	
	protected void borrarClick(){
		ctrl.deletebydni(this.mapearDeForm());
	}
	
	protected void modificarClick(){
		ctrl.update(this.mapearDeForm());
	}
	
	 private int devuelveCategoria(){
		return 0;
	}
		/*	private int devuelveCategoria(rdbtnCategoriaUsuario,rdbtnCategoriaAdministrador,rdbtnCategoriaEncargado){
		int a=0;
		if( rdbtnCategoriaUsuario.isSelected()){
			a=0;
		}
			else if ( rdbtnCategoriaAdministrador.isSelected()){
			a=1;
			}
			else if(rdbtnCategoriaEncargado.isSelected()){
			a=2;
			}
		return a;
	} */
	
	private void mapearAForm(Persona p){
		this.txtDni.setText(p.getDni());
		this.txtNombre.setText(p.getNombre());
		this.txtApellido.setText(p.getApellido());
		this.chkHabilitado.setSelected(p.isHabilitado());
		this.txtId.setText(String.valueOf(p.getId()));
	}
	
	private Persona mapearDeForm(){
				Persona p=new Persona();
				p.setDni(this.txtDni.getText());
				p.setNombre(this.txtNombre.getText());
				p.setApellido(this.txtApellido.getText());
				p.setHabilitado(this.chkHabilitado.isSelected());
				p.setUsuario(this.txtUsuario.getText());
				p.setContrasena(this.txtContrasena.getText());
				p.setIdcat(this.devuelveCategoria());
				return p;
			}
}