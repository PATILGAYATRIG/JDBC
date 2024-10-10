package jdbc;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class update {

	public static void main(String[] args) {
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost/practice","root","root");
		//Create statement
		Statement smt =con.createStatement();
		//user input
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter name and id:");
		int eid=Integer.parseInt(br.readLine());
		String nm=br.readLine();
		
		//Query
		String sql=("update student set name='"+nm+"' where id="+eid);
		System.out.println(sql);
		
		//Output
		int n=smt.executeUpdate(sql);
		
		if(n>0)
		{
			System.out.println("Record updated...");
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
