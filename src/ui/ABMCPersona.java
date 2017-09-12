package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

public class ABMCPersona extends JFrame {

	private JPanel contentPane;
	private JTable tablaPersonas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the frame.
	 */
	public ABMCPersona() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(34, 210, 71, 23);
		contentPane.add(btnAgregar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnModificar.setBounds(133, 210, 81, 23);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(240, 210, 71, 23);
		contentPane.add(btnEliminar);
		
		tablaPersonas = new JTable();
		tablaPersonas.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "DNI", "Apellido", "Nombre", "Usuario", "Contrase\u00F1a", "Habilitado"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Float.class, Float.class, Float.class, Float.class, Float.class, Float.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tablaPersonas.getColumnModel().getColumn(0).setPreferredWidth(35);
		tablaPersonas.getColumnModel().getColumn(0).setMaxWidth(35);
		tablaPersonas.getColumnModel().getColumn(1).setMaxWidth(80);
		tablaPersonas.getColumnModel().getColumn(2).setMaxWidth(80);
		tablaPersonas.getColumnModel().getColumn(3).setMaxWidth(80);
		tablaPersonas.getColumnModel().getColumn(4).setMaxWidth(80);
		tablaPersonas.getColumnModel().getColumn(5).setMaxWidth(80);
		tablaPersonas.getColumnModel().getColumn(6).setMaxWidth(80);
		tablaPersonas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tablaPersonas.setCellSelectionEnabled(true);
		tablaPersonas.setToolTipText("");
		tablaPersonas.setBounds(304, 145, -291, -131);
		contentPane.add(tablaPersonas);
		String[] columnNames = {"First Name",
                "Last Name",
                "Sport",
                "# of Years",
                "Vegetarian"};
	}
}
