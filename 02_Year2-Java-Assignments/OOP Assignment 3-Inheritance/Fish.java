

public abstract class Fish extends Animal {
    //Values and properties associated with all fish
    boolean hasFins;
    boolean hasGills;

    public Fish()
    {
        //Constructor of superclass Animal is called
        super();
        hasFins = true;
        hasGills = true;
    }

    /**
     * Methods
     */

    //Fish methods that each individual type of fish will override
    @Override
    public void eat() {
        System.out.println("\n\tI eat other fish.");
    }

    @Override
    public void move(int distance) {
        System.out.printf("\n\tI swim for %d metres", distance);
    }

    /**
     * Getters
     */

    public boolean getFins() {
        return hasFins;
    }

    public boolean getGills() {
        return hasGills;
    }
}
