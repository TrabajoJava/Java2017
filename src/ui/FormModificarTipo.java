package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import controlers.CtrlPersona;
import controlers.CtrlTipo;
import entity.Persona;
import entity.TipoElemento;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class FormModificarTipo extends JFrame {
	
	private CtrlTipo ctrltipo =new CtrlTipo();

	private JPanel contentPane;
	private JTextField txtIdTipo;
	private JTextField txtCmrp;
	private JTextField txtNombreTipo;

	

	/**
	 * Create the frame.
	 * @param idTipo 
	 */
	public FormModificarTipo(int idTipo) {
		
		setTitle("Modifica Tipo de Elemento");
		setDefaultCloseOperation(JInternalFrame.WHEN_IN_FOCUSED_WINDOW);
		setBounds(100, 100, 315, 187);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdTipo = new JLabel("Id tipo:");
		lblIdTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdTipo.setBounds(128, 11, 46, 14);
		contentPane.add(lblIdTipo);
		
		txtIdTipo = new JTextField();
		txtIdTipo.setBounds(184, 8, 86, 20);
		contentPane.add(txtIdTipo);
		txtIdTipo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Maximas reservas pendientes:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(-42, 42, 216, 14);
		contentPane.add(lblNewLabel);
		
		txtCmrp = new JTextField();
		txtCmrp.setBounds(184, 39, 86, 20);
		contentPane.add(txtCmrp);
		txtCmrp.setColumns(10);
		
		JLabel lblNombreTipo = new JLabel("Nombre tipo:");
		lblNombreTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreTipo.setBounds(103, 73, 71, 14);
		contentPane.add(lblNombreTipo);
		
		txtNombreTipo = new JTextField();
		txtNombreTipo.setBounds(184, 70, 86, 20);
		contentPane.add(txtNombreTipo);
		txtNombreTipo.setColumns(10);


		TipoElemento te = new TipoElemento();
		te = ctrltipo.getbyId(idTipo);
		this.mapearAForm(te);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarClick();
				JOptionPane.showMessageDialog(contentPane, "Tipo Elemento modificado con exito");
				dispose();
			}
		});
		btnModificar.setBounds(200, 114, 89, 23);
		contentPane.add(btnModificar);
	}
	
	protected void ModificarClick() {
		TipoElemento te = this.mapearDeForm();
		try{
			ctrltipo.update(te);
			} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	
		
	}
	
	
	private void mapearAForm(TipoElemento t){
		this.txtIdTipo.setText(String.valueOf(t.getIdtipo()));
		this.txtNombreTipo.setText(t.getNombretipo());
		this.txtCmrp.setText(String.valueOf(t.getCantmaxreservaspendientes()));
		
		
	}
	
	private TipoElemento mapearDeForm(){
		TipoElemento t=new TipoElemento();
		
		t.setIdtipo(Integer.parseInt(this.txtIdTipo.getText()));
		t.setNombretipo(this.txtNombreTipo.getText());
		t.setCantmaxreservaspendientes(Integer.parseInt(this.txtCmrp.getText()));
		
		return t;
	}
}
