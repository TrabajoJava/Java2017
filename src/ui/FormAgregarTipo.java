package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlers.CtrlTipo;
import entity.Persona;
import entity.TipoElemento;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class FormAgregarTipo extends JFrame {

	private CtrlTipo ctrl = new CtrlTipo();
	private JPanel contentPane;
	private JTextField txtIdTipo;
	private JTextField txtNomTipo;
	private JTextField txtCantMax;
	private JButton btnAgregar;


	public FormAgregarTipo() {
		setTitle("Agrega Tipo");
		setDefaultCloseOperation(JInternalFrame.WHEN_IN_FOCUSED_WINDOW);
		
		setBounds(100, 100, 234, 207);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtIdTipo = new JTextField();
		txtIdTipo.setBounds(86, 25, 86, 20);
		contentPane.add(txtIdTipo);
		txtIdTipo.setColumns(10);
		
		txtNomTipo = new JTextField();
		txtNomTipo.setBounds(86, 56, 86, 20);
		contentPane.add(txtNomTipo);
		txtNomTipo.setColumns(10);
		
		txtCantMax = new JTextField();
		txtCantMax.setBounds(86, 87, 86, 20);
		contentPane.add(txtCantMax);
		txtCantMax.setColumns(10);
		
		JLabel lblNomTipo = new JLabel("Nombre:");
		lblNomTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomTipo.setBounds(10, 59, 66, 14);
		contentPane.add(lblNomTipo);
		
		JLabel lblIdTipo = new JLabel("Id:");
		lblIdTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdTipo.setBounds(10, 28, 66, 14);
		contentPane.add(lblIdTipo);
		
		JLabel lblCantmax = new JLabel("CantMax:");
		lblCantmax.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantmax.setBounds(10, 90, 66, 14);
		contentPane.add(lblCantmax);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				agregarClick();
			}
		});
		btnAgregar.setBounds(119, 134, 89, 23);
		contentPane.add(btnAgregar);
	}
	
	protected void agregarClick() {
		TipoElemento tp = this.mapearDeForm();
		try{
			ctrl.add(tp);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		this.txtIdTipo.setText(String.valueOf(tp.getIdtipo()));
		
	}
	
	private void mapearAForm(TipoElemento tp){
		this.txtNomTipo.setText(tp.getNombretipo());
		this.txtIdTipo.setText(String.valueOf(tp.getIdtipo()));
		this.txtCantMax.setText(String.valueOf(tp.getCantmaxreservaspendientes()));
	
	}
	
	private TipoElemento mapearDeForm(){
		TipoElemento tp=new TipoElemento();
		if(!this.txtIdTipo.getText().isEmpty()){
			tp.setIdtipo((Integer.parseInt(this.txtIdTipo.getText())));
		}
		tp.setNombretipo((this.txtNomTipo.getText()));
		tp.setCantmaxreservaspendientes((Integer.parseInt(this.txtCantMax.getText())));
		
		return tp;
	}

}
