
/**
 *
 * @author 66490812
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class signup implements ActionListener{
    JFrame frame = new JFrame("Ghatei Kala");
    JButton confirm = new JButton("ساخت اکانت");
    JButton back = new JButton("بازگشت");
    Font font = new Font("Fixedsys Regular",Font.BOLD,20);
    TextField textField , textField1 , textField2 , textField3 ,textField4 , textField5 , textField6 , textField7;
    Costumer costumer;
    String name , lastName , phoneNumber , id , email , age , password , confirmPassword;
    JLabel text = new JLabel("نام");JLabel text1 = new JLabel("نام خانوادگی");
    JLabel text2 = new JLabel("شماره تلفن همراه");JLabel text3 = new JLabel("کد ملی");
    JLabel text4 = new JLabel("ایمیل");JLabel text5 = new JLabel("سن");
    JLabel text6 = new JLabel("رمز عبور");JLabel text7 = new JLabel("تایید رمز عبور");
    int error;
    //Connection con;


    public signup(){
        ///////////////////////// make frame //////////////////////////
        frame.setDefaultCloseOperation(3);
        frame.setSize(1500,800);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.gray);
        frame.setVisible(true);

        ////////////////////////////////// make text fields /////////////////////////////////////////////

        textField = new TextField();textField.setBounds(250,50,300,40);textField.setFont(font);
        frame.add(textField);
        textField1 = new TextField();textField1.setBounds(250,120,300,40);textField1.setFont(font);
        frame.add(textField1);
        textField2 = new TextField();textField2.setBounds(250,190,300,40);textField2.setFont(font);
        frame.add(textField2);
        textField3 = new TextField();textField3.setBounds(250,260,300,40);textField3.setFont(font);
        frame.add(textField3);
        textField4 = new TextField();textField4.setBounds(250,330,300,40);textField4.setFont(font);
        frame.add(textField4);
        textField5 = new TextField();textField5.setBounds(250,400,300,40);textField5.setFont(font);
        frame.add(textField5);
        textField6 = new TextField();textField6.setBounds(250,470,300,40);textField6.setFont(font);
        frame.add(textField6);
        textField7 = new TextField();textField7.setBounds(250,540,300,40);textField7.setFont(font);
        frame.add(textField7);

        //////////////////////////////////// Add text ////////////////////////////////////////////////
        text.setFont(font);text.setBounds(30, 20 , 100 , 100);frame.add(text);
        text1.setFont(font);text1.setBounds(30, 90 , 1000 , 100);frame.add(text1);
        text2.setFont(font);text2.setBounds(30, 160 , 1000 , 100);frame.add(text2);
        text3.setFont(font);text3.setBounds(30, 230 , 1000 , 100);frame.add(text3);
        text4.setFont(font);text4.setBounds(30, 300 , 1000 , 100);frame.add(text4);
        text5.setFont(font);text5.setBounds(30, 370 , 1000 , 100);frame.add(text5);
        text6.setFont(font);text6.setBounds(30, 440 , 1000 , 100);frame.add(text6);
        text7.setFont(font);text7.setBounds(30, 510 , 1000 , 100);frame.add(text7);

        /////////////////////////////////// Button /////////////////////////////////////////////
        confirm.setBounds(165,650,300,70);confirm.setFont(font);
        confirm.setFocusable(false);confirm.addActionListener(this);frame.add(confirm);

        back.setBounds(900,650,300,70);back.setFont(font);
        back.setFocusable(false);back.addActionListener(this);frame.add(back);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //////////////////////////////// Connecting to database /////////////////////////////////////////////
        
        
        if (e.getSource()==confirm){

            //////////////////////////////////// Get Strings ////////////////////////////////////////////////
            name = textField.getText();lastName = textField1.getText();phoneNumber = textField2.getText();
            id = textField3.getText();email = textField4.getText();age = textField5.getText();
            password = textField6.getText();confirmPassword = textField7.getText();

            if (password.length()>=4){
                if (confirmPassword.equals(password)) {
                    if (email.startsWith("@")) {
                        if (!name.equals("") && !lastName.equals("")) {
                            if (phoneNumber.length() == 11) {
                               
                                try {
                                    
                                    costumer = new Costumer(name, lastName, age, phoneNumber, id, email, password, "0");
                                    String host="jdbc:derby://localhost:1527/P";
                                    String username="MAMAD", passwords="1020315";
                                    
                                    Connection con = DriverManager.getConnection( host, username, passwords );
                                    Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                                    String SQL="select * from CO";
                                    ResultSet rs=stmt.executeQuery(SQL);
                                    rs.moveToInsertRow();
                                    rs.updateString("NAME", name);
                                    rs.updateString("LASTNAME", lastName);
                                    rs.updateString("PHONENUMBER", phoneNumber);
                                    rs.updateString("ID", id);
                                    rs.updateString("AGE", age);
                                    rs.updateString("PASSWORD", password);
                                    rs.updateString("EMAIL", email);
                                    rs.insertRow();
                                    rs.close();
                                    rs=stmt.executeQuery(SQL);

                                    
                                } catch (SQLException ex) {
                                    Logger.getLogger(signup.class.getName()).log(Level.SEVERE, null, ex);
                                    System.out.println("HIIIJJI");
                                }
                                frame.dispose();
                                sendEmail x = new sendEmail();
                            }
                            else {
                                error = 3;
                                frame.dispose();
                                errors x = new errors(error);
                            }
                        }
                        else {
                            error = 2;
                            frame.dispose();
                            errors x = new errors(error);
                        }
                    }
                    else {
                        error = 1;
                        frame.dispose();
                        errors x = new errors(error);
                    }
                }
                else {
                    error = 0;
                    frame.dispose();
                    errors x = new errors(error);
                }
            }
            else{
                error = -1;
                frame.dispose();
                errors x = new errors(error);
            }
        }
        if (e.getSource()==back){
            frame.dispose();
            Intro x = new Intro();
        }

    }
   

}