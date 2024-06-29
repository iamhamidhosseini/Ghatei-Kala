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

public class UserInfo implements ActionListener {

    JFrame frame = new JFrame("Ghatei Kala");
    JLabel name;
    JLabel lastname;
    JLabel phoneNumber;
    JLabel age;
    JLabel email;
    JLabel ID;
    JLabel balance;
    JButton update = new JButton("به روز رسانی");
    JButton addBalance = new JButton("افزایش صد هزار تومانی اعتبار");
    Font font = new Font("Fixedsys Regular",Font.BOLD,20);
    TextField textField , textField1 , textField2 , textField3 , textField4 ;
    Costumer customer;


    public UserInfo (Costumer customer){
        
        this.customer = customer;
        /////////////////////////////////// Frame ///////////////////////////////////
        frame.setSize(700,700);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.gray);
        frame.setVisible(true);

        ////////////////////////////////// Button ///////////////////////////////////
        update.setBounds(400,550,250,50);
        update.setFont(font);
        update.setFocusable(false);
        update.addActionListener(this);
        frame.add(update);
        addBalance.setBounds(400,400,250,50);
        addBalance.setFont(font);
        addBalance.setFocusable(false);
        addBalance.addActionListener(this);
        frame.add(addBalance);

        ///////////////////////////////// text ///////////////////////////////////////
        name = new JLabel(customer.getName());
        lastname = new JLabel(customer.getFamily());
        phoneNumber = new JLabel(customer.getPhone());
        age = new JLabel(customer.getAge());
        email = new JLabel(customer.getEmail());
        ID = new JLabel(customer.getID());
        balance = new JLabel(customer.getBalance());


        name.setFont(font);name.setBounds(10 , 10 , 200 , 50);frame.add(name);
        lastname.setFont(font);lastname.setBounds(10 , 60 , 200 , 50);frame.add(lastname);
        phoneNumber.setFont(font);phoneNumber.setBounds(10 , 120 , 200 , 50);frame.add(phoneNumber);
        age.setFont(font);age.setBounds(10 , 180 , 200 , 50);frame.add(age);
        email.setFont(font);email.setBounds(10 , 240 , 200 , 50);frame.add(email);
        ID.setFont(font);ID.setBounds(10 , 300 , 200 , 50);frame.add(ID);
        balance.setFont(font);balance.setBounds(10 , 360 , 200 , 50);frame.add(balance);

        //////////////////////////////// TextFields //////////////////////////////////////
        textField = new TextField();textField.setBounds(220,15,200,40);textField.setFont(font);
        frame.add(textField);
        textField1 = new TextField();textField1.setBounds(220,65,300,40);textField1.setFont(font);
        frame.add(textField1);
        textField2 = new TextField();textField2.setBounds(220,125,300,40);textField2.setFont(font);
        frame.add(textField2);
        textField3 = new TextField();textField3.setBounds(220,245,300,40);textField3.setFont(font);
        frame.add(textField3);
        textField4 = new TextField();textField4.setBounds(220,305,300,40);textField4.setFont(font);
        frame.add(textField4);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == update){
            
            String a = textField.getText();
            String b = textField1.getText();
            String c = textField2.getText();
            String d = textField3.getText();
            String k = textField4.getText();
            try {
                String host="jdbc:derby://localhost:1527/P";
                String username="MAMAD", password="1020315";
                Connection con = DriverManager.getConnection( host, username, password );
                Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                String SQL="select * from CO";System.out.println("c");
                ResultSet rs=stmt.executeQuery(SQL);
                System.out.println("d");
               
                while(rs.next()){
                    System.out.println("e");
                    String phoneNumber=rs.getString("NAME");
                    System.out.println(phoneNumber);
                    if(phoneNumber.equals(customer.getName()));{
                        rs.next();
                        rs.next();
                        rs.updateString("NAME", a);
                        customer.setName(a);
                        rs.updateRow();
                        break;
                    }
                }
                stmt.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(RemoveScreen.class.getName()).log(Level.SEVERE, null, ex);System.out.println("g");
            }
            
            
            try {
                String host="jdbc:derby://localhost:1527/P";
                String username="MAMAD", password="1020315";
                Connection con = DriverManager.getConnection( host, username, password );
                Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                String SQL="select * from CO";System.out.println("c");
                ResultSet rs=stmt.executeQuery(SQL);
                System.out.println("d");
               
                while(rs.next()){
                    System.out.println("e");
                    String phoneNumber=rs.getString("LASTNAME");
                    System.out.println(phoneNumber);
                    if(phoneNumber.equals(customer.getFamily()));{
                        rs.next();
                        rs.next();
                        rs.updateString("LASTNAME", b);
                        customer.setFamily(b);
                        rs.updateRow();
                        break;
                    }
                }
                stmt.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(RemoveScreen.class.getName()).log(Level.SEVERE, null, ex);System.out.println("g");
            }
            
            
            try {
                String host="jdbc:derby://localhost:1527/P";
                String username="MAMAD", password="1020315";
                Connection con = DriverManager.getConnection( host, username, password );
                Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                String SQL="select * from CO";System.out.println("c");
                ResultSet rs=stmt.executeQuery(SQL);
                System.out.println("d");
               
                while(rs.next()){
                    System.out.println("e");
                    String phoneNumber=rs.getString("PHONENUMBER");
                    System.out.println(phoneNumber);
                    if(phoneNumber.equals(customer.getPhone()));{
                        rs.next();
                        rs.next();
                        rs.updateString("PHONENUMBER", c);
                        customer.setPhone(c);
                        rs.updateRow();
                        break;
                    }
                }
                stmt.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(RemoveScreen.class.getName()).log(Level.SEVERE, null, ex);System.out.println("g");
            }
            
            
            try {
                String host="jdbc:derby://localhost:1527/P";
                String username="MAMAD", password="1020315";
                Connection con = DriverManager.getConnection( host, username, password );
                Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                String SQL="select * from CO";System.out.println("c");
                ResultSet rs=stmt.executeQuery(SQL);
                System.out.println("d");
               
                while(rs.next()){
                    System.out.println("e");
                    String phoneNumber=rs.getString("EMAIL");
                    System.out.println(phoneNumber);
                    if(phoneNumber.equals(customer.getEmail()));{
                        rs.next();
                        rs.next();
                        rs.updateString("EMAIL", d);
                        customer.setEmail(d);
                        rs.updateRow();
                        break;
                    }
                }
                stmt.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(RemoveScreen.class.getName()).log(Level.SEVERE, null, ex);System.out.println("g");
            }
            
            try {
                String host="jdbc:derby://localhost:1527/P";
                String username="MAMAD", password="1020315";
                Connection con = DriverManager.getConnection( host, username, password );
                Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                String SQL="select * from CO";System.out.println("c");
                ResultSet rs=stmt.executeQuery(SQL);
                System.out.println("d");
               
                while(rs.next()){
                    System.out.println("e");
                    String phoneNumber=rs.getString("ID");
                    System.out.println(phoneNumber);
                    if(phoneNumber.equals(customer.getID()));{
                        rs.next();
                        rs.next();
                        rs.updateString("ID", k);
                        customer.setID(k);
                        rs.updateRow();
                        break;
                    }
                }
                stmt.close();
                rs.close();
                
                System.out.println("f");
                

            } catch (SQLException ex) {
                Logger.getLogger(RemoveScreen.class.getName()).log(Level.SEVERE, null, ex);System.out.println("g");
            }
            
            
            frame.dispose();
            UserInfo x = new UserInfo(customer);

        } else if (e.getSource() == addBalance) {
            int x = Integer.parseInt(customer.getBalance());
            x += 100000;
            String y = String.valueOf(x);
            customer.setBalance(y);
            frame.dispose();
            UserInfo update = new UserInfo(customer);
            
            try {
                String host="jdbc:derby://localhost:1527/P";
                String username="MAMAD", password="1020315";
                Connection con = DriverManager.getConnection( host, username, password );
                Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                String SQL="select * from CO";System.out.println("c");
                ResultSet rs=stmt.executeQuery(SQL);
                System.out.println("d");
               
                while(rs.next()){
                    System.out.println("e");
                    String phoneNumber=rs.getString("ID");
                    System.out.println(phoneNumber);
                    if(phoneNumber.equals(customer.getID()));{
                        rs.next();
                        rs.next();
                        rs.updateString("MONEY", y);
                        System.out.println("YES");
                        rs.updateRow();
                        break;
                    }
                }
                stmt.close();
                rs.close();
                
                System.out.println("f");
                

            } catch (SQLException ex) {
                Logger.getLogger(RemoveScreen.class.getName()).log(Level.SEVERE, null, ex);System.out.println("g");
            }
            
            
            
        }
    }
}
