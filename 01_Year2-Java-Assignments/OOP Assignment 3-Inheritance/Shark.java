
public class Shark extends Fish {
    //The name of the shark
    String name;

    //Properties associated with all sharks
    boolean isDangerous;

    /**
     * Constructor for objects of class Shark
     */
    public Shark(String name) {
        //Constructor of superclass Fish is called
        super();
        this.name = name;
        isDangerous = true;
    }

    /**
     * Methods
     */
    //Bite will be implemented as a method as it is an action.
    public void bite() {
        System.out.println("\tI bite");
    }


    /**
     *toString and equals methods.
     */

    //The equals method needs to be overridden because all classes inherit from the default Object class
    @Override
    public boolean equals(Object o) {
        
        if (!(o instanceof Shark)) {
            return false;
        }
        
        //p is cast to shark if it is an instance of shark
        Shark p = (Shark)o;

        if (isDangerous !=p.isDangerous){
            return false;
        }

        //Name of shark is compared, true is returned if there's a match
         else if (!(name.equals(p.name))){
             return false;
         }

        else if(hasFins != p.hasFins){
            return false;
        }
        else if(hasGills != p.hasGills) {
            return false;
        }

        else if(hasSkin != p.hasSkin){
            return false;
        }
        else return breathes == p.breathes;
    }

    //Default toString() method is overridden
    @Override
    public String toString() {
        return
                "\t---Animal: Shark---" +
                "\n\tName of Shark: " + name +
                //Shark's superclass, shark will use the get method that it has inherited from its superclass animal.
                "\n\tColour of Shark: " + super.getColour() +
                "\n\tDoes Shark have Skin?: " + super.hasSkin() +
                "\n\tDoes a Shark breathe?: " + super.getBreathe() +
                "\n\tDoes a Shark have Fins?: " + getFins() +
                "\n\tDoes a Shark have Gills?: " + getGills() +
                "\n\tIs a Shark Dangerous?: " + isDangerous+
                "\n";
    }
}
