
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import javax.swing.SwingUtilities;

public class Main {

    public static void main (String[] args) {

        Airline sora =  new Airline("Sora Airlines", 4, 10, 10,10);
        sora.addFlight(new Flight("SA101","Sora Airlines","Singapore","Japan","1000","1800"));
        sora.addFlight(new Flight("SA102","Sora Airlines","Japan","Singapore","0900","2000"));
        sora.addFlight(new Flight("SA111","Sora Airlines","Thailand","Japan","1400","2300"));
        sora.addFlight(new Flight("SA112","Sora Airlines","Japan","Thailand","1100","2100"));

        Airline jal = new Airline("Japan Airlines", 2, 10, 10,10);
        jal.addFlight(new Flight("JA101","Japan Airlines","Singapore","Japan","1000","1815"));
        jal.addFlight(new Flight("JA102","Japan Airlines","Japan","Singapore","0915","2000"));

        Airline elec = new Airline("Electrical Airlines", 2, 10, 10,10);
        elec.addFlight(new Flight("EA101","Electrical Airlines","Singapore","Japan","1000","1840"));
        elec.addFlight(new Flight("EA102","Electrical Airlines","Japan","Singapore","0945","2010"));

        Airline rep = new Airline("Republic of Airways Airlines", 2, 10, 10,10);
        rep.addFlight(new Flight("RA101","Republic of Airways Airlines","Singapore","Japan","1030","1830"));
        rep.addFlight(new Flight("RA102","Republic of Airways Airlines","Japan","Singapore","0910","2030"));

        Airline[] airline = {sora, jal, elec, rep};

        List<Flight> flightList = new ArrayList<>();
        for(Airline a : airline){
            flightList.addAll(Arrays.asList(a.getFlights()));
        }

        Flight soraFlight1 = sora.getFlights()[0];
        Flight soraFlight2 = sora.getFlights()[1];
        Flight soraFlight3 = sora.getFlights()[2];
        Flight soraFlight4 = sora.getFlights()[3];

        User minami = new User("MinamiH", "Minami", "awesomepossum@gmail.com", "dumbo123");
        User satomi = new User("SatomiI", "Satomi", "amazingSatomi@gmail.com", "passwordo123");
        User[] users = {minami,satomi};
        
        List<User> userList = new ArrayList<>(Arrays.asList(users));
      

        Ticket[] tickets = new Ticket[4];

        tickets[0] =  new Ticket("A01", "Minami", soraFlight1, "A01", 150, "Cancelled","Credit Card","Special Case",minami);
        tickets[1] =  new Ticket("A02", "", soraFlight1, "A02", 150, "Available","Credit Card","Special Case",null);
        tickets[2] =  new Ticket("A03", "", soraFlight1, "A03", 150, "Available","Credit Card","Special Case",null);
        tickets[3] =  new Ticket("A04", "", soraFlight1, "A04", 150, "Available","Credit Card","Special Case",null);

    
        

        SwingUtilities.invokeLater(()->{
        MainGui login = new MainGui(userList,airline,tickets,flightList);
         login.setVisible(true);

         

        });
        




    }
    
}
