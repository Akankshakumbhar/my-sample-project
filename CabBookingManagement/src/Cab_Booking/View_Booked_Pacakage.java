package Cab_Booking;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class View_Booked_Pacakage extends JFrame
{
	Font f;
	JTable t1;
	String x[]= {"Book Id","Username","Name","Driver Name","Source","Destination","Weight","Truck","Distance","Price"};
	String y[][]=new String [20][10];
	int i=0,j=0;
	
	View_Booked_Pacakage()
	{
		super("All Booked Truck Records");
		setSize(1300,400);
		setLocation(0,10);
		f=new Font("MS UI Gothic",Font.BOLD,17);
		
		try
		{
			ConnectionClass obj=new ConnectionClass();
			String q="select*from intransport";
			ResultSet rs=obj.stm.executeQuery(q);
			while(rs.next())
			{
				y[i][j++]=rs.getString("BookdId");
				y[i][j++]=rs.getString("Username");
				y[i][j++]=rs.getString("name");
				y[i][j++]=rs.getString("drivername");
				y[i][j++]=rs.getString("source");
				y[i][j++]=rs.getString("destination");
				y[i][j++]=rs.getString("weight");
				y[i][j++]=rs.getString("truck");
				y[i][j++]=rs.getString("distance");
				y[i][j++]=rs.getString("price");
				i++;
				j=0;
			}
			t1=new JTable(y,x);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		t1.setFont(f);
		t1.setBackground(Color.BLACK);
		t1.setForeground(Color.WHITE);
		JScrollPane js=new JScrollPane(t1);
		add(js);
		
	}
	public static void main(String args[])
	{
		new View_Booked_Pacakage().setVisible(true);
	}

}
