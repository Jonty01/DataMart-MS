package DataM;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
//import java.util.Arrays;
import java.awt.event.*;
import javax.swing.*;

public class retailerhub extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4;
    JTextField tf1;
    JButton b1,b2;

    retailerhub(){
        setTitle("Welcome Retailer!");

        l1 = new JLabel("WELCOME TO DMART");
        l1.setFont(new Font("Osward", Font.BOLD, 32));
        l1.setBounds(175,40,450,40);
        add(l1);
        
        l2 = new JLabel("Enter the Product You Want to Update :");
        l2.setFont(new Font("Raleway", Font.BOLD, 14));
        l2.setBounds(80,100,400,40);
        add(l2);

        tf1 = new JTextField(25);
        tf1.setBounds(260,148,230,20);
        tf1.setFont(new Font("Arial", Font.BOLD, 12));
        add(tf1);



        l4 = new JLabel("If You Are New and Want to add Product Then Click ADD PRODUCT:");
        l4.setFont(new Font("Raleway", Font.BOLD, 16));
        l4.setBounds(80,250,550,40);
        add(l4);

        b1 = new JButton("OK");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("ADD PRODUCT");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        setLayout(null);
        
        b1.setFont(new Font("Arial", Font.BOLD, 8));
        b1.setBounds(450,190,100,30);
        add(b1);
        
        b2.setFont(new Font("Arial", Font.BOLD, 8));
        b2.setBounds(450,290,100,30);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);
        
        setSize(700,420);
        setLocation(550,200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String p = tf1.getText();
        int qua=0;

        try {
            if(ae.getSource()==b1){
                conn c1 = new conn();
                String q = "select quantity from products where item_name='"+p+"'";
                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){
                    int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Number of Items You want to add: "));
                    qua = rs.getInt("quantity");
                    int newqua = num + qua;
                    String q1 = "update products set quantity="+newqua+" where item_name='"+p+"'";
                    c1.s.executeUpdate(q1);
                    JOptionPane.showMessageDialog(null, "Avaialable Stock: " + newqua);
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null, "No Item Chosen");
                }
            } else if(ae.getSource()==b2){
                setVisible(false);
                new newproduct().setVisible(true);
            }
            } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new retailerhub().setVisible(true);
    }
}
