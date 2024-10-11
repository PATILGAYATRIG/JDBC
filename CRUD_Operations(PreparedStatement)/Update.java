package Prepared;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Update {

	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			try
			{
				//Driver
				Class.forName("com.mysql.jdbc.Driver");
				
				//Connection
				Connection con =DriverManager.getConnection("jdbc:mysql://localhost/practice","root","root");
				
				//Statement
				PreparedStatement smt=con.prepareStatement("update student set name=? where id=?");
				
				//User input
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter name and id ");
				String nm=br.readLine();
				int eid=Integer.parseInt(br.readLine());
				
				
				
				//set placeholder
				smt.setString(1, nm);
				smt.setInt(2, eid);
				
				
				//Output
				int n=smt.executeUpdate();
				
				if(n>0)
				{
					System.out.println("Record Updated...");
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


