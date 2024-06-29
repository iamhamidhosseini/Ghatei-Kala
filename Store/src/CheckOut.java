
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
public class CheckOut extends JFrame implements ActionListener{
    
    JButton confirmPurchase = new JButton("تایید خرید");
    JButton cancel = new JButton("لغو");
    JLabel finalPrice;
    Costumer customer;
    int price = 0;
    
    public CheckOut(Costumer customer, ArrayList<ProductCart> products){
        
        this.customer = customer;
        
        this.setSize(800, 400);
        this.setLayout(null);
        
        
        for(int i = 0; i < products.size(); i++)
            price += Integer.parseInt(products.get(i).price);
        
        finalPrice = new JLabel("قیمت نهایی:" + " " + String.valueOf(price));
        finalPrice.setBounds(350, 100, 100, 100);
        this.add(finalPrice);
        
        confirmPurchase.setBounds(350, 200, 100, 50);
        confirmPurchase.addActionListener(this);
        this.add(confirmPurchase);
        
        cancel.setBounds(350, 300, 100, 50);
        cancel.addActionListener(this);
        this.add(cancel);
        
        this.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == confirmPurchase){
            if(Integer.parseInt(customer.getBalance()) > price){
                this.dispose();
                PurchaseSuccess end = new PurchaseSuccess(customer, price);
            }else{
                this.dispose();
                PurchaseFail end = new PurchaseFail();
            }
        }else if (e.getSource() == cancel){
            this.dispose();
            ProductListCustomer returnToList = new ProductListCustomer(customer);
        }
    }
    
    
}
