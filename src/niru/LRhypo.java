package niru;
import java.math.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.sql.*;

class Lrh extends JPanel{
	public int n=10,i;
	public double sumx=0, sumxsq=0, sumy=0, sumz=0 ,sumxy=0,a0=0, a1=0, denom=0;
	//int[] x = {106,97,108,96,112,111,97,99,87,91};
	//int[] y = {115,104,98,101,98,106,95,98,87,86};
	public double[] y1 = new double[n];
	public double[] z = new double[n];
	public double ymean=0, zmean=0, yvar=0, zvar=0, variancey=0,variancez=0,rsq=0;
	public DecimalFormat df = new DecimalFormat("###.##");				//to print in decimal format
	public ArrayList ar=new ArrayList();
	public ArrayList<Integer> ax=new ArrayList<Integer>();
	public ArrayList<Integer> ay=new ArrayList<Integer>();
	public Integer[] x;
	public Integer[] y;
	 Lrh() {
	
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
	ResultSet rs=statement.executeQuery();

	while(rs.next())
	{
		String names=rs.getString(2);
		//System.out.println(names);
		ar.add(names);
		int xx = rs.getInt(3);
		ax.add(xx);
		int yy = rs.getInt(4);
		ay.add(yy);
	}
	//System.out.println(ar+"---"+ax+"---"+ay);
	//System.out.println(ar.get(0));
	}
	
	catch(Exception e)
	{
	System.out.print("Do not connect to DB - Error:"+e);
	}

	x=new Integer[ax.size()];
	y=new Integer[ay.size()];
	for(int s=0;s<ax.size();s++) {
	x[s]=ax.get(s);
	y[s]=ay.get(s);
	}
	
	
	//int[] y=convertToIntarray(ay);
	
	for(i = 0; i < n; i++)
	 {
	  sumx += x[i];
	  sumxsq +=Math.pow(x[i], 2);
	  sumy += y[i];
	  sumxy += x[i] * y[i];
	 }
	 denom = n * sumxsq - Math.pow(sumx, 2);
	 a0 = (sumy * sumxsq - sumx * sumxy) / denom; 		//intercept/constamt
	 a1 = (n * sumxy - sumx * sumy) / denom;			//co-efficient
	 System.out.println("co-efficient:" +a1);
	 System.out.println("intercept:"+a0);
	 
	 System.out.println("******LINEAR REGRESSION HYPOTHESIS*****");
	 System.out.println("y="+df.format(a1)+"x"+"+"+df.format(a0));
	
	 for(int j=0;j<n;j++) {								//prediction according to line
		y1[j]=round(((a1* x[j])+ a0),2); 
		//System.out.println(y1[j]);
	 }
	 
	for(int k=0;k<n;k++) {								//recidual/error
			z[k]=round((y[k]-y1[k]),2); 
			sumz=sumz+( z[k]);							//sum of it
			//System.out.println(z[k]+"**"+sumz);
	 }
	 ymean=sumy/10;										//to find r-square-->variance
	 zmean=sumz/10;
	 //System.out.println(ymean); 
	 //System.out.println(zmean);

	 for(int l=0;l<n;l++) {								//sum(x[i]-xmean)^2
		 yvar+=Math.pow((y[l]-ymean),2);
		 zvar+=Math.pow((z[l]-zmean),2);
	 }
	 yvar=round(yvar,2);
	 zvar=round(zvar,2);
	 //System.out.println(yvar+"**"+zvar);
	 variancey=round(yvar/(n-1),0);						//variance=yvar/n-1
	 variancez=round(zvar/(n-1),0);
	 System.out.println(variancey+"**"+variancez);
	 rsq=(variancey-variancez)/variancey;
	 System.out.println("R-SQUARE = "+df.format(rsq));
	 
}
	
	private double round(double d, int i) {
		// TODO Auto-generated method stub
		if(i<0) throw new IllegalArgumentException();
		BigDecimal bd = new BigDecimal(d);
		bd = bd.setScale(i, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
}
public class LRhypo {
	public static void main(String[] args) {
		Lrh l1 = new Lrh();
		//l1.find();

	}

}
