import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ProductListManager extends JFrame implements User{

    JPanel productList = new JPanel();
    ImageIcon userImage= new ImageIcon("UserIcon.jpg");
    JButton userButton = new JButton(userImage);
    JButton addProduct = new JButton("+");

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

        addProduct.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        addProduct.setBounds(1450, 0, 50, 50);
        addProduct.addActionListener(this);
        this.add(addProduct);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addProduct){
            AddProduct addProduct = new AddProduct();
            addProduct.frame();
        } else if (e.getSource() == userButton) {
            UserInfo userInfo = new UserInfo();
            userInfo.frame();
        }
    }
}
