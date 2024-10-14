package Callable;
import java.sql.*;

public class ResultMetadata {

	public static void main(String[] args) {
try
{
	//Driver
	Class.forName("com.mysql.jdbc.Driver");
	//Connection 
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost/practice","root","root");
	
	//Statement
	Statement smt=con.createStatement();
	ResultSet rs=smt.executeQuery("select *from student");
	
	//The ResultSetMetaData interface provides methods to get metadata about the columns of a ResultSet object
	ResultSetMetaData md=rs.getMetaData();
	System.out.println(md.getColumnCount());
	System.out.println(md.getColumnTypeName(1));
	System.out.println(md.getColumnName(2));
	System.out.println("******************************************************");
	
	//DatabaseMetaData interface provides method(connection object) to get meta data about database such as product name,driver name,database version etc 
	DatabaseMetaData ms=con.getMetaData();
	System.out.println(ms.getDriverName());
	System.out.println(ms.getDatabaseProductName());
	System.out.println(ms.getDriverMajorVersion());
	

	
}

catch(Exception e)
{
	
}

		

	}

}
