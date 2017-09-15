package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import controlers.CtrlPersona;
import controlers.CtrlTipo;
import data.DataTipoElemento;
import entity.Persona;
import entity.TipoElemento;

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

public class ABMCTipo extends JFrame {

	private JPanel contentPane;
	CtrlTipo ctrltipo = new CtrlTipo();
	private JTable table;


	ArrayList<TipoElemento> tipos = null; 
	

	public ABMCTipo() {
		
			setTitle("Tipo Elemento");
			setDefaultCloseOperation(JInternalFrame.WHEN_IN_FOCUSED_WINDOW);
			setBounds(100, 100, 555, 271);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 519, 110);
			contentPane.add(scrollPane);
			
			
			
			TipoElemento te = new TipoElemento();
			CtrlTipo controlador = new CtrlTipo();
			
			tipos = controlador.getalltipos();
			
			Object nombreColumnas[] = { "Id tipo", "Nombre tipo", "Max. Reservas"};
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
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormAgregarTipo fagt = new FormAgregarTipo();
				fagt.setVisible(true);
				
			}
		});
		btnAgregar.setBounds(58, 182, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TipoElemento te = new TipoElemento();
				int fila;
				fila = table.getSelectedRow();
				int idTipo;
				idTipo =  Integer.parseInt((String)table.getModel().getValueAt(fila,0));
				FormModificarTipo fmt = new FormModificarTipo(idTipo);
				fmt.setVisible(true);
			}
		});
		btnModificar.setBounds(172, 182, 89, 23);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int fila;
				fila = table.getSelectedRow();
				String idtipo;
				idtipo =  (String) table.getModel().getValueAt(fila,0);
				TipoElemento te = new TipoElemento();
				te.setIdtipo(Integer.parseInt(idtipo));;
				CtrlTipo ctrltipo =new CtrlTipo();
				ctrltipo.deletebyid(te);
				JOptionPane.showMessageDialog(contentPane, "Eliminado con exito");
			}
		});
		btnEliminar.setBounds(291, 182, 89, 23);
		contentPane.add(btnEliminar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormTipoElemento fte = new FormTipoElemento();
				fte.setVisible(true);
			}
		});
		btnBuscar.setBounds(410, 182, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose(); //cierra ventana
				
				ABMCTipo pr = new ABMCTipo();
				pr.setVisible(true);
			}
		});
		btnActualizar.setBounds(10, 132, 101, 23);
		contentPane.add(btnActualizar);
	}

}