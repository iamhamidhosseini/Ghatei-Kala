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
import java.util.logging.Level;
import java.util.logging.Logger;

public class signin implements ActionListener {
    JFrame frame = new JFrame("Ghatei Kala");
    JButton confirm = new JButton("ورود");
    Font font = new Font("Fixedsys Regular",Font.BOLD,20);
    TextField textField , textField1 ;
    JLabel text = new JLabel("شماره تلفن");JLabel text1 = new JLabel("رمز عبور");
    String number;
    String pass;
    Costumer costumer;

    public signin(){
        ////////////////////////////// Frame //////////////////////////////////
        frame.setDefaultCloseOperation(3);
        frame.setSize(1500,800);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.gray);
        frame.setVisible(true);

        ///////////////////////////// make buttons ///////////////////////////////
        confirm.setBounds(1000,400,300,100);
        confirm.setFont(font);
        confirm.setFocusable(false);
        confirm.addActionListener(this);
        frame.add(confirm);

        /////////////////////////////// Text /////////////////////////////////////
        text.setFont(font);
        text.setBounds(150 , 200 , 100 , 30);
        frame.add(text);
        text1.setFont(font);
        text1.setBounds(150 , 290 , 100 , 30);
        frame.add(text1);

        /////////////////////////////// Textfields ////////////////////////////////
        textField1 = new TextField();textField1.setBounds(300,200,300,40);textField1.setFont(font);
        frame.add(textField1);
        textField = new TextField();textField.setBounds(300,290,300,40);textField.setFont(font);
        frame.add(textField);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==confirm){
            
            try {
                number = textField1.getText();
                pass = textField.getText();
                String host="jdbc:derby://localhost:1527/P";
                String username="MAMAD", passwords="1020315";
                Connection con = DriverManager.getConnection( host, username, passwords );
                Statement stmt=con.createStatement();
                String SQL="select * from CO";
                ResultSet rs=stmt.executeQuery(SQL);
                while(rs.next()){
                    String tempnumber=rs.getString("PHONENUMBER");
                    if(tempnumber.equals(number)){
                        String temppass=rs.getString("PASSWORD");
                        if(temppass.equals(pass)){
                                boolean tempmn=rs.getBoolean("MN");
                                costumer = new Costumer(rs.getString("NAME") , rs.getString("LASTNAME") ,rs.getString("AGE"), rs.getString("PHONENUMBER"),rs.getString("ID"),rs.getString("EMAIL"),rs.getString("PASSWORD"), rs.getString("MONEY"));
                                
                                if(!tempmn){
                                    frame.dispose();
                                    ProductListCustomer x = new ProductListCustomer(costumer);
        
                                }
                                else{
                                    frame.dispose();
                                    ProductListManager x = new ProductListManager(costumer);
                         
                                }
                        }
                    }  
                }
            } catch (SQLException ex) {
                Logger.getLogger(signup.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("HIIIJJI");
            }
        }
    }
}
