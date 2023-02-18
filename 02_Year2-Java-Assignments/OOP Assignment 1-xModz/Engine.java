
/**
 * Engine class for the car simulation.
 *
 * @author Tim
 * @version V1.3
 */
public class Engine
{
    private int totalTurns;
    private double tpl;
    private String name;
    
     //I've decided to put the fuel level inside the engine class as fuel is a fundamental part of the combustion process in a car. Ive also found it to design this simulation with
     //the fuel inside the engine object.
    private double fuelLevel;
    
    //An engine has a wheel.
    private Wheel wheel;
    
    /**
     * Constructor
     */
    public Engine(String name,double tpl)
    {
        this.tpl = tpl;
        this.name = name;
    }
    
    /**
     * Methods
     */
    
    public double call(){
        //As totalTurns needs to be incremented on each turn() method call, i've used a for loop to turn the wheels and keep track of the number of total turns.
        //The wheel will be turned as many times as the tpl specifies by the amount of total fuel availible
        for(int i = 0; i<(fuelLevel*tpl); i++){
            wheel.turn();
            totalTurns++;
        }
       //Once the engine has run out of fuel, the total distance travelled is returned to the car for it to report to the driver.
        return fuelLevel*(wheel.turn()*tpl);
    }
    
    /**
        Engine Accessor and Mutator Methods
     */
    
    public void setFuel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }
    
    public double getFuel(){
        return fuelLevel;
    }
    
    public String getEngineName(){
        return name;
    }
    
    public double getEngineTpl(){
        return tpl;
    }
    
    public int getEngineTurns(){
        return totalTurns;
    }

    public void add(Wheel wheel){
        this.wheel = wheel;
    }
    
    
    /**
     * Wheel Accessor Methods
     */
    
    //Methods used to retrieve specifc details from the wheel by calling the wheel class' mutator/accessor methods since only the engine can access the wheel
    public String getWheelName(){
        return wheel.getName();
    }
    
     public double getWheelRadius(){
        return wheel.getRadius();
    }
    
    public double getWheelCir(){
        return wheel.turn();
    }
    
     
}
