import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductMod extends Product implements ActionListener{
    public ProductMod(String name, String price, String address) {
        super(name, price, address);
    }

    public void setup(){
        this.setPreferredSize(new Dimension(200, 250));
        this.setBackground(Color.WHITE);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(productPic);
        this.add(productName);
        this.add(productPrice);
        JButton removeButton = new JButton("X");
        removeButton.setPreferredSize(new Dimension(50, 50));
        removeButton.addActionListener(this);
        this.add(removeButton, FlowLayout.LEADING);
        addMouseListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Blap");
    }
}
