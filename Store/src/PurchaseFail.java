
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Padidar
 */
public class PurchaseFail extends JFrame implements ActionListener {
    
    JLabel fail = new JLabel("موجودی کافی نیست");
    JButton backToList = new JButton("بازگشت");
  
    public PurchaseFail(){
        
        this.setSize(800, 400);
        this.setLayout(null);
        
        fail.setBounds(350, 200, 100, 50);
        this.add(fail);
        
        backToList.setBounds(350, 250, 100, 100);
        backToList.addActionListener(this);
        this.add(backToList);
        
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backToList){
            this.dispose();
        }
    }
    
}
