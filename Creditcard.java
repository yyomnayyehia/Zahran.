package OOP;

import java.util.*;

public abstract class Creditcard implements PaymentMethod {
private String cardholdername;
private String cardnumber;
private int cvv;
private Date expirydate;
private int balance;

    public Creditcard(String cardholdername, String cardnumber, int cvv, Date expirydate, int balance) {
        this.cardholdername = cardholdername;
        this.cardnumber = cardnumber;
        this.cvv = cvv;
        this.expirydate = expirydate;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getCardholdername() {
        return cardholdername;
    }

    public void setCardholdername(String cardholdername) {
        this.cardholdername = cardholdername;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public Date getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(Date expirydate) {
        this.expirydate = expirydate;
    }

    @Override
    public boolean isValid() {
        Date current = new Date();
        if (expirydate.after(current)){
            return true;
        }
        return false;
    }

    @Override
    public String pay(int amount,ShoppingCart s) {
        if (isValid()==true) {
            balance-= amount;
            if(s.getTotalAmount()<balance) {
            return"successful";
        }
            else {
            	return "failed";
            }
        }
        else{
            return "Not Valid";
        }
        
            

    }
    
    public abstract String applyAdditionalCharges();

}
