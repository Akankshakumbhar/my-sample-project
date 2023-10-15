package Cab_Booking;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java. sql.*;

public class AdminHomePage extends JFrame implements ActionListener
{
JLabel l1,l2;
JButton bt1,bt2,bt4,bt3,bt5;
JPanel p1,p2;
Font f,f1;


AdminHomePage()
{
super("Admin Home Page");
setLocation(450,250);
setSize(400,270);
       
        f=new Font("Arial",Font.BOLD,20);
        f1=new Font("Arial",Font.BOLD,20);
       
        l1=new JLabel("Admin Home Page");
        bt1=new JButton("Intercity Driver");
        bt2=new JButton("view customer Details");
        bt3=new JButton(" View Intercity Booked Cab");
        bt5=new JButton("Update Customer");
        bt4=new JButton("SignUp");
       
       
       l1.setHorizontalAlignment(JLabel.CENTER);
       
       
       
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        bt4.addActionListener(this);
        bt5.addActionListener(this);
       
       l1.setFont(f);
       bt1.setFont(f1);
       bt2.setFont(f1);
       bt3.setFont(f1);
       bt4.setFont(f1);
       bt5.setFont(f1);
       
       
       p1=new JPanel();
       p1.setLayout(new GridLayout(6,1,10,10));
       p1.add(l1);
       p1.add(bt1);
       p1.add(bt2);
       p1.add(bt3);
       p1.add(bt4);
       p1.add(bt5);
       
       setLayout(new BorderLayout(10,10));
       add(p1,"Center");
       
}

        @Override
        public void actionPerformed(ActionEvent e)
{
if(e.getSource()==bt1)
{
    new Add_Intercity_Driver().setVisible(true);
    this.setVisible(false);
   
   
}
if(e.getSource()==bt2)
{
   new View_Customer().setVisible(true);
    this.setVisible(false);
     
}
if(e.getSource()==bt3)
{
	new  View_Intercity_Booked_Cab().setVisible(true);
	this.setVisible(false);
}
if(e.getSource()==bt5)
{
    new Update_Customer().setVisible(true);
    this.setVisible(false);
   
   
}

if(e.getSource()==bt4)
{
    new SignUp().setVisible(true);
    this.setVisible(false);
   
}

}
public static void main(String args[])
{
new AdminHomePage().setVisible(true);

}
}

	
