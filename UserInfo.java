import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInfo implements ActionListener {

    JFrame frame = new JFrame("Ghatei Kala");
    JLabel name;
    JLabel lastname;
    JLabel phoneNumber;
    JLabel age;
    JLabel email;
    JLabel ID;
    JLabel balance;
    JButton update = new JButton("به روز رسانی");
    JButton addBalance = new JButton("افزایش صد هزار تومانی اعتبار");
    Font font = new Font("Fixedsys Regular",Font.BOLD,20);
    TextField textField , textField1 , textField2 , textField3 , textField4 ;


    public UserInfo (){
        /////////////////////////////////// Frame ///////////////////////////////////
        frame.setDefaultCloseOperation(3);
        frame.setSize(700,700);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.gray);
        frame.setVisible(true);

        ////////////////////////////////// Button ///////////////////////////////////
        update.setBounds(400,550,250,50);
        update.setFont(font);
        update.setFocusable(false);
        update.addActionListener(this);
        frame.add(update);
        addBalance.setBounds(400,400,250,50);
        addBalance.setFont(font);
        addBalance.setFocusable(false);
        addBalance.addActionListener(this);
        frame.add(addBalance);

        ///////////////////////////////// text ///////////////////////////////////////
        name = new JLabel("Hi");
        lastname = new JLabel("Hi");
        phoneNumber = new JLabel("Hi");
        age = new JLabel("Hi");
        email = new JLabel("Hi");
        ID = new JLabel("Hi");
        balance = new JLabel("Hi");


        name.setFont(font);name.setBounds(10 , 10 , 100 , 50);frame.add(name);
        lastname.setFont(font);lastname.setBounds(10 , 60 , 100 , 50);frame.add(lastname);
        phoneNumber.setFont(font);phoneNumber.setBounds(10 , 120 , 100 , 50);frame.add(phoneNumber);
        age.setFont(font);age.setBounds(10 , 180 , 100 , 50);frame.add(age);
        email.setFont(font);email.setBounds(10 , 240 , 100 , 50);frame.add(email);
        ID.setFont(font);ID.setBounds(10 , 300 , 100 , 50);frame.add(ID);
        balance.setFont(font);balance.setBounds(10 , 360 , 100 , 50);frame.add(balance);

        //////////////////////////////// TextFields //////////////////////////////////////
        textField = new TextField();textField.setBounds(20,15,300,40);textField.setFont(font);
        frame.add(textField);
        textField1 = new TextField();textField1.setBounds(20,65,300,40);textField1.setFont(font);
        frame.add(textField1);
        textField2 = new TextField();textField2.setBounds(20,125,300,40);textField2.setFont(font);
        frame.add(textField2);
        textField3 = new TextField();textField3.setBounds(20,245,300,40);textField3.setFont(font);
        frame.add(textField3);
        textField4 = new TextField();textField4.setBounds(20,305,300,40);textField4.setFont(font);
        frame.add(textField4);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == update){
            frame.dispose();
            UserInfo x = new UserInfo();

        } else if (e.getSource() == addBalance) {

        }
    }
}
