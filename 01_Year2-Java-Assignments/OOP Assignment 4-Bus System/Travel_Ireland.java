public class Travel_Ireland {
    public static void main(String[] args){
        //Bus vendor objects are initialized and inherit from BusService
        //New bus vendors can be easily added
        BusVendor BusEireann = new BusEireann();
        BusVendor CityLink = new CityLink();
        BusVendor GoBus = new GoBus();

        //Print all trips from each bus trip vendor to the console
        BusEireann.printTrips();
        CityLink.printTrips();
        GoBus.printTrips();


        //1)---Making A Booking with GoBus---
        //The user selects a trip they wish to book with a vendor
        Trip tripRequest1 = GoBus.getTrip(2000);
        //Making a booking for the associated trip and the number of passengers the booking is for.
        Booking booking1 = new Booking(tripRequest1,12);
        //Verifying information provided. Ticket is printed if everything is okay.
        GoBus.makeBooking(booking1, "GoBus");
        GoBus.printTrips();

        //2)---Making A Booking with CityLink---
        Trip tripRequest2 = CityLink.getTrip(1000);
        Booking booking2 = new Booking(tripRequest2,20);
        CityLink.makeBooking(booking2, "CityLink");
        CityLink.printTrips();

        //3)---Making A Booking with BusEireann---
        Trip tripRequest3 = BusEireann.getTrip(2323);
        Booking booking3 = new Booking(tripRequest3,2);
        BusEireann.makeBooking(booking3, "BusEireann");
        BusEireann.printTrips();

        //4)---Making A Booking when there are not many seats available---
        Trip tripRequest4 = BusEireann.getTrip(2323);
        Booking booking4 = new Booking(tripRequest4,200);
        BusEireann.makeBooking(booking4, "BusEireann");
        BusEireann.printTrips();

        //5)---Making A Booking with the incorrect trip ID---
        Trip tripRequest5 = BusEireann.getTrip(1000000);
        Booking booking5 = new Booking(tripRequest5,200);
        BusEireann.makeBooking(booking5, "BusEireann");
        BusEireann.printTrips();
    }
}
