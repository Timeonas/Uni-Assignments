
public abstract class Animal
{
    //Variables associated with each animal
    boolean hasSkin;
    boolean breathes;
    String colour;
    
    /**
     * Constructor for objects of class Animal
     */
    public Animal()
    {
        //All subclasses of Animal inherit these properties and values.
        breathes = true;
        hasSkin = true;
        colour = "grey";
    }
    /**
     *Methods that all subclasses inherit
     */
    //Move method that the leaf classes will override to suit their own methods of travel
    public void move(int distance){

        System.out.printf("\n\tI move %d metres \n", distance);
    }

    //Eat method that each animal inherits
    public void eat() {

        System.out.println("I eat");
    }
        
    /**
     * Getters
     */
    public String getColour(){
        return colour;
    }

    public boolean hasSkin(){
        return hasSkin;
    }

    public boolean getBreathe(){
        return breathes;
    }
}
