
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DoNotPurchase extends JFrame implements ActionListener {
        JLabel name;
    JLabel price;
    JLabel pic;
    JButton removeFromList = new JButton("حذف از سبد خرید");
    ProductCart data;
   

    public DoNotPurchase(ProductCart product){
        data = product;
        name = new JLabel(product.name);
        name.setPreferredSize(new Dimension(400, 100));
        name.setBounds(450, 50, 400, 100);
        name.setFont(new Font(Font.SERIF, Font.PLAIN, 50));

        price = new JLabel(product.price + " " + "تومان");
        price.setPreferredSize(new Dimension(400, 100));
        price.setBounds(450, 150, 400, 200);
        price.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        
        ImageIcon imageIcon = new ImageIcon(product.address);
        ImageIcon resizedImageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT));
        pic = new JLabel(resizedImageIcon);
        pic.setPreferredSize(new Dimension(400, 400));
        pic.setBounds(0,0,400, 400);

        removeFromList.setPreferredSize(new Dimension(380, 90));
        removeFromList.setBounds(410, 300, 380,50);
        removeFromList.setBackground(Color.RED);
        removeFromList.setFont(new Font(Font.SERIF, Font.PLAIN, 50));
        removeFromList.addActionListener(this);
        
        this.setSize(800, 400);
        this.setLayout(null);
        this.add(pic);
        this.add(name);
        this.add(price);
        this.add(removeFromList);
        this.setVisible(true);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == removeFromList){
            
             try {
                String host="jdbc:derby://localhost:1527/SABAD";
                String username="sabad", password="sabad";
                Connection con = DriverManager.getConnection( host, username, password );
                Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                String SQL="select * from SABAD";System.out.println("c");
                ResultSet rs=stmt.executeQuery(SQL);
                System.out.println("d");
               
                while(rs.next()){
                    System.out.println("e");
                    String productname=rs.getString("PRODUCTNAME");
                    System.out.println(productname);
                    if(productname.equals(data.name));{
                        rs.deleteRow();
                        System.out.println("YES");
                        break;
                    }
                }
                stmt.close();
                rs.close();
                
                System.out.println("f");
                this.dispose();
                

            } catch (SQLException ex) {
                Logger.getLogger(RemoveScreen.class.getName()).log(Level.SEVERE, null, ex);System.out.println("g");
            }
        }
            
        }
       
}
