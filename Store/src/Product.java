import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Product extends JPanel implements MouseListener {

    JLabel productPic;
    JLabel productName;
    JLabel productPrice;
    String name;
    String price;
    String address;

    public Product(String name, String price, String address){
        this.name = name;
        this.price = price;
        this.address = address;
        productName = new JLabel(name);
        productPrice = new JLabel(price);
        ImageIcon imageIcon = new ImageIcon(address);
        ImageIcon resizedImageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));

        productPic = new JLabel(resizedImageIcon);
        this.setup();
    }

    public void setup(){
        this.setPreferredSize(new Dimension(200, 250));
        this.setBackground(Color.WHITE);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        productPic.setBounds(0, 0, 200, 200);
        this.add(productPic);
        productName.setBounds(0, 200, 25, 200);
        this.add(productName);
        productPrice.setBounds(0, 225, 25, 200);
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
        PurchaseScreen purchaseScreen = new PurchaseScreen(this);     
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
