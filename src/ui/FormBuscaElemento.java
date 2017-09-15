package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
 
 
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlers.CtrlElemento;
import controlers.CtrlTipo;
import entity.Elemento;
import entity.TipoElemento;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormBuscaElemento extends JFrame {

	private CtrlElemento ctrl=new CtrlElemento();

	private JPanel contentPane;
	private JTextField textId;
	private JTextField textNombre;

	/**
	 * Create the frame.
	 */
	public FormBuscaElemento() {
		setTitle("Busca Elemento");
		setDefaultCloseOperation(JInternalFrame.WHEN_IN_FOCUSED_WINDOW);
		setBounds(100, 100, 306, 282);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblId = new JLabel("Id:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(26, 77, 73, 14);
		contentPane.add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(26, 102, 73, 14);
		contentPane.add(lblNombre);
		
		
		textId = new JTextField();
		textId.setBounds(109, 74, 86, 20);
		contentPane.add(textId);
		textId.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setBounds(109, 99, 86, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarClick();
			}
		});
		btnBuscar.setBounds(106, 145, 89, 23);
		contentPane.add(btnBuscar);
		
		
		
		
	}

	protected void buscarClick() {
		try {
			this.mapearAForm(ctrl.getbyid(this.mapearDeForm()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, "No existe elemento con ese Id");
		}
		
	}
	
	private void mapearAForm(Elemento e){
		this.textId.setText(String.valueOf(e.getIdElemento()));
		this.textNombre.setText(e.getNombreElemento());
	}
	
	private Elemento mapearDeForm(){
		Elemento e=new Elemento();
		e.setNombreElemento(this.textNombre.getText());
		e.setIdElemento(Integer.parseInt(this.textId.getText()));
		return e;
	}
}
