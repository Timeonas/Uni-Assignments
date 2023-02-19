
/**
 * Wheel class for the car simulation.
 *
 * @author Tim
 * @version V1.0
 */
public class Wheel
{
    private double radius;
    private String name;
    private double circumference;

    /**
     * Constructor for objects of class Wheel
     */
    public Wheel(String name, double radius)
    {
        this.radius = radius;
        this.name = name; 
        //Upon the construction of the wheel, the circumference is calculated.
        circumference = 2 * Math.PI * radius;
    }
    
    
      /**
       Accessor Methods
     */
    
    //These methods are used to report details back to the engine class.
     public double turn() {
         return circumference;
     }
     
     public String getName(){
        return name;
    }
    
     public double getRadius(){
        return radius;
    }
    
}
