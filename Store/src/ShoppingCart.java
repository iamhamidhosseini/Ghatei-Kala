/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Padidar
 */
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShoppingCart extends JFrame implements ActionListener {
    
    JPanel productList = new JPanel();
    ArrayList<ProductCart> cartProducts = new ArrayList<>();
    JButton refresh = new JButton("به روز رسانی");
    JButton checkOut = new JButton("تکمیل خرید");
    Costumer customer;
    
    public ShoppingCart(Costumer customer){
        
        this.customer = customer;
       
        this.setSize(1500, 800);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        productList.setBounds(0, 0, 1500, 800);
        this.add(productList);
        
        refresh.setBounds(1450, 750, 100, 50);
        refresh.addActionListener(this);
        refresh.setBackground(Color.WHITE);
        this.add(refresh);
        
        checkOut.setBounds(0, 0, 100, 50);
        checkOut.addActionListener(this);
        checkOut.setBackground(Color.WHITE);
        this.add(checkOut);
        
         try {
            String host="jdbc:derby://localhost:1527/sabad";
            String username="sabad", password="sabad";
            Connection con = DriverManager.getConnection( host, username, password );
            Statement stmt=con.createStatement();
            String SQL="select * from sabad";
            ResultSet rs=stmt.executeQuery(SQL);
            
            for(int i = 0; rs.next(); i++){
                String productname=rs.getString("ProductName");
                
                String price=rs.getString("price");
                
                String url=rs.getString("address");
               
                cartProducts.add(new ProductCart(productname, price, url));
                productList.add(cartProducts.get(i));
            }   
            
            } catch (SQLException ex) {
            Logger.getLogger(ProductListCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.add(productList);  
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == refresh){
            this.dispose();
            ShoppingCart newPage = new ShoppingCart(customer);
        } else if(e.getSource() == checkOut){
            this.dispose();
            CheckOut checkout = new CheckOut(customer, cartProducts);
        }
    }
}
