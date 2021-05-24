package DataM;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Arrays;
//import com.toedter.calendar.JDateChooser;
//import java.util.*;

public class retailerpass extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4;
    JTextField tf1;
    JPasswordField pf1,pf2;
    // JRadioButton r1,r2;
    JButton b1,b2;
    // JComboBox<String> c1= new JComboBox<>();
    // JComboBox<String> c2= new JComboBox<>();
    // JComboBox<String> c3= new JComboBox<>();

    retailerpass(){
        setTitle("NEW RETAILER ACCOUNT APPLICATION");

        l1 = new JLabel("PLEASE CHOOSE A STRONG PASSWORD");
        l1.setFont(new Font("Raleway", Font.BOLD, 16));

        l2 = new JLabel("Type Your Username:");                           //textfield
        l2.setFont(new Font("Raleway", Font.BOLD, 12));

        l3 = new JLabel("Type a Password:");                          //textfield 
        l3.setFont(new Font("Raleway", Font.BOLD, 12));

        l4 = new JLabel("Confirm Password:");                          //textfield 
        l4.setFont(new Font("Raleway", Font.BOLD, 12));

        tf1 = new JTextField();
        tf1.setFont(new Font("Raleway", Font.BOLD, 10));

        pf1 = new JPasswordField(10);
        pf1.setFont(new Font("Raleway", Font.BOLD, 10));

        pf2 = new JPasswordField(10);
        pf2.setFont(new Font("Raleway", Font.BOLD, 10));

        b1 = new JButton("OK");
        b1.setFont(new Font("Raleway", Font.BOLD, 10));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2 = new JButton("Next");
        b2.setFont(new Font("Raleway", Font.BOLD, 10));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        setLayout(null);

        l1.setBounds(60,20,500,30);
        add(l1);

        l2.setBounds(60,60,200,30);
        add(l2);

        tf1.setBounds(190,60,150,30);
        add(tf1);

        l3.setBounds(60,100,200,30);
        add(l3);

        pf1.setBounds(190,100,150,30);
        add(pf1);

        l4.setBounds(60,140,200,30);
        add(l4);

        pf2.setBounds(190,140,150,30);
        add(pf2);

        b1.setBounds(270,182,70,30);
        add(b1);

        b2.setBounds(360,320,70,30);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);
        
        setSize(450,400);
        setLocation(500,120);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String rid = tf1.getText();                // may be changed later to char[] b= pf2.getPassword();
        String rpass = pf1.getText();          // may be deleted later along with changing ^
        String ss = "Retailer"; 

        try {
            if(ae.getSource()==b1){
                conn c1 =  new conn();

                String q = "insert into login values('"+rid+"','"+rpass+"','"+ss+"')";
                c1.s.executeUpdate(q);
                
                JOptionPane.showMessageDialog(null, "Click NEXT To Proceed");
            }else if(ae.getSource()==b2){
                setVisible(false);
                new retailerhub().setVisible(true);  
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new retailerpass().setVisible(true);
    }
}
