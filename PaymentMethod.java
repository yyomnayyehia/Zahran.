package OOP;

public interface PaymentMethod {
    public boolean isValid();
    public String pay(int amount,ShoppingCart s);
}
