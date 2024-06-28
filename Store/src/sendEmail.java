import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JFrame;


/**
 *
 * @author 66490812
 */
public class sendEmail implements ActionListener{
    JFrame frame = new JFrame("Ghatei Kala");
    Font font = new Font("Fixedsys Regular",Font.BOLD,25);
    JButton ok = new JButton("باشه");
    JLabel text = new JLabel("ایمیل تایید ساخت اکانت به شما ارسال شد");
    JLabel text1 = new JLabel("حال میتوانید با اکانتی که ساختید از قسمت ورود وارد شوید");

    public sendEmail(){
        ///////////////////////// make frame //////////////////////////
        frame.setDefaultCloseOperation(3);
        frame.setSize(1500,800);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.gray);
        frame.setVisible(true);

        //////////////////////// Set Button ///////////////////////////
        ok.setBounds(600,600,300,70);
        ok.setFont(font);
        ok.setFocusable(false);
        ok.addActionListener(this);frame.add(ok);

        //////////////////////// Set text ////////////////////////////
        text.setFont(font);
        text.setBounds(580, 100, 1000, 100);
        frame.add(text);
        text1.setFont(font);
        text1.setBounds(510, 200, 1000, 100);
        frame.add(text1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==ok){
            frame.dispose();
            Intro x = new Intro();
        }
    }
}
