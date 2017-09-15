package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import controlers.CtrlElemento;
import controlers.CtrlPersona;
import controlers.CtrlReserva;
import data.DataElemento;
import entity.Elemento;
import entity.Persona;
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
import java.sql.Date;
//
public class FormDisponibles extends JFrame {

	CtrlElemento ctrlele = new CtrlElemento();
	CtrlReserva ctrlres = new CtrlReserva();
	private JPanel contentPane;
	private JTable table;
	
	ArrayList<Elemento> elementos = null; 
	private JTextField txtDetalle;


	
	public FormDisponibles(int idper, Date fini, Date ffin, int tipo) {
		setTitle("Elementos");
		
		
		setDefaultCloseOperation(JInternalFrame.WHEN_IN_FOCUSED_WINDOW);
		setBounds(100, 100, 454, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 519, 133);
		contentPane.add(scrollPane);
		
		Elemento ele = new Elemento();
		CtrlElemento controlador = new CtrlElemento();
		
		elementos = controlador.getDisp(fini, ffin, tipo);
		
		Object nombreColumnas[] = { "Id Elemento", "Nombre Elemento"};
		Object datos[][] = new String[elementos.size()][nombreColumnas.length]; 
		

		for (int x = 0; x < elementos.size(); x++) {
			
			datos [x][0] = String.valueOf(elementos.get(x).getIdElemento());
			
			datos [x][1] = elementos.get(x).getNombreElemento();	
		
	
		
		}
		
		table = new JTable();
		DefaultTableModel modelo = new DefaultTableModel(datos,nombreColumnas);
		table.setModel(modelo);
		
		scrollPane.setViewportView(table);

	
		
		JLabel lblIngreseDetalle = new JLabel("Ingrese detalle:");
		lblIngreseDetalle.setBounds(22, 177, 95, 14);
		contentPane.add(lblIngreseDetalle);
		
		JButton btnReservar = new JButton("Reservar");
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarClick(idper,fini,ffin,tipo);
				JOptionPane.showMessageDialog(contentPane, "Reserva exitosa");
				dispose();
				
				
			}
		});
		btnReservar.setBounds(316, 227, 89, 23);
		contentPane.add(btnReservar);
		
		txtDetalle = new JTextField();
		txtDetalle.setBounds(110, 174, 295, 20);
		contentPane.add(txtDetalle);
		txtDetalle.setColumns(10);
		
		
	}
	protected void agregarClick(int idper, Date fini, Date ffin, int tipo) {
		Reserva res = this.mapearDeForm(idper,fini,ffin,tipo);
		try{
			ctrlres.add(res);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		
		
	}
	
	private Reserva mapearDeForm(int idper, Date fini, Date ffin, int tipo){
		Reserva res=new Reserva();
		
		res.setDetalle(this.txtDetalle.getText());
		res.setFecha_inicio(fini);
		res.setFecha_fin(ffin);
		int fila;
		fila = table.getSelectedRow();
		String idElemento;
		idElemento=(String) table.getModel().getValueAt(fila, 0);
		res.setId_elemento(Integer.parseInt(idElemento));
		res.setId_persona(idper);
		
		return res;
	}
}
