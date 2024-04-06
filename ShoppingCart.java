package OOP;

public class ShoppingCart {
    private Item[] OrderItems;
    private int ItemCount;
    private int Max_Items = 10;

    public ShoppingCart() {
        OrderItems =new Item[Max_Items];
        ItemCount =0;
    }
    public void add(Item item) {
        if (ItemCount<Max_Items) {
            OrderItems[ItemCount]=item;
            ItemCount++;
            System.out.println(item.getName()+" Sucessfuly added to the cart.");
        }
        else {
            System.out.println("Cart is full, can't add more items");

        }
    }
    public void remove(Item item) {
        int i;
        for(i=0;i<ItemCount;i++);{
            if(OrderItems[i].equals(item)) {
                OrderItems[i]=OrderItems[ItemCount-1];
                OrderItems[ItemCount-1]=null;
                ItemCount--;
                System.out.println(item.getName()+" Sucessfuly removed from the cart.");

            }
        }
        System.out.println("Item wasn't found in the cart");
    }

    public double getTotalAmount() {
        double tm =0;
        int i;
        for( i=0;i<ItemCount;i++) {
            tm+=OrderItems[i].getPrice()*OrderItems[i].getQuantity();
        }
        return tm;
    }
    public String checkout(PaymentMethod paymentMethod,ShoppingCart s) {
        double totalAmount = getTotalAmount();
        
        if (totalAmount >0) {
            return paymentMethod.pay((int) totalAmount,s)+" Your total amount is: $"+totalAmount;
        } else {
            return "The shopping cart is empty.";
        }
    }
}
