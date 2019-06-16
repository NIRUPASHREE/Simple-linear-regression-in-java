package niru;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class fp1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fp1 window = new fp1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public fp1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 549, 275);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblThePasswordIs = new JLabel("THE PASSWORD IS :  admin123");
		lblThePasswordIs.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 14));
		lblThePasswordIs.setBounds(62, 39, 223, 30);
		frame.getContentPane().add(lblThePasswordIs);
		
		JButton btnLoginPage = new JButton("LOGIN PAGE");
		btnLoginPage.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 14));
		btnLoginPage.setBounds(262, 149, 114, 23);
		frame.getContentPane().add(btnLoginPage);
		
		btnLoginPage.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					login1.main(null);	
				}});
	}
}
