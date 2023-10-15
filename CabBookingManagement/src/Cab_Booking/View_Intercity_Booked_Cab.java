package Cab_Booking;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class View_Intercity_Booked_Cab extends JFrame
{
	Font f;
	JTable t1;
	String x[]= {"Book Id","Username","name","Driver Name","source","destination","type","car","price"};
	String y[][]=new String [20][9];
	int i=0,j=0;
	
	 View_Intercity_Booked_Cab()
	{
		super("All Intercity  Booked Cab Records");
		setSize(1300,400);
		setLocation(0,10);
		f=new Font("MS UI Gothic",Font.BOLD,17);
		
		try
		{
			ConnectionClass obj=new ConnectionClass();
			String q="select*from intercitycab";
			ResultSet rs=obj.stm.executeQuery(q);
			while(rs.next())
			{
				y[i][j++]=rs.getString("BookId");
				y[i][j++]=rs.getString("Username");
				y[i][j++]=rs.getString("name");
				y[i][j++]=rs.getString("Drivername");
				y[i][j++]=rs.getString("source");
				y[i][j++]=rs.getString("destination");
				y[i][j++]=rs.getString("type");
				y[i][j++]=rs.getString("Car");
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
		new View_Intercity_Booked_Cab().setVisible(true);
	}

}
