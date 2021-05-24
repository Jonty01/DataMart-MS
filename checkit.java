package DataM;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;


public class checkit extends JFrame implements ActionListener{
    JLabel l1;
    JButton b1,b2;

    checkit(){
        setTitle("DATAMART MANAGEMENT SYSTEM");
        
        // ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/logo.jpg"));
        // Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        // ImageIcon i3 = new ImageIcon(i2);
        // JLabel l11 = new JLabel(i3);
        // l11.setBounds(70, 10, 100, 100);
        // add(l11);
        
        l1 = new JLabel("Click USER If Signining In as User or Else Click RETAILER");
        l1.setFont(new Font("Osward", Font.BOLD, 16));
        l1.setBounds(75,30,450,40);
        add(l1);
        
        b1 = new JButton("USER");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2 = new JButton("RETAILER");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        setLayout(null);
        
        b1.setFont(new Font("Arial", Font.BOLD, 8));
        b1.setBounds(200,150,70,30);
        add(b1);
        
        b2.setFont(new Font("Arial", Font.BOLD, 8));
        b2.setBounds(320,150,70,30);
        add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);
        
        setSize(600,540);
        setLocation(550,200);
        setVisible(true);
        
    }

    public void actionPerformed(ActionEvent ae){
        try {
            if(ae.getSource()==b1){
                setVisible(false);
                new userhub().setVisible(true);  
            }
            else if(ae.getSource()==b2){
                setVisible(false);
                new retailerhub().setVisible(true); 
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new checkit().setVisible(true);
    }
}
