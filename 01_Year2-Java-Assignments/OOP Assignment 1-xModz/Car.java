
/**
 * Car class for the car simulation.
 *
 * @author Tim
 * @version V1.0
 */
public class Car
{
    private String carName;
    private double distance;
    private double totalDistance;
    
    //A car has an engine and can access it
    private Engine engine;
  

    /**
     * Constructor
     */
    public Car(String carName)
    {
        this.carName = carName;
        //Setting total distance to 0 as the car hasnt moved after initial construction
        totalDistance = 0;
    }
    
    /**
        Car Methods
     */
   
     public void drive() {
         //At the beginning of each drive, new fuel is added and the distance is reset
        distance = 0;
        //The car calls on the engine to begin combustion and start driving.
        distance = engine.call();
        //The engine uses all of the fuel availible
        engine.setFuel(0);

        totalDistance += distance;
    }
    
    
     public void printState() {
        System.out.println("Configuration: Car Body "+carName);
        System.out.println("Engine name: "+engine.getEngineName());
        System.out.printf("Engine turns per litre: %.2f \n",engine.getEngineTpl());
        System.out.printf("Engine's total turn count: %d \n",engine.getEngineTurns());
        System.out.println("Wheel name: "+engine.getWheelName());
        System.out.printf("Wheel radius: %.2f\n",engine.getWheelRadius());
        System.out.printf("Wheel circumference (distance per turn): %.2f\n",engine.getWheelCir());
        System.out.printf("Distance this trip: %.2f\n",distance);
        System.out.printf("Total distance Travelled: %.2f\n",totalDistance);
        System.out.printf("Current fuel Status: %.2f\n",engine.getFuel());
        System.out.println();
    }
    
  /**
        Car Accessor and Mutator Methods
     */
    
    //Add method to add specific engine object to the car
    public void add(Engine engine){
        this.engine = engine;
    }
    
    //Another add method, but with a wheel argument.Since only the engine class has a wheel object, it will send the wheel as a parameter
    //to the engine's add method. 
     public void add(Wheel wheel){
        engine.add(wheel);
    }
    
    
    //Methods used to retrieve the current fuel levels from the engine class by calling the engines mutator/accessor methods
    public void setFuel(double fuelLevel) {
        engine.setFuel(fuelLevel);
    }
    
    public double getFuel(){
        return engine.getFuel();
    }
    }