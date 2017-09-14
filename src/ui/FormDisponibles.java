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
import javax.swing.JLabel;

public class FormDisponibles extends JFrame {


	private JPanel contentPane;
	private JTextField txtDetalle;
	


	
	public FormDisponibles() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngreseDetalle = new JLabel("Ingrese detalle:");
		lblIngreseDetalle.setBounds(22, 177, 95, 14);
		contentPane.add(lblIngreseDetalle);
		
		JButton btnReservar = new JButton("Reservar");
		btnReservar.setBounds(316, 227, 89, 23);
		contentPane.add(btnReservar);
		
		txtDetalle = new JTextField();
		txtDetalle.setBounds(115, 174, 290, 20);
		contentPane.add(txtDetalle);
		txtDetalle.setColumns(10);
	}
}
