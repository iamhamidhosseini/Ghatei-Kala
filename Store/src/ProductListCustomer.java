/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Padidar
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductListCustomer extends JFrame implements ActionListener{

    JPanel productList = new JPanel();
    ImageIcon userImage= new ImageIcon("UserIcon.jpg");
    JButton userButton = new JButton(userImage);
    ImageIcon shoppingImage = new ImageIcon("ShoppingCart.jpg");
    JButton shoppingCart = new JButton(shoppingImage);
    JButton logout = new JButton("خروج");
    
    Costumer customer;
    

   
    public ProductListCustomer(Costumer customer) {
        
            this.customer = customer;
            this.setSize(1500, 800);
            this.setLayout(null);
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            this.getContentPane().setBackground(new Color(179, 25, 0));
            
            productList.setBounds(0, 50, 1500, 800);
            productList.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
            productList.setBackground(Color.DARK_GRAY);
            this.add(productList);
            
            userButton.setBounds(0, 0, 50, 50);
            userButton.setBackground(Color.WHITE);
            userButton.addActionListener(this);
            this.add(userButton);
            
            shoppingCart.setBounds(1450, 0, 50 ,50);
            shoppingCart.setBackground(Color.WHITE);
            shoppingCart.addActionListener(this);
            this.add(shoppingCart);
            
            logout.setBounds(50, 0, 100, 50);
            logout.setBackground(Color.WHITE);
            logout.addActionListener(this);
            this.add(logout);
            
            
           
            
            try {
            String host="jdbc:derby://localhost:1527/P";
            String username="MAMAD", password="1020315";
            Connection con = DriverManager.getConnection( host, username, password );
            Statement stmt=con.createStatement();
            String SQL="select * from PRODUCTS";
            ResultSet rs=stmt.executeQuery(SQL);
            ArrayList<Product> products=new ArrayList<>();
            while(rs.next()){
                String productname=rs.getString("PRODUCTNAME");
                
                String price=rs.getString("PRICE");
                
                String url=rs.getString("ADDRESS");
               
                productList.add(new Product(productname, price, url));
                
            }   
            
            } catch (SQLException ex) {
            Logger.getLogger(ProductListCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            this.setVisible(true);
        
    }


    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == userButton){
           UserInfo userInfo = new UserInfo(this.customer);
       } else if (e.getSource() == shoppingCart) {
            ShoppingCart shoppingCart = new ShoppingCart(customer);
       } else if (e.getSource() == logout){
           
           try {
               String host="jdbc:derby://localhost:1527/sabad";
               String username="sabad", passwords="sabad";
               Connection con = DriverManager.getConnection( host, username, passwords );
               Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
               String SQL="select * from sabad";
               ResultSet rs=stmt.executeQuery(SQL);
               while(rs.next()){
                   rs.deleteRow();
               }
               
               this.dispose();
           }
           catch (SQLException ex) {
               Logger.getLogger(ProductListCustomer.class.getName()).log(Level.SEVERE, null, ex);
           }
           
       } 
    }
}
