public class GoBus extends BusVendor {
    //Constructor for class GoBus
    public GoBus() {
        vendorName = "GoBus";
        //Trip objects are initialised and set using the setTrip method within the Trip class
        Trip T1 = new Trip();
        Trip T2 = new Trip();

        //Trip information for each trip object is set
        T1.setTrip(5043,"Portugal", "Claremorris", "05/03/2023", "04:22", "04/09/2026",
                "20:55", 2.99, 12);
        T2.setTrip(2000,"Dooblin", "Sligo", "18/12/2026", "07:26", "07/01/2028",
                "08:26", 4120.99, 600);

        //Trip information is added to an array list within the superclass
        totalTrips.add(T1);
        totalTrips.add(T2);
    }
}
