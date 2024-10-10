package jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Delete {

	public static void main(String[] args) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost/practice","root","root");
			//Create statement
			Statement smt =con.createStatement();
			//user input
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter  id:");
			int eid=Integer.parseInt(br.readLine());
			
			
			//Query
			String sql=("delete from student where id="+eid);
			System.out.println(sql);
			
			//Output
			int n=smt.executeUpdate(sql);
			
			if(n>0)
			{
				System.out.println("Record deleted...");
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
