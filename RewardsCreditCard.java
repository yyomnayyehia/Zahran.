package OOP;

import java.util.Date;

public class RewardsCreditCard extends Creditcard{
	public RewardsCreditCard(String cardholdername, String cardnumber, int cvv, Date expirydate, int balance) {
        super(cardholdername, cardnumber, cvv, expirydate, balance);
    }
	@Override
	public String applyAdditionalCharges() {
        return "Rewards additional charges processing applied";
    }
}
