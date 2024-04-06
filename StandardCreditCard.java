package OOP;

import java.util.Date;

public class StandardCreditCard extends Creditcard {
	public StandardCreditCard(String cardholdername, String cardnumber, int cvv, Date expirydate, int balance) {
        super(cardholdername, cardnumber, cvv, expirydate, balance);
    }
	 @Override
	    public String applyAdditionalCharges() {
	        return "Standard additional charges processing applied";
	    }
}
