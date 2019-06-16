package niru;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class fp2 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fp2 window = new fp2();
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
	public fp2() {
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
		
		JLabel lblSorryYouAre = new JLabel("SORRY, YOU ARE WRONG !!");
		lblSorryYouAre.setForeground(Color.RED);
		lblSorryYouAre.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 14));
		lblSorryYouAre.setBounds(117, 60, 172, 20);
		frame.getContentPane().add(lblSorryYouAre);
		
		JButton btnTryAgain = new JButton("TRY AGAIN");
		btnTryAgain.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 14));
		btnTryAgain.setForeground(Color.BLUE);
		btnTryAgain.setBounds(251, 142, 110, 23);
		frame.getContentPane().add(btnTryAgain);
		
		btnTryAgain.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					forgotpass.main(null);	
				}});
	}

}
