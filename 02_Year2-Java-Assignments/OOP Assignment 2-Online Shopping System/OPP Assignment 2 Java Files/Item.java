
/**
 * Items that go into the shopping cart.
 * @author Tim Samoska
 * @version 14/10/22
 */
public class Item
{
//Instance variables are declared
    private String name;
    private int price;
    private long itemID;
    
    public Item(String name, long itemID)
    {
    this.name = name;
    this.itemID = itemID;
    }

    /**
     *Accessor Methods
     */
    public void setPrice(int price)
    {
        this.price = price;
    }
    
    /**
     * Mutator Methods
     */
    public int getPrice(){
        return price;
    }
    
    @Override
    public String toString(){
        String out = "\tItem Id: "+itemID+"\t"+name+"\tPrice: "+price+"\n";
        return out;
    }
}
