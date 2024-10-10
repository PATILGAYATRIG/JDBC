package jdbc;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
public class Insert {

	public static void main(String[] args) {
try
{
	//Driver
	Class.forName("com.mysql.jdbc.Driver");
	//Connection
	Connection con =DriverManager.getConnection("jdbc:mysql://localhost/practice","root","root");
	//Statement
	Statement smt=con.createStatement();
	//user input
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter id,name,date");
	int eid=Integer.parseInt(br.readLine());
	String nm=br.readLine();
	String dates=br.readLine();
	
	//Execute
	String sql="insert into student values("+eid+",'"+nm+"','"+dates+"')";
	System.out.println(sql);
	
	//Output
	int n=smt.executeUpdate(sql);
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
