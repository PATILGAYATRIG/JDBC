package Callable;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
public class ResultsetInterface {

	public static void main(String[] args) {
		try
		{
			//Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//Establish Connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/practice","root","root");
			
			
			//create statement
			Statement smt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			//QUERY
			String sql="Select *from student";
			ResultSet re=smt.executeQuery(sql);
			
			//Input
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter your ID and updatable name:");
			int eid=Integer.parseInt(br.readLine());
	     
			String nm=br.readLine();
			   
			while(re.next())
			{
				if(re.getInt("id")==eid)
				{
					re.updateString("name", nm);
				
				
				}
				re.updateRow();//commit to update
				System.out.println(re.getInt("id")+"\t"+re.getString("name")+"\t"+re.getString("j_date"));
				
				
			}
		}
		catch(Exception e)
		{
			System.out.print(e);
			e.printStackTrace();
		}
	}

	

}
