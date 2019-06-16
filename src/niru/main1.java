package niru;
import java.math.*;
import java.awt.EventQueue;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class main1 {

	private JFrame frame;
	private JTable table;
	private JTable table_1;
	ResultSet rs;
	JTextField tiq;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main1 window = new main1();
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
	public main1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		try
		{
		//Accessing the driver from the jar file
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb","root", "");
		//testdb-database,root-user,blank after root is the password(blank coz no password);
		System.out.println("Database is connected !");
		//query below
		PreparedStatement statement=conn.prepareStatement("select * from iqperformace");
		//creating a variable to execute query
		//Storing into an Array List
		rs=statement.executeQuery();
		}
		catch(Exception e)
		{
		System.out.print("Do not connect to DB - Error:"+e);
		}
		
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(22, 33, 788, 420);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		tabbedPane.addTab("DATA", null, panel, null);
		panel.setLayout(null);
		
		JButton bnload = new JButton("LOAD DATASET FROM DATABSE");
		bnload.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 12));
		bnload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
				}
				
				catch(Exception e)
				{
				e.printStackTrace();
				}
			}
		});
		bnload.setBounds(116, 84, 292, 23);
		panel.add(bnload);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(116, 131, 519, 167);
		panel.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		JButton bnsplot = new JButton("CLICK HERE TO SCATTER-PLOT THE POINTS");
		bnsplot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					JPanel panel_1 = new lineChart();
					tabbedPane.addTab("SCATTER-PLOT", null, panel_1, null);

				}
				
				catch(Exception e)
				{
				e.printStackTrace();
				}
			}
		});
		bnsplot.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 12));
		bnsplot.setBounds(424, 335, 315, 23);
		panel.add(bnsplot);
		
		JLabel lblNewLabel = new JLabel("Can we predict job performance from IQ scores?");
		lblNewLabel.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 14));
		lblNewLabel.setBounds(48, 11, 326, 29);
		panel.add(lblNewLabel);
		
		Lrh lr = new Lrh();
		JPanel panel_4 = lr;
		tabbedPane.addTab("LINEAR-REGRESSION", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lb20 = new JLabel("SIMPLE LINEAR REGRESSION ");
		lb20.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 14));
		lb20.setBounds(249, 26, 191, 28);
		panel_4.add(lb20);
		
		JLabel lb21 = new JLabel();
		lb21.setBounds(207, 92, 152, 14);
		panel_4.add(lb21);
		String x0=Double.toString(round(lr.a1,2));
		lb21.setText(x0);
		
		JLabel lb22 = new JLabel("New label");
		lb22.setBounds(207, 138, 152, 14);
		panel_4.add(lb22);
		String x1=Double.toString(round(lr.a0,2));
		lb22.setText(x1);
		JLabel lb23 = new JLabel("New label");
		lb23.setBounds(207, 185, 214, 14);
		panel_4.add(lb23);
		lb23.setText("y="+x0+"x"+"+"+x1);
		
		JLabel lblNewLabel_1 = new JLabel("CO-EFFICIENT:");
		lblNewLabel_1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(75, 90, 122, 14);
		panel_4.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("INTERCEPT:");
		lblNewLabel_2.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(75, 136, 85, 14);
		panel_4.add(lblNewLabel_2);
		
		JLabel lblLineEquation = new JLabel("LINE EQUATION:");
		lblLineEquation.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 14));
		lblLineEquation.setBounds(75, 183, 100, 14);
		panel_4.add(lblLineEquation);
		
		JPanel panel_3 = new JPanel();
		//LRhypox1(x1,x2);
		tabbedPane.addTab("TEST", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel l11 = new JLabel("TO PREDICT NEW PERFORMANCE VALUE");
		l11.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 14));
		l11.setBounds(109, 39, 402, 36);
		panel_3.add(l11);
		
		JLabel L12 = new JLabel("ENTER IQ:");
		L12.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		L12.setBounds(56, 102, 85, 24);
		panel_3.add(L12);
		
		tiq = new JTextField();
		tiq.setBounds(173, 104, 86, 20);
		panel_3.add(tiq);
		tiq.setColumns(10);
		//String s1 = tiq.getText();
		//int iq1 =  Integer.parseInt(s1);
		JLabel l13 = new JLabel("CORRESPONDING PERFORMANCE VALUE WOULD BE:");
		l13.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		l13.setBounds(56, 235, 308, 43);
		panel_3.add(l13);
		
		JLabel lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setBounds(428, 249, 97, 14);
		panel_3.add(lblNewLabel_3);

		
		JLabel lblNewLabel_4 = new JLabel("ACCORDING TO R-SQUARE VALUE PREDICTION IS 41% ACCURATE!!");
		lblNewLabel_4.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(56, 314, 402, 24);
		panel_3.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("CHECK PERFORMANCE !!");
		btnNewButton.setBounds(142, 171, 189, 23);
		panel_3.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					String iqtest = tiq.getText();
					int iqt = Integer.parseInt(iqtest);
					double iq2= ((iqt*0.64)+34.26);
					String s2 = Double.toString(iq2);
					lblNewLabel_3.setText(s2);

				}
				
				catch(Exception e)
				{
				e.printStackTrace();
				}
			}
		});
	}
	private double round(double d, int i) {
		// TODO Auto-generated method stub
		if(i<0) throw new IllegalArgumentException();
		BigDecimal bd = new BigDecimal(d);
		bd = bd.setScale(i, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
		
	}

