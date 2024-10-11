package Prepared;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;


public class Insert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			//Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//Connection
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost/practice","root","root");
			
			//Statement
			PreparedStatement smt=con.prepareStatement("insert into student values(?,?,?)");
			
			//User input
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter id,name and dates:");
			int eid=Integer.parseInt(br.readLine());
			String nm=br.readLine();
			String dates=br.readLine();
			
			//set placeholder
			smt.setInt(1, eid);
			smt.setString(2, nm);
			smt.setString(3, dates);
			
			//Output
			int n=smt.executeUpdate();
			
			if(n>0)
			{
				System.out.println("Record inserted...");
			}else
			{
				System.out.println("Try again...");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
