import javax.swing.SwingUtilities;

public class Main {

    public static void main (String[] args) {

        Airline[] airline = {
            new Airline("Singapore Airlines", 10, 10, 10),
            new Airline("Japan Airlines", 10, 10, 10),
            new Airline("Electrical Airlines", 10, 10, 10),
            new Airline("Republic of Ways Airlines", 10, 10, 10),
        };

        User[] users = {
             new User("awesome", "Syaz", "awesomepossum@gmail.com", "dumbo123"),
        };

       // Ticket[] tickets ={
       //     new Ticket("001", "Syaz", getFlight("Singapore Airline"), "A01",100,"Approved"),
       // };
        SwingUtilities.invokeLater(()->{
        MainGui login = new MainGui(users);
         login.setVisible(true);

         

        });
        




    }
    
}
