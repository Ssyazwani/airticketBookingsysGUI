import javax.swing.SwingUtilities;

public class Main {

    public static void main (String[] args) {

        Airline sora =  new Airline("Sora Airlines", 10, 10, 10,10);
        sora.addFlight(new Flight("SA101","Sora Airlines","Singapore","Japan","1000","1800"));
        sora.addFlight(new Flight("SA102","Sora Airlines","Japan","Singapore","0900","2000"));
        sora.addFlight(new Flight("SA111","Sora Airlines","Thailand","Japan","1400","2300"));
        sora.addFlight(new Flight("SA112","Sora Airlines","Japan","Thailand","1100","2100"));

        Airline jal = new Airline("Japan Airlines", 10, 10, 10,10);
        jal.addFlight(new Flight("JA101","Japan Airlines","Singapore","Japan","1000","1815"));
        jal.addFlight(new Flight("JA102","Japan Airlines","Japan","Singapore","0915","2000"));

        Airline elec = new Airline("Electrical Airlines", 10, 10, 10,10);
        elec.addFlight(new Flight("EA101","Electrical Airlines","Singapore","Japan","1000","1840"));
        elec.addFlight(new Flight("EA102","Electrical Airlines","Japan","Singapore","0945","2010"));

        Airline rep = new Airline("Republic of Airways Airlines", 10, 10, 10,10);
        rep.addFlight(new Flight("RA101","Republic of Airways Airlines","Singapore","Japan","1030","1830"));
        rep.addFlight(new Flight("RA102","Republic of Airways Airlines","Japan","Singapore","0910","2030"));

        Airline[] airline = { sora, jal, elec, rep};

        
        User[] users = {
             new User("MinamiH", "Minami", "awesomepossum@gmail.com", "dumbo123"),
             new User("SatomiI", "Satomi", "amazingSatomi@gmail.com", "passwordo123"),
        };

       // Ticket[] tickets ={
       //     new Ticket("001", "Syaz", getFlight("Singapore Airline"), "A01",100,"Approved"),
       // };
        SwingUtilities.invokeLater(()->{
        MainGui login = new MainGui(users,airline);
         login.setVisible(true);

         

        });
        




    }
    
}
