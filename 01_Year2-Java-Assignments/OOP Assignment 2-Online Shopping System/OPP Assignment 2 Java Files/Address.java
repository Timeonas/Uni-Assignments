
/**
 * Addresses of each customer.
 * @author Tim Samoska
 * @version 14/10/22
 */
public class Address
{
    private String street;
    private String zipCode;
    private String city;
    private String country;
    
    /**
     * Constructor 
     */
    public Address(String street, String city, String zipCode, String country)
    {
        //Setting Address for each customer
        this.street = street;
        this.city= city;
        this.zipCode = zipCode;
        this.country = country;
    }

    /**
       Mutator Methods
     */
    public void setStreet(String street) {
        this.street = street;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    /**
       Accessor Methods
     */
     public String getStreet() {
        return street;
    }

    public String getZipCode() {
        return zipCode;
    }
    
    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
