public class BusEireann extends BusVendor {
    //Constructor for class BusEireann
    public BusEireann() {
        vendorName = "BusEireann";
        //Trip objects are initialised and set using the setTrip method within the Trip class
        Trip T1 = new Trip();
        Trip T2 = new Trip();

        //Trip information for each trip object is set
        T1.setTrip(4232,"Galway", "Kiltimagh", "15/11/2022", "15:42", "07/04/2023",
                "23:55", 234.99, 40);
        T2.setTrip(2323,"Ballina", "Foxford", "15/01/2023", "00:22", "12/11/2023",
                "18:41", 20.99, 54);

        //Trip information is added to an array list within the superclass
        totalTrips.add(T1);
        totalTrips.add(T2);
    }
}
