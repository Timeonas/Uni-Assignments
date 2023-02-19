
/**
 * Customer class.
 * @author Tim Samoska
 * @version 14/10/22
 */

//Importing Random package to access random class.
import java.util.Random;
public class Customer
{
    //Customer data that will be associated with each customer
    private String fName;
    private String sName;
    private String emailAddress;
    
    //Non-changable modfier for the customerID variable. The ID will eventually hold a 
    //large value after many orders therefore it is of type long. 
    private final long customerID;
    
    public Customer(String fName, String sName, String emailAddress){
        this.fName = fName;
        this.sName = sName;
        this.emailAddress = emailAddress;
        customerID = createCustomerID();
    }
    
    private long createCustomerID(){
        //Instance of the random class imported is created
        Random generate = new Random();
        //Returns a randomly generated number between 0-99999998. One is added to avoid 
        //a "0" ID.
        return ((generate.nextInt(99999999)) + 1);
    }
    
    /**
     *  Accessor Methods
     */
    
    public long getID() {
        return customerID;
    }
    
    public String getFName() {
        return fName;
    }
    
    public String getSName() {
        return sName;
    }
    
    public String getEmail(){
        return emailAddress;
    }
}
