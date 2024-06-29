
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductCart extends Product{

    public ProductCart(String name, String price, String address) {
        super(name, price, address);
    }
    
    @Override
    public void mousePressed(MouseEvent e){}
    
    @Override
    public void mouseReleased(MouseEvent e) {
        DoNotPurchase doNotPurchase = new DoNotPurchase(this);
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {}
    
    @Override
    public void mouseExited(MouseEvent e) {}
    
        

}
