import javax.swing.*;
import java.awt.*;

public class BookTicketGui extends JFrame {
    private User loggedinUser;
    private Airline airline;
    private Airline[] airlines;

    public BookTicketGui(User user, Airline airline, Airline[] airlines){
        this.loggedinUser = user;
        this.airline = airline;
        this.airlines = airlines;

        setTitle("Available Flights");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columnNames = {
            "Flight Number","Airline","From","To", "Departure Time", "Arrival Time"
        };

        int totalFlights = 0;
        for(Airline a : airlines){
            if (a != null && a.getFlights() != null){
                totalFlights += a.getFlights().length;
            }
        }

        Flight[] allFlights = new Flight[totalFlights];

        int index =0;
        for(Airline a : airlines){
            for(Flight flight : a.getFlights()){
                if (flight != null){
                    allFlights[index]= flight;
                    index ++;
                }
            }

        }

       
        Object[][] data = new Object[totalFlights][6];

      
        for(int i =0; i< totalFlights;i++){
                Flight flight = allFlights[i];
                data[i][0] = flight.getflightNumber();
                data[i][1] = flight.getAirline();
                data[i][2] = flight.getSource();
                data[i][3] = flight.getDestination();
                data[i][4] = flight.getDepartureTime();
                data[i][5] = flight.getArrivalTime();
        }

        JTable table = new JTable(data,columnNames);
        add(new JScrollPane(table));
        setVisible(true);
    }


    
}
