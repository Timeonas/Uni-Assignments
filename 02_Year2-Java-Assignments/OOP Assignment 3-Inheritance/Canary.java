
public class Canary extends Bird
{
    //Name associated with this specific Canary.
    String name;

    /**
     * Constructor for objects of class Canary
     */
    public Canary(String name)
    {
        //Constructor of superclass Bird is called
        super();
        this.name = name;
        //Colour inherited from the superclass is overwritten
        colour = "yellow";
    }
    
    /**
     *Methods
     */
    //Sing method is overridden from its superclass
    @Override
    public void sing(){
        System.out.println("\ttweet tweet tweet");
    }

    /**
     *toString and equals methods.
     */
    //The equals method needs to be overridden because all classes inherit from the default Object class
    @Override
    public boolean equals(Object o) {
        //Object is checked to see if it's an instance of Canary

        if (!(o instanceof Canary )) {
            return false;
        }
        
         //If it is, object passed into method is cast to an object of type canary
        //and its variables are also compared
        Canary p = (Canary)o;

        //Each variable of a typical canary is compared with the object passed into the method
        //If there is a discrepancy, the method outputs false

        if (hasFeathers != p.hasFeathers){
            return false;
        }
        //Compares two strings using the Java String class equals method that is not overridden
        //If two strings are equal, equals() returns true
        else if (!(name.equals(p.name))){
            return false;
        }
        else if (hasWings != p.hasWings){
            return false;
        }

        else if(hasSkin != p.hasSkin){
            return false;
        }
        //If all checks passed, and the final check is true, that is returned to main.
        //If the final check is false, false is returned to main.
        else return breathes == p.breathes;
    }

    //Every class also has a default implementation of a toString method, therefore it needs to be overridden
    @Override
    public String toString(){
        return
                "\t---Animal: Canary---"+
                "\n\tName of Canary: "+name+
        //Canary's superclass, bird will use the get method that it has inherited from its superclass animal.
                "\n\tColour of Canary: "+super.getColour()+
                "\n\tDoes a Canary have Skin?: "+super.hasSkin()+
                "\n\tDoes a Canary breathe?: "+super.getBreathe()+
                "\n\tDoes a Canary have feathers?: "+hasFeathers()+
                "\n\tDoes a Canary have wings?: "+hasWings()+
                "\n\tCan a Canary fly?: "+getFly()+
                "\n";
    }
}
