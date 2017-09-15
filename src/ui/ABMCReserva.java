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
	
	public int idPersona;
	
	/*public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}*/
	
	
	public ABMCReserva(int idper) {
		setTitle("Reserva");
		setDefaultCloseOperation(JInternalFrame.WHEN_IN_FOCUSED_WINDOW);
		setBounds(100, 100, 349, 217);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		JButton btnAgregar = new JButton("Agregar Reserva");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FormAgregarReserva far = new FormAgregarReserva(idper);
				far.setVisible(true);
			}
		});
		btnAgregar.setBounds(73, 50, 158, 23);
		contentPane.add(btnAgregar);
		
		JButton btnMisReservas = new JButton("Mis reservas");
		btnMisReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MisReservas mr = new MisReservas(idper);
				mr.setVisible(true);
				//mr.setIdPersona(idPersona);
				
			}
		});
		btnMisReservas.setBounds(73, 98, 158, 23);
		contentPane.add(btnMisReservas);
		
	}
}