package Cab_Booking;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class Book_Cab extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	JButton b1,b2;
	JPanel p1,p2,p3;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9;
	Font f,f1;
	Choice ch1,ch2,ch3;
	
	Book_Cab()
	{
		super("Book Intracity Cab");
		setLocation(50,10);
		setSize(1100,700);
		
		f=new Font("Arial",Font.BOLD,25);
		f1=new Font("Arial",Font.BOLD,18);
		
		ch1=new Choice();
		ch2=new Choice();
		ch3=new Choice();
		
		try
		{
			ConnectionClass obj=new ConnectionClass();
			String q="select source from intracity_driver";
			ResultSet rest=obj.stm.executeQuery(q);
			while(rest.next())
			{
				ch1.add(rest.getString("source"));
			}
			rest.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		try
		{
			ConnectionClass obj=new ConnectionClass();
			String q="select username from customer";
			ResultSet rest=obj.stm.executeQuery(q);
			while(rest.next())
			{
				ch3.add(rest.getString("username"));
			}
			rest.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		l1=new JLabel("Book Intracity cab");
		l2=new JLabel("Book Id");
		l3=new JLabel("Source");
		l4=new JLabel("Destination");
		l5=new JLabel("Username");
		l6=new JLabel("Name");
		l7=new JLabel("Driver Name");
		l8=new JLabel("Car");
		l9=new JLabel("Destination from");
		l10=new JLabel("Destination to");
		l11=new JLabel("Price");
		
		l1.setHorizontalAlignment(JLabel.CENTER);
		tf1=new JTextField();
		tf3=new JTextField();
		tf4=new JTextField();
		tf5=new JTextField();
		tf6=new JTextField();
		tf7=new JTextField();
		tf8=new JTextField();
		
		tf1.setEditable(false);
		tf3.setEditable(false);
		tf4.setEditable(false);
		tf5.setEditable(false);
		tf6.setEditable(false);
		tf7.setEditable(false);
		tf8.setEditable(false);
		
		b1=new JButton("Book Cab");
		b2=new JButton("Back");
		
		
		
		b1.setBackground(Color.YELLOW);
		b2.setBackground(Color.RED);
		
		b1.setForeground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		
		Random rm=new Random();
		tf1.setText(""+Math.abs(rm.nextInt() %10000));
		tf1.setForeground(Color.RED);
		
		l1.setFont(f);
		l2.setFont(f1);
		l3.setFont(f1);
		l4.setFont(f1);
		l5.setFont(f1);
		l6.setFont(f1);
		l7.setFont(f1);
		l8.setFont(f1);
		l9.setFont(f1);
		l10.setFont(f1);
		l11.setFont(f1);
		ch1.setFont(f1);
		ch2.setFont(f1);
		ch3.setFont(f1);
		
		tf1.setFont(f1);
		tf3.setFont(f1);
		tf4.setFont(f1);
		tf5.setFont(f1);
		tf6.setFont(f1);
		tf7.setFont(f1);
		tf8.setFont(f1);
		
		b1.setFont(f1);
		b2.setFont(f1);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		p1=new JPanel();
		p1.setLayout(new GridLayout(1,1,10,10));
		p1.add(l1);
		
		p2=new JPanel();
		p2.setLayout(new GridLayout(11,2,10,10));
		
		p2.add(l2);
		p2.add(tf1);
		p2.add(l3);
		p2.add(ch1);
		p2.add(l4);
		p2.add(ch2);
		p2.add(l5);
		p2.add(ch3);
		p2.add(l6);
		p2.add(tf3);
		p2.add(l7);
		p2.add(tf4);
		p2.add(l8);
		p2.add(tf5);
		p2.add(l9);
		p2.add(tf6);
		p2.add(l10);
		p2.add(tf7);
		p2.add(l11);
		p2.add(tf8);
		p2.add(b1);
		p2.add(b2);
		
		ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("Cab_Booking/Icons2/book_intracity.jpg"));
		Image img=ic.getImage().getScaledInstance(200,500,Image.SCALE_DEFAULT);
		ImageIcon ic1=new ImageIcon(img);
		l12=new JLabel(ic1);
		
		p3=new JPanel();
		p3.setLayout(new GridLayout(1,1,10,10));
		p3.add(l12);
		
		setLayout(new BorderLayout(10,10));
    	add(p1,"North");
		add(p2,"Center");
		add(p3,"West");
		
		ch3.addMouseListener(new MouseAdapter()
				{
		
		          	@Override
			public void mouseClicked(MouseEvent arg0)
			{
				try
				{
					ConnectionClass obj=new ConnectionClass();
					String username=ch3.getSelectedItem();
					String q1="select name from customer where username='"+username+"'";
					ResultSet rest1=obj.stm.executeQuery(q1);
					while(rest1.next())
					{
						tf3.setText(rest1.getString("name"));
					}
					rest1.close();
				}
				catch(Exception exx)
				{
					exx.printStackTrace();
				}
			}
				});	
	
	ch1.addMouseListener(new MouseAdapter()
			{
		@Override
		public void mouseClicked(MouseEvent arg0)
		{
			ch2.removeAll();
			try
			{
				ConnectionClass obj=new ConnectionClass();
				String source=ch1.getSelectedItem();
				String q1="select destination from intracity_driver where source='"+source+"'";
				ResultSet rest1=obj.stm.executeQuery(q1);
				while(rest1.next())
				{
					ch2.add(rest1.getString("destination"));
				}
			}
			catch(Exception exx)
			{
				exx.printStackTrace();
			}
		}
			});
	
	ch2.addMouseListener(new MouseAdapter()
	{
@Override
public void mouseClicked(MouseEvent arg0)
{
	try
	{
		ConnectionClass obj=new ConnectionClass();
		String source=ch1.getSelectedItem();
		String destination=ch2.getSelectedItem();
		String q1="select* from intracity_driver where source='"+source+"' and destination='"+destination+"'";
		ResultSet rest1=obj.stm.executeQuery(q1);
		while(rest1.next())
		{
			tf4.setText(rest1.getString("driver"));
			tf5.setText(rest1.getString("car"));
			tf6.setText(rest1.getString("source"));
			tf7.setText(rest1.getString("destination"));
			tf8.setText(rest1.getString("price"));
		}
	}
	catch(Exception exx)
	{
		exx.printStackTrace();
	}
}
	});
	}
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource()==b1)
		{
			String bid=tf1.getText();
			String username=ch3.getSelectedItem();
			String dname=tf4.getText();
			String car=tf5.getText();
			String source=tf6.getText();
			String destination=tf7.getText();
			String price=tf8.getText();
			
			try
			{
				ConnectionClass obj=new ConnectionClass();
				String q="insert into intracitycab values('"+bid+"','"+username+"','"+dname+"','"+car+"','"+source+"','"+destination+"',"+price+"')";
				int aa=obj.stm.executeUpdate(q);
				if(aa==1)
				{
					JOptionPane.showMessageDialog(null,"cab Booked Sucessfully!");
					this.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Please,Fill all your details Carefully!");
				}
			}		  
			catch(Exception ee)
			{
				ee.printStackTrace();
			}
	    
		}
		if(e.getSource()==b2)
		{
			this.setVisible(false);
			
		}	
	}
	
	public static void main(String args[])
	{
		new  Book_Cab().setVisible(true);
	}
}
