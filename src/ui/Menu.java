package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;

	public Menu() {
		setTitle("Menu");
		setDefaultCloseOperation(JInternalFrame.WHEN_IN_FOCUSED_WINDOW);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAbmcelemento = new JButton("ABMCElemento");
		btnAbmcelemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ABMCElemento el = new ABMCElemento();
				el.setVisible(true);
				
			}
		});
		btnAbmcelemento.setBounds(165, 78, 140, 23);
		contentPane.add(btnAbmcelemento);

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

		JButton btnAbmcreserva = new JButton("ABMCReserva");
		btnAbmcreserva.setBounds(165, 186, 140, 23);
		contentPane.add(btnAbmcreserva);
	}
}
