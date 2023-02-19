
/**
 * Payment System.
 * @author Tim Samoska
 * @version 14/10/22
 */
public class Payment
{
    private Customer customer;
    private Address billing;
    private int cardNum;
    private String expiry;
    private String cardType;
    
    //Boolean variable used to validate card info
    private boolean valid;
    
    /**
     * Constructor
     */
    public Payment(Customer customer, Address billing, String cardType, int cardNum, String expiry)
    {
        //Setting customer payment details
       this.customer = customer;
       this.billing = billing;
       this.cardType = cardType;
       this.cardNum = cardNum;
       this.expiry = expiry;
       //Card infomation needs to be validated.
       valid = validCardType();
       
    }

    /**
     Methods
     */
    public boolean validCardType()
    {
        //If cardtype entered equals visa or mastercard, return true
        if(cardType.equalsIgnoreCase("visa") || cardType.equalsIgnoreCase("mastercard")){
            return true;
        }
        else 
        {
            return false;
        }
    }
    
    public boolean isValid() {
        return valid;
    }
    
     public Address getBilling() {
        return billing;
    }
    
    public Address getBillingAddress() {
        return billing;
    }
}
