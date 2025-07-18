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

    
    public Flight addFlight(Flight Flight){
        return Flight;
    }

    

//   accessor methods
//  addFlight(Flight): Flight[]
//  updateFlight(Flight[]): void
//  deleteFlight(Flight): Flight[]
//  registerUser(User): User[]
//  updateUsers(User[]): void
//  viewTicket(Ticket[], Flight): void

    

    

    
}
