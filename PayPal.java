package OOP;

public class PayPal implements PaymentMethod {
    private String Accountemail;
    private String Accountpassword;
    private int Accountbalance;


    public PayPal(String accountemail, String accountpassword, int accountbalance) {
        Accountemail = accountemail;
        Accountpassword = accountpassword;
        Accountbalance = accountbalance;
    }

    public String getAccountemail() {
        return Accountemail;
    }

    public void setAccountemail(String accountemail) {
        Accountemail = accountemail;
    }

    public String getAccountpassword() {
        return Accountpassword;
    }

    public void setAccountpassword(String accountpassword) {
        Accountpassword = accountpassword;
    }

    public int getAccountbalance() {
        return Accountbalance;
    }

    public void setAccountbalance(int accountbalance) {
        Accountbalance = accountbalance;
    }

    @Override
    public boolean isValid() {
        String emailRegex = "^[a-zA-Z0-9._+]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,7}$";
        String passswordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"`~,.<>\\/?]).*$";
        if (Accountemail.matches(emailRegex) && Accountpassword.length() >= 8 && Accountpassword.matches(passswordRegex)) {
            return true;
        }
        return false;


    }

    @Override
    public String pay(int amount,ShoppingCart s) {
        if (isValid()==true) {
        	Accountbalance-= amount;
        	 if(s.getTotalAmount()<Accountbalance) {
                 return "successful";
             }
                 else {
                 	return "failed";
                 }
            
        }
        else{
            return "Not Valid";
        }
        
            

    }
}
