package DataM;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
//import java.util.Arrays;
import java.awt.event.*;
import javax.swing.*;

public class newproduct extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4;
    JTextField tf1,tf2;
    JButton b1;

    newproduct(){
        setTitle("INSERT GATEWAY FOR NEW PRODUCTS");

        l1 = new JLabel("WELCOME TO DMART");
        l1.setFont(new Font("Osward", Font.BOLD, 32));
        l1.setBounds(175,40,450,40);
        add(l1);
        
        l2 = new JLabel("Enter Item Name :");
        l2.setFont(new Font("Raleway", Font.BOLD, 14));
        l2.setBounds(80,100,150,20);
        add(l2);

        tf1 = new JTextField(25);
        tf1.setBounds(260,100,230,20);
        tf1.setFont(new Font("Arial", Font.BOLD, 12));
        add(tf1);

        l3 = new JLabel("Enter Price :");
        l3.setFont(new Font("Raleway", Font.BOLD, 14));
        l3.setBounds(80,150,150,20);
        add(l3);

        tf2 = new JTextField(25);
        tf2.setBounds(260,148,230,20);
        tf2.setFont(new Font("Arial", Font.BOLD, 12));
        add(tf2);

        b1 = new JButton("OK");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        setLayout(null);
        
        b1.setFont(new Font("Arial", Font.BOLD, 8));
        b1.setBounds(450,190,100,30);
        add(b1);

        b1.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);
        
        setSize(700,420);
        setLocation(550,200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String iname = tf1.getText();
        int price = Integer.parseInt(tf2.getText());

        try {
            conn c1 = new conn();
            int m = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Number of Items You are to add: "));
            
            String q = "insert into products values('"+iname+"','"+m+"','"+price+"')";
            c1.s.executeUpdate(q);

            JOptionPane.showMessageDialog(null, "Data Updated Successfully!");
            setVisible(false);

        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public static void main(String[] args) {
        new newproduct().setVisible(true);
    }
}
