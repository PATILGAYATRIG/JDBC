package Prepared;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
public class Delete {

	public static void main(String[] args) {
		try
		{
			//Driver
			Class.forName("com.mysql.jdbc.Driver");
			//Connection establish
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/practice","root","root");
			//Statement 
			PreparedStatement smt=con.prepareCall("delete from student where id=?");
			
			//User Input
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter your id:");
			int eid=Integer.parseInt(br.readLine());
			
			//setPlaceHolder
			smt.setInt(1,eid);
			
			//Output
			int n=smt.executeUpdate();
			
			if(n>0)
			{
				System.out.println("Record Deleted...");
			}else
			{
				System.out.println("Try again...");
			}
		}
	catch(Exception e)
		{
		e.printStackTrace();		}
	}

}
