
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import javax.swing.SwingUtilities;

public class Main {

    public static void main (String[] args) {

        Airline sora =  new Airline("Sora Airlines", 2, 10, 5,2);
        sora.addFlight(new Flight("SA101","Sora Airlines","Singapore","Japan","1000","1800"));
        sora.addFlight(new Flight("SA102","Sora Airlines","Japan","Singapore","0900","2000"));
        

        Airline jal = new Airline("Japan Airlines", 2, 5, 5,2);
        jal.addFlight(new Flight("JA101","Japan Airlines","Japan","Thailand","1000","1815"));
       

        Airline elec = new Airline("Electrical Airlines", 2, 5, 5,1);
        elec.addFlight(new Flight("EA101","Electrical Airlines","Singapore","South Korea","1000","1840"));
       

        Airline rep = new Airline("Republic of Airways Airlines", 1, 5, 10,1);
        rep.addFlight(new Flight("RA101","Republic of Airways Airlines","Singapore","Japan","1030","1830"));
        

        Airline[] airline = {sora, jal, elec, rep};

        List<Flight> flightList = new ArrayList<>();
        for(Airline a : airline){
            flightList.addAll(Arrays.asList(a.getFlights()));
        }

        Flight soraFlight1 = sora.getFlights()[0];
        Flight soraFlight2 = sora.getFlights()[1];

        Flight jalFlight1 = jal.getFlights()[0];

        Flight elecFlight1 = elec.getFlights()[0];

        Flight repFlight1 = rep.getFlights()[0];

        User minami = new User("MinamiH", "Minami", "awesomepossum@gmail.com", "dumbo123");
        User satomi = new User("SatomiI", "Satomi", "amazingSatomi@gmail.com", "passwordo123");
        User[] users = {minami,satomi};
        
        List<User> userList = new ArrayList<>(Arrays.asList(minami,satomi));

        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket("A01", "Minami", soraFlight1, "A01", 150, "Cancelled","Credit Card","Special Case",minami));
        tickets.add(new Ticket("A02", "Minami", soraFlight1, "A02", 150, "Available","","",null));
        tickets.add(new Ticket("A03", "Minami", soraFlight1, "A03", 150, "Available","","",null));
        tickets.add(new Ticket("A04", "Minami", soraFlight1, "A04", 150, "Available","","",null));
        tickets.add(new Ticket("A05", "Minami", soraFlight1, "A05", 150, "Available","","",null));

        tickets.add(new Ticket("A06", "Minami", soraFlight2, "B01", 150, "Cancelled","Credit Card","Special Case",minami));
        tickets.add(new Ticket("A07", "Minami", soraFlight2, "B02", 150, "Cancelled","Credit Card","Special Case",minami));
        tickets.add(new Ticket("A08", "Minami", soraFlight2, "B03", 150, "Available","","",null));
        tickets.add(new Ticket("A09", "Minami", soraFlight2, "B04", 150, "Available","","",null));
        tickets.add(new Ticket("A10", "Minami", soraFlight2, "B05", 150, "Available","","",null));
        
        tickets.add(new Ticket("A11", "Minami", jalFlight1, "C01", 150, "Available","Credit Card","Special Case",minami));
        tickets.add(new Ticket("A12", "Minami", jalFlight1, "C02", 150, "Available","Credit Card","Special Case",minami));
        tickets.add(new Ticket("A13", "Minami", jalFlight1, "C03", 150, "Available","Credit Card","Special Case",minami));
        tickets.add(new Ticket("A14", "Minami", jalFlight1, "C04", 150, "Cancelled","Credit Card","Special Case",minami));
        tickets.add(new Ticket("A15", "Minami", jalFlight1, "C05", 150, "Cancelled","Credit Card","Special Case",minami));

       tickets.add(new Ticket("A16", "Minami", elecFlight1, "D01", 150, "Cancelled","Credit Card","Special Case",minami));
       tickets.add(new Ticket("A17", "Minami", elecFlight1, "D02", 150, "Available","Credit Card","Special Case",minami));
       tickets.add(new Ticket("A18", "Minami", elecFlight1, "D03", 150, "Cancelled","Credit Card","Special Case",minami));
       tickets.add(new Ticket("A19", "Minami", elecFlight1, "D04", 150, "Available","Credit Card","Special Case",minami));
       tickets.add(new Ticket("A20", "Minami", elecFlight1, "D05", 150, "Available","Credit Card","Special Case",minami));
        
      tickets.add(new Ticket("A21", "Minami", repFlight1, "E01", 150, "Cancelled","Credit Card","Special Case",minami));
      tickets.add(new Ticket("A22", "Minami", repFlight1, "E02", 150, "Cancelled","","Special Case",minami));
      tickets.add(new Ticket("A23", "Minami", repFlight1, "E03", 150, "Available","","Special Case",null));
      tickets.add(new Ticket("A24", "Minami", repFlight1, "E04", 150, "Available","","Special Case",null));
      tickets.add(new Ticket("A25", "Minami", repFlight1, "E05", 150, "Cancelled","","",null));
      
        SwingUtilities.invokeLater(()->{
        MainGui login = new MainGui(userList,airline,tickets,flightList);
         login.setVisible(true);

         

        });
        




    }
    
}
