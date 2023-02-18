public class Booking {
    private final Trip bookedTrip;
    private final int numPass;
    public Booking(Trip bookedTrip, int numPass){
            //Trip information is stored
            this.bookedTrip = bookedTrip;
            //Number of passengers for the booking is also stored
            this.numPass = numPass;
    }

    public void printTicket (String Vendor){
        //Upon a successful verification of the booking, the booking is placed and a ticket is printed
        System.out.println("\nBooking Successful!");
        System.out.println("Booking for "+numPass+" has been placed!");
        System.out.println("=============================");
        System.out.println("Bus Vendor: "+Vendor);
        System.out.println("Number of Passengers: "+numPass);
        System.out.println("Trip Details: ["+bookedTrip.getOriginLocation()+"] to ["+bookedTrip.getDestinationLocation()+"]");
        System.out.println("Trip ID: "+bookedTrip.getTripId());
        System.out.printf("\nTotal Cost: €%.2f\n",(bookedTrip.getFare())*numPass);
        System.out.println("=============================");
    }

    //Getter Methods
    public int getNumPass(){
        return numPass;
    }

    public Trip getBookedTrip(){
        return bookedTrip;
    }
}
