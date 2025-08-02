

public class Airline {
    private String name;
    private Flight[] flights;
    private Ticket[] tickets;
    private User[] users;
    private int flightCount;


    public Airline(String name, int numofFlights, int numofTickets, int numofUsers, int flightCount){
        this.name = name;
        this.flights = new Flight[numofFlights];
        this.tickets = new Ticket[numofTickets];
        this.users = new User[numofUsers];
        this.flightCount =0;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setFlights(Flight[] flights){
        this.flights = flights;
    }

    public Flight[] getFlights(){
        Flight[] currentFlights = new Flight[flightCount];
        for(int i =0; i <flightCount;i++){
            currentFlights[i] = flights[i];
        }

        return currentFlights;
    }

    public void setTickets(Ticket[] tickets){
        this.tickets = tickets;
    }

    public Ticket[]getTickets(){
        return this.tickets;
    }

    public void setUsers(User[] users){
        this.users = users;
    }

    public User[] getUsers(){
        return this.users;
    }

    
    public void addFlight(Flight flight){
        if(flightCount < flights.length){
            flights[flightCount++] = flight;
        } else {
            System.out.println("Array full");
        }
    }

    public void updateFlight(Flight Flight){
        
    }

    public Flight deleteFlight(Flight Flight){
        return Flight;
    }

    public User[] registerUser(User user){
        return this.users;
    }

    public void updateUsers(User user){
        
    }

    public void viewTicket(Ticket ticket, Flight flight){

    }



    

//  addFlight(Flight): Flight[]
//  updateFlight(Flight[]): void
//  deleteFlight(Flight): Flight[]
//  registerUser(User): User[]
//  updateUsers(User[]): void
//  viewTicket(Ticket[], Flight): void

    

    

    
}
