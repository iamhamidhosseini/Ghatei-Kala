import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PurchaseScreen extends JFrame implements ActionListener {


    JLabel name;
    JLabel price;
    JLabel pic;
    JButton addToCart = new JButton("افزودن به سبد خرید");

    public PurchaseScreen(Product product){
        name = new JLabel(product.name);
        name.setPreferredSize(new Dimension(400, 100));
        name.setBounds(400, 50, 400, 100);
        name.setFont(new Font(Font.SERIF, Font.PLAIN, 50));

        price = new JLabel(product.price);
        price.setPreferredSize(new Dimension(400, 100));
        price.setBounds(400, 150, 400, 100);
        price.setFont(new Font(Font.SERIF, Font.PLAIN, 30));

        pic = new JLabel(new ImageIcon(product.address));
        pic.setPreferredSize(new Dimension(400, 400));
        pic.setBounds(0,0,400, 400);

        addToCart.setPreferredSize(new Dimension(380, 90));
        addToCart.setBounds(410, 310, 380,90);
        addToCart.setBackground(Color.GREEN);
        addToCart.setFont(new Font(Font.SERIF, Font.PLAIN, 50));
    }

    public void purchaseScreen(){
        this.setSize(800, 400);
        this.setLayout(null);
        this.add(pic);
        this.add(name);
        this.add(price);
        this.add(addToCart);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addToCart){
            //Add to database
        }
    }
}
