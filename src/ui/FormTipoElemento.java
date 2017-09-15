package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
 
 
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlers.CtrlTipo;
import entity.TipoElemento;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormTipoElemento extends JFrame {
	
	private CtrlTipo ctrl=new CtrlTipo();

	private JPanel contentPane;
	private JTextField textId;
	private JTextField textNombre;
	private JTextField textReservMax;

	
	public FormTipoElemento() {
		
		setTitle("Busca Tipo Elemento");
		setDefaultCloseOperation(JInternalFrame.WHEN_IN_FOCUSED_WINDOW);
		setBounds(100, 100, 259, 185);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(26, 26, 73, 14);
		contentPane.add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(26, 51, 73, 14);
		contentPane.add(lblNombre);
		
		JLabel lblReservasMaximas = new JLabel("Reservas max:");
		lblReservasMaximas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReservasMaximas.setBounds(10, 76, 89, 14);
		contentPane.add(lblReservasMaximas);
		
		textId = new JTextField();
		textId.setBounds(109, 23, 86, 20);
		contentPane.add(textId);
		textId.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setBounds(109, 48, 86, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textReservMax = new JTextField();
		textReservMax.setEditable(false);
		textReservMax.setBounds(109, 73, 86, 20);
		contentPane.add(textReservMax);
		textReservMax.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarClick();
			}
		});
		btnBuscar.setBounds(69, 114, 89, 23);
		contentPane.add(btnBuscar);
	}
	
	protected void buscarClick() {
		try {
			this.mapearAForm(ctrl.getbyId(this.mapearDeForm().getIdtipo()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, "No existe tipo de elemento con ese Id");
		}
		
	}
	
	private void mapearAForm(TipoElemento t){
		this.textId.setText(String.valueOf(t.getIdtipo()));
		this.textNombre.setText(t.getNombretipo());
		this.textReservMax.setText(String.valueOf(t.getCantmaxreservaspendientes()));		

	}
	
	private TipoElemento mapearDeForm(){
		TipoElemento t=new TipoElemento();
		if(!this.textId.getText().isEmpty()){
			t.setIdtipo(Integer.parseInt(this.textId.getText()));
		}
		t.setNombretipo(this.textNombre.getText());
		t.setCantmaxreservaspendientes(Integer.parseInt(this.textId.getText()));
		return t;
	}
	
	
	
}
