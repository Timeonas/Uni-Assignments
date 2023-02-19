
public class Trout extends Fish {
    //Name of Trout
    String name;

    //Properties and values associated with each fish
    boolean hasSpikes;
    boolean isEdible;

    /**
     * Constructor for objects of class Trout
     */
    public Trout(String name) {
        //Constructor of superclass Fish is called
        super();
        this.name = name;
        hasSpikes = true;
        isEdible = true;
        //Colour of this particular fish is set
        colour = "brown";
    }

    /**
     * Methods
     */
    //The move method in superclass fish is overridden to print a message specific to the trout
    @Override
    public void move(int distance){
        System.out.printf("\n\tI swim upriver for %d metres to lay eggs", distance);
    }


    /**
     *toString and equals methods.
     */
    //The equals method needs to be overridden because all classes inherit from the default Object class
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Trout)) {
            return false;
        }
        
            Trout p = (Trout)o;

        if (hasSpikes != p.hasSpikes){
            return false;
        }
        //true is returned if there's a match
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
                "\t---Animal: Trout---" +
                "\n\tName of Trout: " + name +
                //Trout's superclass, shark will use the get method that it has inherited from its superclass animal.
                "\n\tColour of Trout: " + super.getColour() +
                "\n\tDoes a Trout have Skin?: " + super.hasSkin() +
                "\n\tDoes a Trout breathe?: " + super.getBreathe() +
                "\n\tDoes a Trout have Fins?: " + getFins() +
                "\n\tDoes a Trout have Gills?: " + getGills() +
                "\n\tDoes a Trout have Spikes?: " + hasSpikes +
                "\n\tIs a Trout edible?: " + isEdible +
                "\n";
    }

}
