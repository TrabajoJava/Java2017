package ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDesktopPane;

public class Login extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setClosable(true);
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(221, 96, 1, 1);
		getContentPane().add(desktopPane);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ABMCPersonaDesktop ps= new ABMCPersonaDesktop();
				desktopPane.add(ps);
				ps.setVisible(true);
					
			}
		});
		btnIngresar.setBounds(43, 93, 89, 23);
		getContentPane().add(btnIngresar);
		
	
		
		

	}

}
