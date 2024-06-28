import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class errors implements ActionListener {
    JFrame frame = new JFrame("Ghatei Kala");
    Font font = new Font("Fixedsys Regular",Font.BOLD,25);
    JLabel text = new JLabel("پسورد وارد شده کوتاه تر از چهار کارکتر است و امنیت کافی را ندارد");
    JLabel text1 = new JLabel("پسورد های وارد شده مشابه هم نیستند");
    JLabel text2 = new JLabel("ایمیل نامعتبر وارد شده است");
    JLabel text3 = new JLabel("اسم یا فامیل وارد نشده است");
    JLabel text4 = new JLabel("شماره تلفن نامعتبر است");
    JButton back = new JButton("بازگشت");

    public errors(int error){
        ////////////////////////////////////// Set frame ////////////////////////////////
        frame.setDefaultCloseOperation(3);
        frame.setSize(1500,800);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.gray);
        frame.setVisible(true);
        ///////////////////////////////////// Set button ////////////////////////////////

        back.setBounds(600,600,300,70);
        back.setFont(font);
        back.setFocusable(false);
        back.addActionListener(this);frame.add(back);

        ///////////////////////////////////// Set text //////////////////////////////////
        if (error == -1) {
            text.setFont(font);
            text.setBounds(470, 100, 1000, 100);
            frame.add(text);
        }

        if (error == 0) {
            text1.setFont(font);
            text1.setBounds(600, 100, 1000, 100);
            frame.add(text1);
        }
        else if (error == 1){
            text2.setFont(font);
            text2.setBounds(630, 100, 1000, 100);
            frame.add(text2);
        }
        else if (error==2){
            text3.setFont(font);
            text3.setBounds(630, 100, 1000, 100);
            frame.add(text3);
        }
        else if (error==3){
            text4.setFont(font);
            text4.setBounds(630, 100, 1000, 100);
            frame.add(text4);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==back){
            frame.dispose();
            signup x = new signup();
        }
    }
}
