import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AddProduct extends JFrame implements ActionListener{

    JLabel productName = new JLabel(":نام کالا");
    JLabel productPrice = new JLabel(":قیمت کالا");
    JLabel productPic = new JLabel(":عکس کالا");

    JTextField enterProductName = new JTextField();
    JTextField enterProductPrice = new JTextField();

    JButton chooseImage = new JButton("انتخاب تصویر");
    File file;
    BufferedImage bufferedImage;
    String filePath = "/home/...";
    JFileChooser fileChooser = new JFileChooser(filePath);

    JButton addProduct = new JButton("افزودن کالا");

    public void frame(){
        this.setSize(800, 400);
        this.setLayout(null);

        productName.setBounds(50, 35, 100, 50);
        enterProductName.setBounds(100, 50, 100, 25);
        productPrice.setBounds(50, 85, 100, 50);
        enterProductPrice.setBounds(100, 100, 100, 25);
        productPic.setBounds(50, 150, 100, 50);
        chooseImage.setBounds(100, 150, 100, 50);
        chooseImage.addActionListener(this);
        addProduct.setBounds(100, 350, 100, 50);
        addProduct.addActionListener(this);

        this.add(productName);
        this.add(enterProductName);
        this.add(productPrice);
        this.add(enterProductPrice);
        this.add(productPic);
        this.add(chooseImage);
        this.add(addProduct);

        this.setVisible(true);
    }

    public void chooseFileImage(){
        try{
            int response = fileChooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION){
                file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                bufferedImage = ImageIO.read(file);

                BufferedImage resizedBufferedImage;

                Image tmp = bufferedImage.getScaledInstance(380, 380, Image.SCALE_SMOOTH);
                resizedBufferedImage = new BufferedImage(380, 380, BufferedImage.TYPE_INT_ARGB);

                Graphics2D g2d = resizedBufferedImage.createGraphics();
                g2d.drawImage(tmp,0, 0, null);
                g2d.dispose();

                ImageIcon resizedIcon = new ImageIcon(resizedBufferedImage);
                JLabel resizedImage = new JLabel(resizedIcon);
                resizedImage.setBounds(410, 10, 380, 380);
                this.add(resizedImage);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == chooseImage){
            chooseFileImage();
            this.revalidate();
            this.repaint();
        } else if (e.getSource() == addProduct) {

        }
    }
}
