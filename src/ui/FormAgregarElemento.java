package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlers.CtrlElemento;
import controlers.CtrlTipo;
import entity.Elemento;
import entity.TipoElemento;
import javax.swing.SwingConstants;

public class FormAgregarElemento extends JFrame {


	private CtrlElemento ctrl = new CtrlElemento();
	private JPanel contentPane;
	private JTextField txtIdElemento;
	private JTextField txtNomElemento;
	private JTextField txtIdTipo;
	private JButton btnAgregar;


	public FormAgregarElemento() {
		setTitle("Agrega Elemento");
		setDefaultCloseOperation(JInternalFrame.WHEN_IN_FOCUSED_WINDOW);
		
		setBounds(100, 100, 234, 199);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtIdElemento = new JTextField();
		txtIdElemento.setBounds(86, 19, 86, 20);
		contentPane.add(txtIdElemento);
		txtIdElemento.setColumns(10);
		
		txtNomElemento = new JTextField();
		txtNomElemento.setBounds(86, 50, 86, 20);
		contentPane.add(txtNomElemento);
		txtNomElemento.setColumns(10);
		
		txtIdTipo = new JTextField();
		txtIdTipo.setBounds(86, 81, 86, 20);
		contentPane.add(txtIdTipo);
		txtIdTipo.setColumns(10);
		
		JLabel lblNomTipo = new JLabel("Nombre:");
		lblNomTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomTipo.setBounds(10, 53, 66, 14);
		contentPane.add(lblNomTipo);
		
		JLabel lblIdElemento = new JLabel("Id:");
		lblIdElemento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdElemento.setBounds(30, 22, 46, 14);
		contentPane.add(lblIdElemento);
		
		JLabel lblIdTipo = new JLabel("Id Tipo:");
		lblIdTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdTipo.setBounds(10, 84, 66, 14);
		contentPane.add(lblIdTipo);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				agregarClick();
				JOptionPane.showMessageDialog(contentPane, "Elemento agregado con exito");
				dispose();
			}
		});
		btnAgregar.setBounds(119, 126, 89, 23);
		contentPane.add(btnAgregar);
	}
	
	protected void agregarClick() {
		Elemento el = this.mapearDeForm();
		try{
			ctrl.add(el);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		this.txtIdElemento.setText(String.valueOf(el.getIdtipo()));
		
	}
	
	private void mapearAForm(Elemento el){
		this.txtNomElemento.setText(el.getNombreElemento());
		this.txtIdElemento.setText(String.valueOf(el.getIdElemento()));
		this.txtIdTipo.setText(String.valueOf(el.getIdtipo()));
	
	}
	
	private Elemento mapearDeForm(){
		Elemento el= new Elemento();
		el.setIdElemento((Integer.parseInt(this.txtIdElemento.getText())));
		el.setNombreElemento((this.txtNomElemento.getText()));
		el.setIdtipo(((Integer.parseInt(this.txtIdTipo.getText()))));
		
		return el;
	}

}
