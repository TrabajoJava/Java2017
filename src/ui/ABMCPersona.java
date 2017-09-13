                        package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import controlers.CtrlPersona;
import entity.Persona;
import javax.swing.JScrollPane;
import tablas.tablaPersonas;

public class ABMCPersona extends JFrame {

	CtrlPersona ctrlper = new CtrlPersona();
	private JPanel contentPane;
	private JTable table;


	ArrayList<Persona> personas = null; 
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCPersona frame = new ABMCPersona();
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
	public ABMCPersona() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 604, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Persona p = new Persona();
		CtrlPersona controlador = new CtrlPersona();
		
		personas = controlador.getall();
		
		Object nombreColumnas[] = { "ID", "Nombre", "Apellido", "DNI", "Habilitado", "Usuario", "Contraseña"};
		Object datos[][] = new String[personas.size()][nombreColumnas.length]; 
		

		for (int x = 0; x < personas.size(); x++) {
			
			datos [x][0] = String.valueOf(personas.get(x).getId());
			
			datos [x][1] = personas.get(x).getNombre();
			
			datos [x][2] = personas.get(x).getApellido();
			
			datos [x][3] = personas.get(x).getDni();
			
			datos [x][4] = String.valueOf(personas.get(x).isHabilitado());
			
			datos [x][5] = personas.get(x).getUsuario();
			
			datos [x][6] = personas.get(x).getContrasena();
			
		
		}
		
		
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormAgregarPersona fagp = new FormAgregarPersona();
				fagp.setVisible(true);
				
			}
		});
		btnAgregar.setBounds(53, 210, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnModificar.setBounds(170, 210, 89, 23);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(284, 210, 89, 23);
		contentPane.add(btnEliminar);
		
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormPersona fp = new FormPersona();
				fp.setVisible(true);
			}
		});
		btnBuscar.setBounds(391, 210, 89, 23);
		contentPane.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 185, 532, -174);
		contentPane.add(scrollPane);
		

		table = new JTable();
		table.setModel(
				new DefaultTableModel(datos,nombreColumnas));
		
		scrollPane.setViewportView(table);

	
	
	
	}
}
