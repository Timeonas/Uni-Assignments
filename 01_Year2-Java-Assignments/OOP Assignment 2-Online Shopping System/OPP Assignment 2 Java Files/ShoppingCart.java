
/**
 * Shopping cart for customers class.
 * @author Tim Samoska
 * @version 14/10/22
 */

//Java util package for arrays is imported
import java.util.ArrayList;

//Java time package is used to fetch current date and time
import java.time.LocalDateTime;
//Package used to format current date and time
import java.time.format.DateTimeFormatter;

public class ShoppingCart
{
    //Instance Variables for the customer's shopping cart
    
    //Unique Cart ID associated with the customer. In the beginning of shop, 
    //there are no carts created yet, therefore its intialized as 0.
    private long cartID = 0;
    
    //Array of Items
    private ArrayList<Item> cartItems;
    
    //A shopping cart has a customer. 
    private Customer customer;
    
    //Date and Time the cart was created for the customer
    private String time;
    
    //Total cost of all items
    private float totalPrice;
    
    //Boolean variable to keep track of the status of the cart (False = Open/ True = Closed)
    //Used for adding/removing items from the shopping cart. 
    private boolean cartClosedStatus = false;

    /**
     * Constructor 
     */
    public ShoppingCart(Customer customer)
    {
        this.customer = customer;
        //Shopping cart is created for the customer
        cartItems = new ArrayList<>();
        cartID = createCartID();
        
      //Time and Date the shopping cart was created unformatted
      LocalDateTime dateTime = LocalDateTime.now();
      //Desired format for date and time is generated using the datetimeformatter class imported
      DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
      //Formatted string is returned
      time = dateTime.format(dateTimeFormat);
      
      
    }
    
    /**
     * Methods
     */
    
     private long createCartID(){
        //Cart ID: As users create carts, the carts variable is incremented to generated a unique
        //number for each cart to keep on track with orders made to the system.
      
      //Whenever a new cart is made, the ID is incremented.
      return cartID++; 
    }
    
    
    //Add/Remove functionalities methods
    public void add(Item item){
        //If shopping cart is closed, alert user
        if (cartClosedStatus){
            System.out.println("Sorry the shopping cart is closed.");
            return;
        }
        //Else add requested item to array list(cart)
        cartItems.add(item);
        //Total price of items in cart are updated
        totalPrice = totalPrice + item.getPrice();
        return;
    }
    
     public void remove(Item item){
        //If shopping cart is closed, alert user
        if (cartClosedStatus){
            System.out.println("Sorry the shopping cart is closed.");
            return;
        }
        //Else remove requested item from array list(cart)
        
        //If the remove method from the arraylist class removes item successfully, the total
        //is updated by taking away the price of the item removed from the total.
        if(cartItems.remove(item)) {  
            totalPrice = totalPrice - item.getPrice();
            return;
        }
        
        //Else do nothing.
        return;
    }
    
    public void clearCart(){
        //The clear method clears everything in the arraylist
        cartItems.clear();
        //Total price of cart is reset
        totalPrice=0;
        System.out.println("The shopping cart has been cleared.");
        return;
    }
    
    public void closeCart(){
        //Cart is closed
        cartClosedStatus = true;
        System.out.println("The shopping cart has been closed.");
    }
    
     /**
     * Accessor Methods
     */
    
    public float getTotal() {
        return totalPrice;
    }
    
    public long getCartID(){
        return cartID;
    }
    
    public Customer getCustomer(){
        return customer;
    }
    
    //Accessor method used to get arraylist 
    public ArrayList<Item> getCartItems() {
        return cartItems;
    }
    
    /**
     * Printing items to string;
     */
    
    @Override
    public String toString(){
        String out = "Items in Cart:\n";
        for(Item item: cartItems){
            out+= "\t"+item+"\n";
        }
        return out;
    }
}
