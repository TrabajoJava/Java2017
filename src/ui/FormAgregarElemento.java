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

public class FormAgregarElemento extends JFrame {


	private CtrlElemento ctrl = new CtrlElemento();
	private JPanel contentPane;
	private JTextField txtIdElemento;
	private JTextField txtNomElemento;
	private JTextField txtIdTipo;
	private JButton btnAgregar;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAgregarTipo frame = new FormAgregarTipo();
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
	public FormAgregarElemento() {
		setTitle("Agrega Elemento");
		setDefaultCloseOperation(JInternalFrame.WHEN_IN_FOCUSED_WINDOW);
		
		setBounds(100, 100, 262, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtIdElemento = new JTextField();
		txtIdElemento.setBounds(86, 25, 86, 20);
		contentPane.add(txtIdElemento);
		txtIdElemento.setColumns(10);
		
		txtNomElemento = new JTextField();
		txtNomElemento.setBounds(86, 67, 86, 20);
		contentPane.add(txtNomElemento);
		txtNomElemento.setColumns(10);
		
		txtIdTipo = new JTextField();
		txtIdTipo.setBounds(86, 112, 86, 20);
		contentPane.add(txtIdTipo);
		txtIdTipo.setColumns(10);
		
		JLabel lblNomTipo = new JLabel("Nombre");
		lblNomTipo.setBounds(10, 70, 46, 14);
		contentPane.add(lblNomTipo);
		
		JLabel lblIdElemento = new JLabel("ID");
		lblIdElemento.setBounds(10, 28, 46, 14);
		contentPane.add(lblIdElemento);
		
		JLabel lblIdTipo = new JLabel("ID Tipo");
		lblIdTipo.setBounds(10, 115, 46, 14);
		contentPane.add(lblIdTipo);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				agregarClick();
			}
		});
		btnAgregar.setBounds(83, 182, 89, 23);
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
