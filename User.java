public class User {

    private String userId;
    private String name;
    private String email;
    private String password;

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

    public boolean Login(String userId, String password){
        if (userId.equals(userId) && password.equals(password)){
            return true;
        } else {
            return false;
        }
    }

    public void Logout(String userId){
        
    }

    public boolean bookTicket(Ticket ticket){
        return true;
    }

    public void cancelTicket(Ticket ticket){

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
