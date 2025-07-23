public class Ticket {

    private String ticketNumber;
    private String passenger;
    private Flight flight;
    private String seatNumber;
    private double price;
    private String status;

    public Ticket (String ticketNumber, String passenger, Flight flight, String seatNumber, double price,String status){
        this.ticketNumber = ticketNumber;
        this.passenger = passenger;
        this.flight = flight;
        this.seatNumber = seatNumber;
        this.price = price;
        this.status = status;
    }

    public void setTicketNumber(String ticketNumber){
        this.ticketNumber = ticketNumber;
    }

    public String getTicketNumber(){
        return this.ticketNumber;
    }

    public void setPassenger(String passenger){
        this.passenger = passenger;
    }

    public String getPassenger(){
        return this.passenger;
    }

    public void setFlight(Flight flight){
        this.flight = flight;
    }

    public Flight getFlight(){
        return this.flight;
    }

    public void setseatNumber(String seatNumber){
        this.seatNumber = seatNumber;
    }

    public String getseatNumber(){
        return this.seatNumber;
    }


    public void setPrice(double price){
        this.price = price;
    }

    public double getPrice(){
        return this.price;
    }


    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }


// - ticketNumber: String / int
// - passenger: String
// - flight: Flight
// - seatNumber: int[][] / String
// - price: double
// - status: String / int
// +Ticket (String / int, String,
// Flight, int[][] / String, double,
// String/ int)
    
}
