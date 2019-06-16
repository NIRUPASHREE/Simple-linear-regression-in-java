package niru;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
class login implements ActionListener{
JTextField t1,t2;
JLabel l1,l2,l3,l4;
JPasswordField s;

login(){
JFrame f1 = new JFrame("LOGIN PAGE");
f1.setVisible(true);
f1.setLayout(null);
f1.setSize(900, 550);
f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f1.add(new JLabel(new ImageIcon("C:\\Users\\Admin\\Pictures\nhrt.jpg")));

l1= new JLabel("LOGIN");
f1.add(l1);
l1.setBounds(100, 50, 200, 20);
l2= new JLabel("User_id");
f1.add(l2);
l2.setBounds(50,100,100, 20);
t1 =new JTextField();
f1.add(t1);
t1.setBounds(150, 100, 100, 20);
l3= new JLabel("Password");
f1.add(l3);
l3.setBounds(50,150,100, 20);
s = new JPasswordField();
s.setBounds(150, 150, 100, 20);
f1.add(s);
t2 =new JTextField();
f1.add(t2);
t2.setBounds(150, 150, 100, 20);
JButton b1 =new JButton("Submit");
f1.add(b1);
b1.setBounds(200, 200, 100, 20);
b1.addActionListener(this);

l4= new JLabel();
f1.add(l4);
l4.setBounds(150,300,100, 20);

}
public void actionPerformed(ActionEvent e){
String s1 =t1.getText();
String s2 =s.getText();
if(s1.equals("333") && s2.equals("niru"))
l4.setText("valid");
else
l4.setText("Invalid");

}
}

public class Logat{

	public static void main(String[] args) {
		new login();

	}

}

