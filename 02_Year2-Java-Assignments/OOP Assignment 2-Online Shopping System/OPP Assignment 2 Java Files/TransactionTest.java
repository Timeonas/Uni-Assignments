
/**
 * Testing transaction scenarios class.
 * @author Tim Samoska
 * @version 14/10/22
 */
public class TransactionTest
{
    /**
     *The start of the program
     */
    public static void main(String[] args)
    {
     TransactionTest test = new TransactionTest();
     //Tests for two scenarios
     test.firstTransaction();
     test.secondTransaction();
    }
    
    /**
     The first scenario to be tested
     */
    
    public void firstTransaction(){
        //A new customer who wishes to shop is created
        Customer customer1 = new Customer("Adam", "Gleeno", "tomatomran666@email.ie");
        
        //A shopping cart object is created for the customer. The customer
        //is assigned a shopping cart. A shopping cart has a customer. 
        ShoppingCart shoppingCart = new ShoppingCart(customer1);
        
        //Items with cost to be added the cart are created
        //Item 1
         System.out.println("\n Items Selected: \n");
        Item item1 = new Item("Samsung S20", 932472893);
        item1.setPrice(3422);
        System.out.println(item1);
        //Item 2
        Item item2 = new Item("Lenovo S332", 6368283);
        item2.setPrice(2000);
        System.out.println(item2);
        //Item 3
        Item item3 = new Item("Mineral Water",2433243);
        item3.setPrice(2);
        System.out.println(item3);
        //Adding the desired items to the customers cart
        shoppingCart.add(item1);
        shoppingCart.add(item2);
        shoppingCart.add(item3);
        System.out.println(shoppingCart);
        //Customer's Order is created
        Order order = new Order(shoppingCart, customer1);
        //Addresses of the Customer are set
        //Billing Address
        Address billing = new Address("47 Big Road", "Town","FJF34", "Poland");
        //Shipping Address
        Address shipping = new Address("54 Road", "Big Town","FHSDHU3", "Latvia");
        //Shipping Address is needed for the order to be shipped to the customer
        order.setShipping(shipping);
        //Payment details of the customer
         Payment payment1 = new Payment(customer1, billing, "Visa", 23439, "05/10/2078");
         order.setPayment(payment1);
        //Payment datails are validated
        Email email = new Email(order);
        if(payment1.isValid()){
             //If the card info is valid, Customer is emailed a success email and the total cost of items
                email.printMail(true);
        }
        else{
            System.out.println("There was a problem verifying your payment information");
            email.printMail(false);
        }
    }
    
    /**
     The second scenario to be tested
     */
    public void secondTransaction(){
           //A new customer who wishes to shop is created
        Customer customer2 = new Customer("Thomas", "Gleeno", "Yes66@email.ie");
        
        //A shopping cart object is created for the customer. The customer
        //is assigned a shopping cart. A shopping cart has a customer. 
        ShoppingCart shoppingCart = new ShoppingCart(customer2);
        
        //Items with cost to be added the cart are created
        //Item 1
        System.out.println("\n Items Selected: \n");
        Item item1 = new Item("Food", 932472893);
        item1.setPrice(9);
        System.out.println(item1);
        //Item 2
        Item item2 = new Item("Water", 6363);
        item2.setPrice(200);
        System.out.println(item2);
        //Item 3
        Item item3 = new Item("Pencil",2433243);
        item3.setPrice(20);
        System.out.println(item3);
        //Adding the desired items to the customers cart
        shoppingCart.add(item1);
        shoppingCart.add(item2);
        shoppingCart.add(item3);
        System.out.println(shoppingCart);
        
        shoppingCart.remove(item3);
        Order order = new Order(shoppingCart, customer2);
        
        //Billing Address
        Address billing = new Address("Greg Street", "YesTown","FJF34", "Ireland");
        //Shipping Address
        Address shipping = new Address("54 Road", "Big Town","FHSDHU3", "America");
        
        order.setShipping(shipping);
        
        Payment payment1 = new Payment(customer2, billing, "Risa", 23439, "05/10/2078");
         order.setPayment(payment1);
         
        Email email = new Email(order);
        if(payment1.isValid()){
             //If the card info is valid, Customer is emailed a success email and the total cost of items
                email.printMail(true);
        }
        else{
            System.out.println("There was a problem verifying your payment information");
            email.printMail(false);
        }
         
    }
}
