package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlers.CtrlTipo;
import entity.Persona;
import entity.Reserva;
import entity.TipoElemento;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class FormAgregarReserva extends JFrame {
	Date ffin,fini;
	int tipo;
	
	CtrlTipo ctrlper = new CtrlTipo();
	private JPanel contentPane;
	private JTable table;

	ArrayList<TipoElemento> tipos = null; 
	private JTextField txtFechaIni;
	private JTextField txtFechaFin;

	public FormAgregarReserva() {
	setTitle("Agregar reserva");
	setDefaultCloseOperation(JInternalFrame.WHEN_IN_FOCUSED_WINDOW);
	setBounds(100, 100, 555, 284);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(10, 10, 519, 133);
	contentPane.add(scrollPane);
	
	
	
	TipoElemento te = new TipoElemento();
	CtrlTipo controlador = new CtrlTipo();
	
	tipos = controlador.getalltipos();
	
	Object nombreColumnas[] = { "Id tipo", "Nombre tipo", "Cant. max. reservas"};
	Object datos[][] = new String[tipos.size()][nombreColumnas.length]; 
	

	for (int x = 0; x < tipos.size(); x++) {
		
		datos [x][0] = String.valueOf(tipos.get(x).getIdtipo());
		
		datos [x][1] = tipos.get(x).getNombretipo();
		
		datos [x][2] = String.valueOf(tipos.get(x).getCantmaxreservaspendientes());
			
	
	}
	
	table = new JTable();
	DefaultTableModel modelo = new DefaultTableModel(datos,nombreColumnas);
	table.setModel(modelo);
	
	scrollPane.setViewportView(table);
	
	JLabel lblFecha_ini = new JLabel("Fecha de inicio:");
	lblFecha_ini.setHorizontalAlignment(SwingConstants.RIGHT);
	lblFecha_ini.setBounds(20, 154, 104, 14);
	contentPane.add(lblFecha_ini);
	
	JLabel lblFecha_fin = new JLabel("Fecha de fin:");
	lblFecha_fin.setHorizontalAlignment(SwingConstants.RIGHT);
	lblFecha_fin.setBounds(30, 179, 94, 14);
	contentPane.add(lblFecha_fin);
	
	txtFechaIni = new JTextField();
	txtFechaIni.setBounds(134, 151, 225, 20);
	contentPane.add(txtFechaIni);
	txtFechaIni.setColumns(10);
	
	txtFechaFin = new JTextField();
	txtFechaFin.setBounds(134, 176, 225, 20);
	contentPane.add(txtFechaFin);
	txtFechaFin.setColumns(10);
	
	JButton btnDisponibles = new JButton("Ver disponibles");
	btnDisponibles.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			mapear();
			FormDisponibles fd = new FormDisponibles(fini,ffin,tipo);
			fd.setVisible(true);
		
		}
	});
	btnDisponibles.setBounds(80, 211, 130, 23);
	contentPane.add(btnDisponibles);

	
	}
	
	public void mapear(){
		
		this.fini = Date.valueOf(txtFechaIni.getText());
		this.ffin= Date.valueOf(txtFechaFin.getText());
		int fila;
		fila = table.getSelectedRow();
		String idtipo;
		idtipo=(String) table.getModel().getValueAt(fila, 0);
		this.tipo = Integer.parseInt(idtipo);
	}
}
