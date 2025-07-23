

public class Flight {

    private String flightNumber;
    private String airline;
    private String source;
    private String destination;
    private String departureTime; //LocalDateTime
    private String arrivalTime;  // LocaDateTime
    private String availableSeats;

    public Flight( String flightNumber, String airline, String source, String destination, String departureTime, String arrivalTime){
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public void setflightNumber(String flightNumber){
        this.flightNumber = flightNumber;
    }

    public String getflightNumber(){
        return this.flightNumber;
    }

    public void setAirline(String airline){
        this.airline = airline;
    }

    public String getAirline(){
        return this.airline;
    }

    public void setSource(String source){
        this.source = source;
    }

    public String getSource(){
        return this.source;
    }

    public void setDestination(String destination){
        this.destination = destination;
    }

    public String getDestination(){
        return this.destination;
    }

    public void setDepartureTime(String departureTime){
        this.departureTime= departureTime;
    }

    public String getDepartureTime(){
        return this.departureTime;
    }

    public void setArrivalTime(String arrivalTime){
        this.arrivalTime = arrivalTime;
    }

    public String getArrivalTime(){
        return this.arrivalTime;
    }

    public void setAvailableSeats(String availableSeats){
        this.availableSeats= availableSeats;
    }
    

    public String getAvailableSeats(){
        return this.availableSeats;
    }

    public String toString(){
        return "hello";
    }

   



// flightNumber: String
// - airline: String done
// - source: String done
// - destination: String done 
// - departureTime: LocalDateTime / String done
// - arrivalTime: LocalDateTime / String done
// - availableSeats: int[][] / String done
// +Flight (String, String, String,
// LocalDateTime / String, LocalDateTime
// / String)
// + accessor methods `
// + toString(): String
    
}
