package Cab_Booking;

import java.awt.*;
import javax.swing.*;

public class About extends JFrame 
{
	JLabel id;
   public About() {
      setTitle("About My Application");
      setSize(400, 300);
      setLocationRelativeTo(null);
      setLayout(new BorderLayout());

      // Add content to the about page
      JLabel titleLabel = new JLabel("My Application");
      titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
      titleLabel.setHorizontalAlignment(JLabel.CENTER);

      JLabel versionLabel = new JLabel("Version 1.0");
      versionLabel.setFont(new Font("Sans-serif", Font.PLAIN, 14));
      versionLabel.setHorizontalAlignment(JLabel.CENTER);

      JLabel developerLabel = new JLabel("Developed by Akanksha and Divya");
      developerLabel.setFont(new Font("Sans-serif", Font.PLAIN, 14));
      developerLabel.setHorizontalAlignment(JLabel.CENTER);

      JPanel contentPanel = new JPanel();
      contentPanel.setLayout(new GridLayout(3, 1));
      contentPanel.add(titleLabel);
      contentPanel.add(versionLabel);
      contentPanel.add(developerLabel);
      
      id=new JLabel();
      ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("Cab_Booking/Icons2/AddCustomer.jpg"));
      Image img=ic.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
      ImageIcon icl=new ImageIcon(img);
      id.setIcon(icl);
      

      //Add OK button
      JButton okButton = new JButton("OK");
      okButton.addActionListener(e -> dispose());

      // Add content and OK button to the about page
      add(contentPanel, BorderLayout.CENTER);
      add(okButton, BorderLayout.SOUTH);

      setVisible(true);
   }

   public static void main(String[] args) {
      About aboutPage = new About();
   }
}

	

