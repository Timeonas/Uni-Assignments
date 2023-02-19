
public class Ostrich extends Bird {
    //Name of Ostrich
    String name;
    boolean isTall;
    boolean hasLongLegs;

    /**
     * Constructor for objects of class Ostrich
     */

    public Ostrich(String name)
    {
        //Constructor of superclass Bird is called
        super();
        this.name = name;
        isTall = true;
        hasLongLegs = true;
        flies = false;
    }

    /**
     *toString and equals methods.
     */

    //The equals method needs to be overridden because all classes inherit from the default Object class
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Ostrich )) {
            return false;
        }
        
        //p is cast to Ostrich.
        Ostrich p = (Ostrich)o;

        if (isTall != p.isTall){
            return false;
        }
        else if (hasLongLegs != p.hasLongLegs){
            return false;
        }
        //true is returned if there's a match
        else if (!(name.equals(p.name))){
            return false;
        }

        else if (flies != p.flies){
            return false;
        }

        else if(hasSkin != p.hasSkin){
            return false;
        }
        else return breathes == p.breathes;
    }

    //Every class also has a default implementation of a toString method, therefore it needs to be overridden
    @Override
    public String toString(){
        return
                "\t---Animal: Ostrich---"+
                "\n\tName of Ostrich: "+name+
                //Ostrich's superclass, bird will use the get method that it has inherited from its superclass animal.
                "\n\tColour of Ostrich: "+super.getColour()+
                "\n\tDoes an Ostrich have Skin?: "+super.hasSkin()+
                "\n\tDoes a Ostrich breathe?: "+super.getBreathe()+
                "\n\tDoes a Ostrich have feathers?: "+hasFeathers()+
                "\n\tDoes a Ostrich have wings?: "+hasWings()+
                "\n\tCan a Ostrich fly?: "+getFly()+
                "\n\tIs an Ostrich tall?: "+isTall+
                "\n\tDoes an Ostrich have long legs?: "+hasLongLegs+
                "\n";
    }
}
