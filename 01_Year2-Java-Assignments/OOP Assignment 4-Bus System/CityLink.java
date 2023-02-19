public class CityLink extends BusVendor {
    //Constructor for class CityLink
    public CityLink() {
        vendorName = "CityLink";
        //Trip objects are initialised and set using the setTrip method within the Trip class
        Trip T1 = new Trip();
        Trip T2 = new Trip();

        //Trip information for each trip object is set
        T1.setTrip(1000,"Claremorris", "Galway", "10/12/2022", "08:15", "10/12/2022",
                "10:15", 3.99, 30);
        T2.setTrip(1001,"Galway", "Limerick", "10/12/2022", "10:20", "10/12/2022",
                "13:30", 15.99, 46);

        //Trip information is added to an array list within the superclass
        totalTrips.add(T1);
        totalTrips.add(T2);
    }
}
