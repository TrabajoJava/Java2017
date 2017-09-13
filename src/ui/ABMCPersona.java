package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import controlers.CtrlPersona;
import data.DataPersona;
import entity.Persona;
import tablas.tablaPersonas;

import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableModel;

public class ABMCPersona extends JFrame {

	CtrlPersona ctrlper = new CtrlPersona();
	private JPanel contentPane;
	private JTable table;


	ArrayList<Persona> personas = null; 
	
	
	public ABMCPersona() {
		setTitle("Persona");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 555, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 478, 82);
		contentPane.add(scrollPane);
		
		Persona p = new Persona();
		CtrlPersona controlador = new CtrlPersona();
		
		personas = controlador.getall();
		
		Object nombreColumnas[] = { "ID", "Nombre", "Apellido", "DNI", "Habilitado", "Usuario", "Contrasena"};
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
		
		table = new JTable();
		table.setModel(
				new DefaultTableModel(datos,nombreColumnas));
		
		scrollPane.setViewportView(table);

		
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
		
		
		

		
	
	
	
	}
}
