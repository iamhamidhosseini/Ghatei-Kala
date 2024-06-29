
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class PurchaseSuccess extends JFrame implements ActionListener{
    
    JLabel success = new JLabel("خرید با موفقیت انجام شد");
    JButton backToList = new JButton("بازگشت");
    Costumer customer;
    
    public PurchaseSuccess(Costumer customer, int price){
        this.customer = customer;
        this.setSize(800, 400);
        this.setLayout(null);
        
        success.setBounds(350, 200, 100, 50);
        this.add(success);
        
        backToList.setBounds(350, 250, 100, 100);
        backToList.addActionListener(this);
        this.add(backToList);
        
        int newBalance = Integer.parseInt(customer.getBalance()) - price;
        
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
                        rs.updateString("MONEY", String.valueOf(newBalance));
                        customer.setBalance(String.valueOf(newBalance));
                        
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
        
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backToList){
            this.dispose();
        }

    }
   
    
}
