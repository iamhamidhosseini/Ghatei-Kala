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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductListManager extends JFrame implements ActionListener{

    static JPanel productList = new JPanel();
    ImageIcon userImage= new ImageIcon("UserIcon.jpg");
    JButton userButton = new JButton(userImage);
    JButton addProduct = new JButton("+");
    JButton refresh = new JButton("به روز رسانی");
    
    JButton logout = new JButton("خروج");
    Costumer customer;


    public ProductListManager(Costumer customer){
       
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

        addProduct.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        addProduct.setBounds(1440, 0, 50, 50);
        addProduct.addActionListener(this);
        addProduct.setBackground(Color.GREEN);
        this.add(addProduct);
        
        logout.setBounds(50, 0, 100, 50);
        logout.setBackground(Color.WHITE);
        logout.addActionListener(this);
        this.add(logout);
        
        refresh.setBounds(1340, 0, 100, 50);
        refresh.addActionListener(this);
        refresh.setBackground(Color.WHITE);
        this.add(refresh);
        
        
        
        try {
            String host="jdbc:derby://localhost:1527/P";
            String username="MAMAD", password="1020315";
            Connection con = DriverManager.getConnection( host, username, password );
            Statement stmt=con.createStatement();
            String SQL="select * from PRODUCTS";
            ResultSet rs=stmt.executeQuery(SQL);
            ArrayList<ProductMod> products=new ArrayList<>();
            while(rs.next()){
                String productname=rs.getString("PRODUCTNAME");
                
                String price=rs.getString("PRICE");
                
                String url=rs.getString("ADDRESS");
               
                productList.add(new ProductMod(productname, price, url));
                
            }   
            
            } catch (SQLException ex) {
            Logger.getLogger(ProductListCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addProduct){
            AddProduct addProduct = new AddProduct();
            addProduct.frame();
        } else if (e.getSource() == userButton) {
            UserInfo userInfo = new UserInfo(customer);
        } else if (e.getSource() == refresh){
            this.dispose();
            productList.removeAll();
            ProductListManager newList = new ProductListManager(this.customer);
        } else if(e.getSource() == logout){
            this.dispose();
        } 
    }
}
