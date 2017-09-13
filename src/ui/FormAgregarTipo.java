package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlers.CtrlTipo;
import entity.Persona;
import entity.TipoElemento;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class FormAgregarTipo extends JFrame {
/*y tambien este*/
	private CtrlTipo ctrl = new CtrlTipo();
	private JPanel contentPane;
	private JTextField txtIdTipo;
	private JTextField txtNomTipo;
	private JTextField txtCantMax;
	private JButton btnAgregar;

	/**
	 * Launch the application.
	 */
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
	public FormAgregarTipo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 262, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtIdTipo = new JTextField();
		txtIdTipo.setBounds(86, 25, 86, 20);
		contentPane.add(txtIdTipo);
		txtIdTipo.setColumns(10);
		
		txtNomTipo = new JTextField();
		txtNomTipo.setBounds(86, 67, 86, 20);
		contentPane.add(txtNomTipo);
		txtNomTipo.setColumns(10);
		
		txtCantMax = new JTextField();
		txtCantMax.setBounds(86, 112, 86, 20);
		contentPane.add(txtCantMax);
		txtCantMax.setColumns(10);
		
		JLabel lblNomTipo = new JLabel("Nombre");
		lblNomTipo.setBounds(10, 70, 46, 14);
		contentPane.add(lblNomTipo);
		
		JLabel lblIdTipo = new JLabel("ID");
		lblIdTipo.setBounds(10, 28, 46, 14);
		contentPane.add(lblIdTipo);
		
		JLabel lblCantmax = new JLabel("CantMax");
		lblCantmax.setBounds(10, 115, 46, 14);
		contentPane.add(lblCantmax);
		
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
