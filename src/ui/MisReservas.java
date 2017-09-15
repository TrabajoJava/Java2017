package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import controlers.CtrlPersona;
import controlers.CtrlReserva;
import data.DataReserva;
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

public class MisReservas extends JFrame {

	public int idPersona;
	
	/*public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}*/

	CtrlReserva ctrlres = new CtrlReserva();
	private JPanel contentPane;
	private JTable table;
	
	ArrayList<Reserva> reservas = null; 

	/**
	 * Create the frame.
	 * @param idper 
	 */
	public MisReservas(int idper) {
		setTitle("Mis reservas");
		setDefaultCloseOperation(JInternalFrame.WHEN_IN_FOCUSED_WINDOW);
		setBounds(100, 100, 555, 261);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 519, 133);
		contentPane.add(scrollPane);
		

		Reserva re = new Reserva();
		CtrlReserva controlador = new CtrlReserva();
		
		reservas = controlador.getMisReservas(idper);
		
		Object nombreColumnas[] = { "id Elemento", "id Persona", "fecha inicio", " fecha fin", "detalle"};
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
		
		JButton btnCancelarReserva = new JButton("Cancelar reserva");
		btnCancelarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int fila;
				fila = table.getSelectedRow();
				String idele;
				idele =  (String) table.getModel().getValueAt(fila,0);
				String idper;
				idper =  (String) table.getModel().getValueAt(fila,1);
				String fecini;
				fecini =  (String) table.getModel().getValueAt(fila,2);
				String fecfin;
				fecfin =  (String) table.getModel().getValueAt(fila,3);
				Reserva re = new Reserva();
				re.setId_elemento(Integer.parseInt(idele));
				re.setId_persona(Integer.parseInt(idper));
				re.setFecha_inicio(Date.valueOf(fecini));
				re.setFecha_fin(Date.valueOf(fecfin));
				ctrlres.delete(re);	
				
				
			}
		});
		btnCancelarReserva.setBounds(210, 179, 122, 23);
		contentPane.add(btnCancelarReserva);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				MisReservas mr = new MisReservas(idper);
			}
		});
		btnActualizar.setBounds(20, 144, 89, 23);
		contentPane.add(btnActualizar);

		
	}
}
