package niru;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class intro1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					intro1 window = new intro1();
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
	public intro1() {
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
		
		JLabel lblNewLabel = new JLabel(new ImageIcon("C:\\Users\\Admin\\eclipic\\slr1.png"));
		lblNewLabel.setBounds(430, 334, 327, 111);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon("C:\\Users\\Admin\\eclipic\\slr2.png"));
		lblNewLabel_1.setBounds(10, 11, 279, 185);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("NEXT");
		btnNewButton.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 15));
		btnNewButton.setBounds(737, 456, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("SIMPLE LINEAR REGRESSION");
		lblNewLabel_2.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblNewLabel_2.setBounds(477, 36, 257, 37);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("IMPLEMENATATION IN JAVA");
		lblNewLabel_3.setFont(new Font("Sitka Display", Font.BOLD, 14));
		lblNewLabel_3.setBounds(498, 72, 226, 23);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(new ImageIcon("C:\\Users\\Admin\\eclipic\\def1.png"));
		lblNewLabel_4.setBounds(173, 203, 342, 120);
		frame.getContentPane().add(lblNewLabel_4);
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				main1.main(null);
			}});
		
		
	}
}
