package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import controlers.CtrlElemento;
import controlers.CtrlPersona;
import data.DataElemento;
import entity.Elemento;
import entity.Persona;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class ABMCElemento extends JFrame {
	
	CtrlElemento ctrlele = new CtrlElemento();
	private JPanel contentPane;
	private JTable table;


	ArrayList<Elemento> elementos = null; 
	

	public ABMCElemento() {
		setTitle("Elemento");
		setDefaultCloseOperation(JInternalFrame.WHEN_IN_FOCUSED_WINDOW);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 133);
		contentPane.add(scrollPane);
		
		Elemento e = new Elemento();
		CtrlElemento controlador = new CtrlElemento();
		
		elementos = controlador.getAll();
		
		Object nombreColumnas[] = { "ID Elemento", "Nombre Elemento"};
		Object datos[][] = new String[elementos.size()][nombreColumnas.length]; 
		

		for (int x = 0; x < elementos.size(); x++) {
			
			datos [x][0] = String.valueOf(elementos.get(x).getIdElemento());
			
			datos [x][1] = elementos.get(x).getNombreElemento();
			
					}
		
		table = new JTable();
		DefaultTableModel modelo = new DefaultTableModel(datos,nombreColumnas);
		table.setModel(modelo);
		
		scrollPane.setViewportView(table);

		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormAgregarElemento fagt = new FormAgregarElemento();
				fagt.setVisible(true);
				
			}
		});
		btnAgregar.setBounds(10, 215, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnModificar.setBounds(109, 215, 89, 23);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(208, 215, 89, 23);
		contentPane.add(btnEliminar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(307, 215, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
				ABMCElemento pr = new ABMCElemento();
				pr.setVisible(true);
			}
		});
		btnActualizar.setBounds(10, 155, 98, 23);
		contentPane.add(btnActualizar);
	}
}