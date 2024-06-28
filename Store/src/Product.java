import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Product extends JPanel implements MouseListener {

    String name;
    String price;
    String address;

    JLabel productPic;
    JLabel productName;
    JLabel productPrice;

    public Product(String name, String price, String address){
        this.name = name;
        this.price = price;
        this.address = address;
        productName = new JLabel(name);
        productPrice = new JLabel(price);
        productPic = new JLabel(new ImageIcon(address));  //ImageIcon needs to replaced with an actual processed ImageIcon
        this.setup();
    }

    public void setup(){
        this.setPreferredSize(new Dimension(200, 250));
        this.setBackground(Color.WHITE);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(productPic);
        this.add(productName);
        this.add(productPrice);
        addMouseListener(this);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        //Add to shopping list
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.setBackground(Color.RED);
        this.revalidate();
        this.repaint();
        PurchaseScreen buyProduct = new PurchaseScreen(this);
        buyProduct.purchaseScreen();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.setBackground(new Color(255, 127, 127));
        this.revalidate();
        this.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBackground(new Color(255, 127, 127));
        this.revalidate();
        this.repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBackground(Color.WHITE);
        this.revalidate();
        this.repaint();
    }
}
