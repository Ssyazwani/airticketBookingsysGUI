import java.util.ArrayList;
import java.util.List;

public class User {

    private String userId;
    private String name;
    private String email;
    private String password;
    private List<Ticket> canceledTickets = new ArrayList<>();
  

    public User( String userId, String name,String email,String password){
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void setUserId(String userId){
        this.userId = userId;

    }

    public String getUserId(){
       return  this.userId;
    }

    public void setName(String name){
        this.name= name;
    }

    public String getName(){
        return this.name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

   

    public boolean login(String userId, String password){
        return this.userId.equals(userId) && this.password.equals(password);
         
    }

    public void Logout(String userId){
    	if(this.userId.equals(userId)) {
    		System.out.println("User "+ userId + "logged out");
    	}
        
    }

    public boolean bookTicket(Ticket ticket){
        if(ticket.isAvailable()){
            ticket.setOwner(this);
            ticket.setPassenger(this.name);
            ticket.setStatus("Confirmed");
            return true;
        }

        return false;
    }

    public void cancelTicket(Ticket ticket){
        if(ticket.isConfirmed() && ticket.getOwner() != null && ticket.getOwner().equals((this))){
        ticket.setStatus("Cancelled");
        ticket.setPassenger(null);
        ticket.setPaymentMethod(null);
        ticket.setConfirmationNum(null);

    }
      canceledTickets.add(ticket);


}

   public List<Ticket> getCanceledTickets(){
        return canceledTickets;
    }


    


// - userId: String done
// - name: String done
// - email: String done
// - password: String done
// + User (String, String, String, String) done
// + accessor methods done
// + login (String, String): boolean done
// + logout (String): void
// + bookTicket (Ticket): Boolean
// + cancelTicket(Ticket)
    
}
