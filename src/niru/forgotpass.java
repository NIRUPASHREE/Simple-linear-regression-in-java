package niru;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class forgotpass {

	private JFrame frame;
	private JTextField t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					forgotpass window = new forgotpass();
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
	public forgotpass() {
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
		
		JLabel lblNewLabel = new JLabel("SECURITY QUESTION");
		lblNewLabel.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 21));
		lblNewLabel.setBounds(188, 21, 161, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Which is your favorite colour??");
		lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(54, 93, 268, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		t1 = new JTextField();
		t1.setBounds(54, 133, 86, 20);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setFont(new Font("Sitka Subheading", Font.PLAIN, 14));
		btnSubmit.setBounds(399, 179, 89, 23);
		frame.getContentPane().add(btnSubmit);
		btnSubmit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					String s1 =t1.getText();
					
					if(s1.equals("red")){
						fp1.main(null);	
					}
					else {
						fp2.main(null);	
					}
				}});
	}
}
