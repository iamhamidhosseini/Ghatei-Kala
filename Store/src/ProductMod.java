
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

public class ProductMod extends Product implements ActionListener{
    
    JButton removeFromList;

    public ProductMod(String name, String price, String address) {
        super(name, price, address);
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        RemoveScreen removeScreen = new RemoveScreen(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == removeFromList){
                     
        }
    }
}
