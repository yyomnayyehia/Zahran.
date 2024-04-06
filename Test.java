package OOP;

import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Test {
    public static void main(String[] args){
        ShoppingCart sh= new ShoppingCart();
        int name;
        double price;
        int quantity;
        
        Object[] options1 = {"Pizza","Cheeseburger", "Coffee","Soda","Water"};

        ImageIcon icon = new ImageIcon("C:\\Users\\aliaa\\Desktop\\zahran.png");



        System.out.println("Please, select a product:\n- Pizza, $40\n- Cheeseburger, $20\n- Coffee, $5\n- Soda, $4\n- Water, $2");
        name= JOptionPane.showOptionDialog(null,"Enter the item you would like:","Zahran",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE,icon,
                options1,null);

       price = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the item's price:", "Zahran", JOptionPane.PLAIN_MESSAGE, icon, null, "").toString());
        quantity= Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the item's quanty", "Zahran", JOptionPane.PLAIN_MESSAGE, icon, null, "").toString());

        Item it=new Item((String)options1[name],quantity,price);
        sh.add(it);


        int choice;
        boolean flag;
        int input=JOptionPane.showConfirmDialog(null,"Proceed to checkout?","Zahran",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE,icon);
        
        if(input==0){
            flag=false;
        }
        else{
            flag= true;}



            while(flag==true){
            	 name= JOptionPane.showOptionDialog(null,"Enter the item you would like:","Zahran",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE,icon,
                         options1,null);
                price= Double.parseDouble(JOptionPane.showInputDialog(null,"Enter the item's price", "Zahran", JOptionPane.PLAIN_MESSAGE, icon, null, "").toString());
                quantity= Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the item's quanty", "Zahran", JOptionPane.PLAIN_MESSAGE, icon, null, "").toString());
                Item it1=new Item((String)options1[name],quantity,price);
                sh.add(it1);
                input=JOptionPane.showConfirmDialog(null,"Proceed to checkout?","Zahran",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE,icon);
                if(input==0){
                    flag=false;
                   break;

                }
                else {
                    flag= true;
                }

            }
            Object[] options2 = {"PayPal","CreditCard"};
            choice=JOptionPane.showOptionDialog(null,"Pick a payment method:","Zahran",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE,icon,
                    options2,null);
            PaymentMethod p1= null;
            if(choice==0){
                String email=JOptionPane.showInputDialog(null,"Enter the email:", "Zahran", JOptionPane.PLAIN_MESSAGE, icon, null, "").toString();
                String pass=JOptionPane.showInputDialog(null,"Enter the password:", "Zahran", JOptionPane.PLAIN_MESSAGE, icon, null, "").toString();
                int balance=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the balance", "Zahran", JOptionPane.PLAIN_MESSAGE, icon, null, "").toString());
                p1=new PayPal(email,pass,balance);
                JOptionPane.showMessageDialog(null,sh.checkout(p1,sh),"Zahran" ,JOptionPane.INFORMATION_MESSAGE, icon);
               
            }
            else if (choice==1) {
           
                Creditcard c1;
                Object[] options3 = {"Standard","Rewards"};
                String Holdername=JOptionPane.showInputDialog(null,"Enter the name:", "Zahran", JOptionPane.PLAIN_MESSAGE, icon, null, "").toString();
                String cardnu=JOptionPane.showInputDialog(null,"Enter the card number:", "Zahran", JOptionPane.PLAIN_MESSAGE, icon, null, "").toString();
                int cvv=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the cvv:", "Zahran", JOptionPane.PLAIN_MESSAGE, icon, null, "").toString());
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date exp = null;
                try {
                    exp = formatter.parse(JOptionPane.showInputDialog(null, "Enter the expiry date (dd/MM/yyyy):", "Zahran", JOptionPane.PLAIN_MESSAGE, icon, null, "").toString());
                } catch (ParseException e) {
                    JOptionPane.showMessageDialog(null, "Invalid date format. Please enter date in dd/MM/yyyy format.");
                    return; 
                }
                int balance=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the balance:", "Zahran", JOptionPane.PLAIN_MESSAGE, icon, null, "").toString());
                
                choice=JOptionPane.showOptionDialog(null,"Pick a type:","Zahran",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE,null,
                        options3,null);
                if (choice==1) {
                    c1 = new RewardsCreditCard(Holdername, cardnu, cvv, exp, balance);
                } else {
                    c1 = new StandardCreditCard(Holdername, cardnu, cvv, exp, balance);
                }
                JOptionPane.showMessageDialog(null, c1.applyAdditionalCharges(),"Zahran" ,JOptionPane.INFORMATION_MESSAGE, icon);
                JOptionPane.showMessageDialog(null, sh.checkout(c1,sh),"Zahran" ,JOptionPane.INFORMATION_MESSAGE, icon);
            }
            else {
            	JOptionPane.showMessageDialog(null,"Enter the right Payment Method","Zahran" ,JOptionPane.INFORMATION_MESSAGE, icon);
            }
            
          



        }

    }

