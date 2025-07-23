import java.lang.reflect.Array;
import java.util.List;

public class Airline {
    private String name;
    private Flight[] flights;
    private Ticket[] tickets;
    private User[] users;


    Airline(String name, int numofFlights, int numofTickets, int numofUsers){
        this.name = name;
        this.flights = new Flight[numofFlights];
        this.tickets = new Ticket[numofTickets];
        this.users = new User[numofUsers];
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
        return this.flights;
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

    
    public Flight addFlight(Flight Flight){
        return Flight;
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
