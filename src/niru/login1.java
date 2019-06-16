package niru;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;

public class login1 {

	private JFrame frame;
	private JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login1 window = new login1();
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
	public login1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lpic = new JLabel(new ImageIcon("C:\\Users\\Admin\\eclipic\\login.png"));
		lpic.setBounds(337, 11, 537, 489);
		frame.getContentPane().add(lpic);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon("C:\\Users\\Admin\\eclipic\\login2.png"));
		lblNewLabel.setBounds(42, 11, 214, 200);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 14));
		lblUsername.setBounds(34, 266, 64, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(34, 318, 64, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		user = new JTextField();
		user.setBounds(134, 265, 121, 20);
		frame.getContentPane().add(user);
		user.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(134, 317, 122, 20);
		frame.getContentPane().add(pass);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 14));
		btnNewButton.setBounds(177, 392, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Forgot password");
		btnNewButton_1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 14));
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setBounds(34, 447, 140, 23);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
				forgotpass.main(null);	
			}});
		
		
		btnNewButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
				String s1 =user.getText();
				String s2 =pass.getText();
				if(s1.equals("admin") && s2.equals("admin123")) {
				intro1.main(null);
				}
				else {
				logerror.main(null);	
				}
			}});
	}
}
