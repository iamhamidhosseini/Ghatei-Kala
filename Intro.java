import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Intro implements ActionListener {

    JFrame frame = new JFrame("Ghatei Kala");
    JButton signIn = new JButton("ورود به اکانت");
    JButton signUp = new JButton("ساخت اکانت");
    Font font = new Font("Fixedsys Regular",Font.BOLD,20);
    JLabel text = new JLabel("به فروشگاه قطعی کالا خوش آمدید");
    public static ResultSet rs;

    public Intro(){
        ///////////////////////// make buttons //////////////////////////
        signIn.setBounds(1000,400,300,100);
        signIn.setFont(font);
        signIn.setFocusable(false);
        signIn.addActionListener(this);
        signUp.setBounds(150,400,300,100);
        signUp.setFont(font);
        signUp.setFocusable(false);
        signUp.addActionListener(this);
        ///////////////////////// make frame ///////////////////////////
        frame.setDefaultCloseOperation(3);
        frame.setSize(1500,800);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.gray);
        frame.setVisible(true);
        frame.add(signUp);frame.add(signIn);

        ////////////////////////// text ////////////////////////////
        text.setFont(font);
        text.setBounds(600 , 80 , 1000 , 100);
        frame.add(text);

    }

    public static void main(String[] args) {

        Intro intro = new Intro();}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==signUp) {
            frame.dispose();
            UserInfo x = new UserInfo();
        }
        if(e.getSource()==signIn){
            frame.dispose();
            signin x = new signin();

        }
    }
}