package Callable;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class Procedure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
		//Driver
		Class.forName("com.mysql.jdbc.Driver");
		//Connection
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost/practice","root","root");
		//Statement
		CallableStatement cs=con.prepareCall("call UpdateALL(?,?)");
		
		//User Input
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter id and name:");
		int eid=Integer.parseInt(br.readLine());
		String nm=br.readLine();
		
		//Set placeholder
		cs.setInt(1, eid);
		cs.setString(2, nm);
		
		//Output
		int n =cs.executeUpdate();
		if(n>0)
		{
			System.out.println("Record Updated...");
		}else
		{
			System.out.println("Try again...");
		}
		
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
