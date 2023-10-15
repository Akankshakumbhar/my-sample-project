package Cab_Booking;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class View_Driver_details extends JFrame 
{
	Font f;
	JTable t1;
	String x[]= {"driver","source","destination","car","price","type"};
	String y[][]=new String[20][10];
	int i=0,j=0;
	
	View_Driver_details()
	{
	super("All Driver details");
	setSize(1300,400);
	setLocation(0,10);
	f=new Font("Arial",Font.BOLD,17);
	try
	{
		ConnectionClass obj=new ConnectionClass();
		String q="select*from intercity_driver";
		ResultSet rs=obj.stm.executeQuery(q);
		while(rs.next())
		{
			y[i][j++]=rs.getString("driver");
			y[i][j++]=rs.getString("source");
			y[i][j++]=rs.getString("destination");
			y[i][j++]=rs.getString("car");
			y[i][j++]=rs.getString("price");
			y[i][j++]=rs.getString("type");
			//y[i][j++]=rs.getString("email");
			//y[i][j++]=rs.getString("country");
			//y[i][j++]=rs.getString("gender");
			//y[i][j++]=rs.getString("adhar");
			i++;
			j=0;
			
		}
		t1=new JTable(y,x);
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
	}
	t1.setFont(f);
	t1.setBackground(Color.BLACK);
	t1.setForeground(Color.WHITE);
	JScrollPane js=new JScrollPane(t1);
	add(js);
	
	}
	
	
	public static void main(String args[])
	{
		new View_Driver_details().setVisible(true);
	}
}
