import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ProductListCustomer extends JFrame implements User{

    JPanel productList = new JPanel();
    ImageIcon userImage= new ImageIcon("UserIcon.jpg");
    JButton userButton = new JButton(userImage);
    ImageIcon shoppingImage = new ImageIcon("ShoppingCart.jpg");
    JButton shoppingCart = new JButton(shoppingImage);
    JPanel accountPanel = new JPanel();

    @Override
    public void frame() {
        this.setSize(1500, 800);
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(179, 25, 0));

        productList.setBounds(0, 50, 1500, 800);
        productList.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        productList.setBackground(Color.DARK_GRAY);
        this.add(productList);

        userButton.setBounds(0, 0, 50, 50);
        userButton.setBackground(Color.WHITE);
        userButton.addActionListener(this);
        this.add(userButton);

        shoppingCart.setBounds(1450, 0, 50 ,50);
        shoppingCart.setBackground(Color.WHITE);
        shoppingCart.addActionListener(this);
        this.add(shoppingCart);

        this.setVisible(true);

        accountPanel.setBounds(0, 50, 400, 200);
        accountPanel.setBackground(Color.WHITE);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == userButton){
           UserInfo userInfo = new UserInfo();
           userInfo.frame();
       } else if (e.getSource() == shoppingCart) {
            ShoppingCart shoppingCart = new ShoppingCart();
            shoppingCart.frame();
       }
    }
}
