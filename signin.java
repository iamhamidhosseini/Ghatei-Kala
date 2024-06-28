import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signin implements ActionListener {
    JFrame frame = new JFrame("Ghatei Kala");
    JButton confirm = new JButton("ورود");
    Font font = new Font("Fixedsys Regular",Font.BOLD,20);
    TextField textField , textField1 ;
    JLabel text = new JLabel("شماره تلفن");JLabel text1 = new JLabel("رمز عبور");

    public signin(){
        ////////////////////////////// Frame //////////////////////////////////
        frame.setDefaultCloseOperation(3);
        frame.setSize(1500,800);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.gray);
        frame.setVisible(true);

        ///////////////////////////// make buttons ///////////////////////////////
        confirm.setBounds(1000,400,300,100);
        confirm.setFont(font);
        confirm.setFocusable(false);
        confirm.addActionListener(this);
        frame.add(confirm);

        /////////////////////////////// Text /////////////////////////////////////
        text.setFont(font);
        text.setBounds(150 , 200 , 100 , 30);
        frame.add(text);
        text1.setFont(font);
        text1.setBounds(150 , 290 , 100 , 30);
        frame.add(text1);

        /////////////////////////////// Textfields ////////////////////////////////
        textField = new TextField();textField.setBounds(300,290,300,40);textField.setFont(font);
        frame.add(textField);
        textField1 = new TextField();textField1.setBounds(300,200,300,40);textField1.setFont(font);
        frame.add(textField1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==confirm){
            frame.dispose();
            ProductListCustomer x = new ProductListCustomer();
            x.frame();
        }
    }
}
