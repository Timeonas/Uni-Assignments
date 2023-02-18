

public class Trip {
    //Variables which holds all the necessary information about a trip
   private int tripId;
   private String originLocation;
   private String destinationLocation;
   private String departureDate;
   private String departureTime;
   private String arrivalDate;
   private String arrivalTime;
   private Double Fare;
   private int currSeatsAvailable;

    //Method to set trips
    public void setTrip(int tripId, String originLocation, String destinationLocation, String departureDate, String departureTime,
                        String arrivalDate, String arrivalTime, Double Fare , int currSeatsAvailable) {
        //Parses all the necessary information and assigns it to their respective variables
    this.tripId = tripId;
    this.originLocation = originLocation;
    this.destinationLocation = destinationLocation;
    this.departureDate = departureDate;
    this.departureTime = departureTime;
    this.arrivalDate = arrivalDate;
    this.arrivalTime = arrivalTime;
    this.Fare = Fare;
    this.currSeatsAvailable = currSeatsAvailable;
    }

    //To string method that's used to format and print each trip's information when called to print in the array
    @Override
    public String toString() {
        return
                "\nTrip ID: "+tripId+"\n"+
                "Origin Location: "+originLocation+"\n"+
                "Destination Location: "+destinationLocation+"\n"+
                "Departure Date: "+departureDate+"\n"+
                "Departure Time: "+departureTime+"\n"+
                "Arrival Date: "+arrivalDate+"\n"+
                "Arrival Time: "+arrivalTime+"\n"+
                "Fare: €"+Fare+" per passenger"+"\n"+
                "Currently available seats: "+currSeatsAvailable;
    }

    //Method used to decrement the number of available seats for a trip after a booking
    public void bookSeats(int seatsBooked) {
        currSeatsAvailable -= seatsBooked;
    }


    //Getter methods
    public int getCurrSeatsAvailable() {
        return currSeatsAvailable;
    }

    public String getOriginLocation() {
        return originLocation;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public int getTripId() {
        return tripId;
    }

    public Double getFare() {
        return Fare;
    }
}
