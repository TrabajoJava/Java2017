package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;


import controlers.CtrlReserva;
import data.DataReserva;
import entity.Reserva;


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

public class ABMCReserva extends JFrame {

	CtrlReserva ctrlres = new CtrlReserva();
	private JPanel contentPane;
	private JTable table;


	ArrayList<Reserva> reservas = null;
	
	
	public ABMCReserva() {
		setTitle("Reserva");
		setDefaultCloseOperation(JInternalFrame.WHEN_IN_FOCUSED_WINDOW);
		setBounds(100, 100, 555, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 519, 133);
		contentPane.add(scrollPane);
		
		
		
		Reserva r = new Reserva();
		CtrlReserva controlador = new CtrlReserva();
		
		reservas = controlador.getall();
		
		Object nombreColumnas[] = { "Id elemento", "Id Persona", "Fecha inicio", "Fecha fin", "Detalle"};
		Object datos[][] = new String[reservas.size()][nombreColumnas.length]; 
		

		for (int x = 0; x < reservas.size(); x++) {
			
			datos [x][0] = String.valueOf(reservas.get(x).getId_elemento());
			
			datos [x][1] = String.valueOf(reservas.get(x).getId_persona());
			
			datos [x][2] = String.valueOf(reservas.get(x).getFecha_inicio());
			
			datos [x][3] = String.valueOf(reservas.get(x).getFecha_fin());
			
			datos [x][4] = reservas.get(x).getDetalle();
			
		}
		
		table = new JTable();
		DefaultTableModel modelo = new DefaultTableModel(datos,nombreColumnas);
		table.setModel(modelo);
		
		scrollPane.setViewportView(table);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(20, 144, 107, 23);
		contentPane.add(btnActualizar);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FormAgregarReserva far = new FormAgregarReserva();
				far.setVisible(true);
			}
		});
		btnAgregar.setBounds(54, 196, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(170, 196, 89, 23);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(284, 196, 89, 23);
		contentPane.add(btnEliminar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(403, 196, 89, 23);
		contentPane.add(btnBuscar);
		
	}
}