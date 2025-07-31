public class Ticket {

    private String ticketNumber;
    private String passenger;
    private Flight flight;
    private String seatNumber;
    private double price;
    private String status;
    private String paymentMethod;
    private String confirmationNum;
    private User owner;

    public Ticket (String ticketNumber, String passenger, Flight flight, String seatNumber, double price,String status,String paymentmethod, String confirmationNum, User owner){
        this.ticketNumber = ticketNumber;
        this.passenger = passenger;
        this.flight = flight;
        this.seatNumber = seatNumber;
        this.price = price;
        this.status = status;
        this.paymentMethod = paymentmethod;
        this.confirmationNum = confirmationNum;
        this.owner = owner;
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

    public void setPaymentMethod(String paymentMethod){
        this.paymentMethod=paymentMethod;
    }

    public String getPaymentMethod(){
        return this.paymentMethod;
    }

    public void setConfirmationNum(String confirmationNum){
        this.confirmationNum=confirmationNum;
    }

    public String getConfirmationNum(){
        return this.confirmationNum;
    }

    public boolean isAvailable(){
        return"Available".equalsIgnoreCase(status);
    }

    public boolean isConfirmed(){
        return"Confirmed".equalsIgnoreCase(status);
    }

    public boolean isCancelled(){
        return"Cancelled".equalsIgnoreCase(status);
    }

     public void setOwner(User owner){
        this.owner = owner;
    }

    public User getOwner(){
        return this.owner;
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
