
public abstract class Bird extends Animal
{
    boolean hasFeathers;
    boolean hasWings;
    boolean flies;

    /**
     * Constructor for objects of class Bird
     */
    public Bird()
    {
        //calls the constructor of its superclass  - Animal
        super();
        //All subclasses of Bird will inherit these properties and values
        colour = "black";
        hasFeathers = true;
        hasWings = true;
        flies = true;
    }

     /**
     * Methods
     */
    @Override
    //If a bird is unable to fly (flies = false), move will inform the console of that when
    //the state of move is printed. If a subclass cant fly, the move method in the superclass
    //will account for that.
    public void move(int distance){
        if(!flies){
            System.out.print("\n\tI am a bird but cannot fly");
        }
        else
            System.out.printf("\n\tI fly %d metres.", distance);
    }

    //Birds also sing, therefore a method is declared
    public void sing(){
        System.out.println("\ttra la la");
    }

    //Eat is overridden to print out a message specific to birds
    @Override
    public void eat() {
        System.out.println("\n\tI devour sunflower seeds.");
    }

    /**
     * Getters
     */
    public boolean hasWings(){
        return hasWings;
    }
    public boolean hasFeathers(){
        return hasFeathers;
    }
    public boolean getFly(){
        return flies;
    }
}
