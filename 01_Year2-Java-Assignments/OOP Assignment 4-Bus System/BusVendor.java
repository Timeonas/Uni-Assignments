import java.util.ArrayList;

//Abstract class, each respective vendor inherits from this class
public abstract class BusVendor {
    String vendorName; //Name of specific vendor, each vendor has a name
    ArrayList<Trip> totalTrips = new ArrayList<>();//Array list to hold all information regarding each trip available from each vendor

    //Variable used to return the wrong ID if entered by the user
    int errorId=0;

    //Method to print all available trips associated with each vendor
    private void printVendorTrips(ArrayList<Trip> totalTrips) {
        System.out.println("\nTrips available from bus vendor "+vendorName);
        System.out.println("--------------------------");
    //Loop through each vendor's trips and call the trip's toString method
        for (Trip trip : totalTrips) {
            System.out.println(trip);
        }
    }

    //Method used to communicate with main
    public void printTrips(){
        printVendorTrips(totalTrips);
    }

    //Method used to locate appropriate trip information from the id provided when making a booking
    public Trip getTrip(int reqTripID){
        //Loop through each available trip in the system until the requested id is found
        for (Trip trip:totalTrips) {
            if(trip.getTripId()==reqTripID){
                return trip;
            }
        }
        //If it cant be found, store the requested ID and return null.
        //Null will signify that the ID couldn't be found
        errorId = reqTripID;
        return null;
    }

    //Method to set the booking with the bus service
    public void makeBooking(Booking booking, String Vendor){
        //If the requested trip cant be found using the provided ID, inform the user
        if(booking.getBookedTrip() == null){
            System.out.println("\nCould not find requested trip ID "+errorId+", try again.");
        }
        else {
            //If the trip was found, parse the trip's available seats
            int availSeats = booking.getBookedTrip().getCurrSeatsAvailable();
            int bookSeats = booking.getNumPass();
            //Check to see if the value after decrementing the available seats with the booked seats will be greater than 0
            if((availSeats-bookSeats)>=0){
                //If there will be seats left, call the bookseats method to decrement the available seats value for the trip
                 booking.getBookedTrip().bookSeats(bookSeats);
                 //Print the ticket with all the necessary information to the console
                 booking.printTicket(Vendor);
            }
            else{
                //If there arent enough seats, inform the user
                System.out.println("\nSorry, there are not "+booking.getNumPass()+" seats available on trip ID "+booking.getBookedTrip().getTripId()+" with vendor "+Vendor);
                System.out.println("Booking Failed!");
            }
        }

    }


}
