package Callable;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

class Account
{
	float bal;
	String name;
	public Account(float bal, String name) {
		super();
		this.bal = bal;
		this.name = name;
	}
	//Connection method
	public static Connection getCon() throws Exception
	{
		//Driver
		Class.forName("com.mysql.jdbc.Driver");
		//Connection establish
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/practice","root","root");
	
		con.setAutoCommit(false);
		return con;
	}
	public void withAmt(float amt) throws Exception
	{
		
		
		if(amt < bal)
		{
			String sql="update Bank set  account_balance =? where  customer_name =?";
			Connection con=getCon();
			//statement
			PreparedStatement ps =con.prepareStatement(sql);
			bal=bal-amt;
			//set placeholder;
			ps.setFloat(1,bal);
			ps.setString(2,name);
			
			
		
			
			//execute Query
			int n=ps.executeUpdate();
			if(n>0)
			{
				//commit now true
				con.commit();
				System.out.println("Remaining balance:"+bal);
			}
			else
			{
				System.out.println("Transction fail....");
			}
	
		}
		else
		{
			System.out.println("Can't withdraw maney !!!");
		}
		
		
	}
	
	
}
public class TransactionManagement {

	public static void main(String[] args) throws Exception {
			Connection con=Account.getCon();
			//Input
			BufferedReader bd=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Customer name:");
			String nm=bd.readLine();
			//Statement
			PreparedStatement ps=con.prepareStatement("select  account_balance  from Bank where  customer_name =?");
			//setMethod
			ps.setString(1, nm);
		
			ResultSet rs =ps.executeQuery();
			if(rs.next())
			{
				System.out.println("Enter Withdraw amount:");
				float at=Float.parseFloat(bd.readLine());
				Account a1= new Account(rs.getFloat("account_balance"),nm);// Remember Get method 
				a1.withAmt(at);
			}
			else
			{
				System.out.println("Please enter valid customer name");
				
			
		}
	
		
	}

}
