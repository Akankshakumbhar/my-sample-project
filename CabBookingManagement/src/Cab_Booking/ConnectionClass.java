package Cab_Booking;
import java.sql.*;
public class ConnectionClass
{
	Connection con;
	Statement stm;
	ConnectionClass()
	{
		try
		{
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql:cab_management","postgres","");
			stm=con.createStatement();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public static void main(String args[])
	{
		new ConnectionClass();
	}
}