
/**
 * Orders class.
 * @author Tim Samoska
 * @version 14/10/22
 */

import java.util.ArrayList;

public class Order
{
    private Customer customer;
    private ArrayList<Item> orders;
    private float total;
    private long orderNumberID = 0;
    private Payment payment;
    
    //Used to store customer's shipping address
    private Address shipping;
    
    public Order(ShoppingCart shoppingCart, Customer customer)
    {
        this.customer = customer;
        //Total price for items got using an accessor method
        total = shoppingCart.getTotal();
        //New orders list created
        orders = new ArrayList<>();
        //Transferring items from shopping cart into Orders list
        //Shopping cart items are cloned into orders array. Each item in the cart is accessed using an
        //accessor method in the cart that allows to access the cart item. Each item is assigned into
        //Orders array
        for (Item item : shoppingCart.getCartItems()) {
            orders.add(item);
        }
        //Once items in cart have been transferred to orders, cart is closed.
         shoppingCart.closeCart();
         
         //Generating Unique Order number
         orderNumberID = createOrderID();
    }

    /**
    Methods
     */
      private long createOrderID(){
          //Used to keep track of total orders made in the shop
      //Whenever a new order is made, the ID is incremented.
      orderNumberID = orderNumberID + 1;
      return orderNumberID; 
    }
    
     public void setShipping(Address shipping) {
        this.shipping = shipping;
    }
    
     public long getOrderID() {
        return orderNumberID;
    }
    
    public Address getShipping() {
        return shipping;
    }
    
     public void setPayment(Payment payment) {
        this.payment = payment;
    }
    
    public Payment getPayment() {
        return payment;
    }
    
     public Customer getCustomer() {
        return customer;
    }
    
    @Override
    public String toString() {
        String out = "Total Cost: " + String.format("%.2f", total)+"\nItems Orders: \n";
        for (Item item : orders) {
            out += "\t- " + item + "\n";
        }
        return out;
    }
}
