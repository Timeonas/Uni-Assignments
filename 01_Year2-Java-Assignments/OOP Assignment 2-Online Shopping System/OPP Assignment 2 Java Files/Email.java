
/**
 * Email class.
 * @author Tim Samoska
 * @version 14/10/22
 */
public class Email
{
    
    private Order order;
    private String mail;
    /**
     * Constructor 
     */
    public Email(Order order)
    {
        this.order = order;
    }

    /**
     * Method used to create email and send it to the user
     */
    public void printMail(boolean valid)
    {
        //Printing positive message
        if(valid){
            mail = "\n"+"\tPayment Succeeded\n"+
            "\nEmail: "+order.getCustomer().getEmail()+
            "\nName: "+order.getCustomer().getFName()+" "+order.getCustomer().getSName()+
            "\nDelivery Address: \nStreet: "+order.getShipping().getStreet()+
            "\nCity: "+order.getShipping().getCity()+
            "\nZipCode: "+order.getShipping().getZipCode()+
            "\nCountry: "+order.getShipping().getCountry()+
            "\n"+
            "\nBilling Address: \nStreet: "+order.getPayment().getBilling().getStreet()+
            "\nCity: "+order.getPayment().getBilling().getCity()+
            "\nZipCode: "+order.getPayment().getBilling().getZipCode()+
            "\nCountry: "+order.getPayment().getBilling().getCountry()+
            "\n"+
            "\nOrder Number: "+ order.getOrderID()+
            "\nOrder Details:\n"+order;
        }
        else{
            mail = "\n"+"\tPayment Unsuccessful\n"+
            "\nEmail: "+order.getCustomer().getEmail()+
            "\nName: "+order.getCustomer().getFName()+" "+order.getCustomer().getSName()+
            "\nOrder Details:\n"+order;
        }
        System.out.println(mail);
    }
}
