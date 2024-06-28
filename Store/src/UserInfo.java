import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInfo extends JFrame implements ActionListener {

    JLabel name;
    JLabel lastname;
    JLabel phoneNumber;
    JLabel age;
    JLabel email;
    JLabel ID;
    JLabel balance;
    JButton logout = new JButton("خروج");
    JButton addBalance = new JButton("افزایش اعتبار");

    public void frame(){
        this.setSize(400, 400);
        this.setLayout(null);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == logout){
            
        } else if (e.getSource() == addBalance) {
            
        }
    }
}
