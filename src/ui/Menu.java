package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { menu frame = new menu();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 * }); }
	 */

	/**
	 * Create the frame.
	 */
	public Menu() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("ABMCElemento");
		btnNewButton.setBounds(165, 78, 140, 23);
		contentPane.add(btnNewButton);

		JButton btnAbmctipoelemento = new JButton("ABMCTipoElemento");
		btnAbmctipoelemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ABMCTipo ti = new ABMCTipo();
				ti.setVisible(true);
				
			}
		});
		btnAbmctipoelemento.setBounds(165, 131, 140, 23);
		contentPane.add(btnAbmctipoelemento);

		JButton btnAbmcpersona = new JButton("ABMCPersona");
		btnAbmcpersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ABMCPersona pe = new ABMCPersona();
				pe.setVisible(true);
				
			}
		});
		btnAbmcpersona.setBounds(165, 27, 140, 23);
		contentPane.add(btnAbmcpersona);

		JButton btnNewButton_1 = new JButton("ABMCReserva");
		btnNewButton_1.setBounds(165, 186, 140, 23);
		contentPane.add(btnNewButton_1);
	}
}
