
/**
 * This class is used to generate output for the simulation
 *
 * @author Tim
 * @version V1.4
 */
public class TestCar
{
    public static void main(String[] args)
    {
        Car car = new Car("X7");
        Engine engine = new Engine("DR9", 43);
        car.add(engine);
        Wheel wheel = new Wheel("Wichelin15", 15);
        car.add(wheel);
        car.setFuel(100);
        System.out.printf("Current fuel: %.2f\n",car.getFuel());
        car.drive();
        car.printState();
        car.setFuel(50);
        System.out.printf("Current fuel: %.2f\n",car.getFuel());
        car.drive();
        car.printState();
    }
}
