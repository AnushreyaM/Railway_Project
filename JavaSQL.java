import java.util.*;
import java.sql.*;

class JavaSQL
{
	public static ResultSet executeSQL(String SQLQuery)
	{  
		try
		{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Railway?useSSL=false", "root", "aaknokia5233");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery(SQLQuery);  

			//con.close();  
			return rs;
		}
		catch(Exception e)
		{ 
			System.out.println(e);  
		}
		return null;
	}  

	public static void executeSQLUpdate(String SQLQuery)
	{  
		try
		{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Railway?useSSL=false", "root", "aaknokia5233");  
			Statement stmt = con.createStatement();  
			int res = stmt.executeUpdate(SQLQuery);  
			System.out.println(res);

			//con.close();  
		}
		catch(Exception e)
		{ 
			System.out.println(e);  
		}
	}  
}
