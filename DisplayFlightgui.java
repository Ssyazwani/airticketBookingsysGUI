import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class DisplayFlightgui extends JFrame {
    private User loggedinUser;
    private Airline airline;
    private Airline[] airlines;
    private Ticket[] tickets;
    private Flight selectedFlight;

    public DisplayFlightgui(User user, Airline airline, Airline[] airlines,Ticket[] tickets){
        this.loggedinUser = user;
        this.airline = airline;
        this.airlines = airlines;
        this.tickets = tickets;

        setTitle("Available Flights");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columnNames = {
            "Flight Number","Airline","From","To", "Departure Time", "Arrival Time", "Price"
        };

        int totalFlights = 0;
        for(Airline a : airlines){
            if (a != null && a.getFlights() != null){
                totalFlights += a.getFlights().length;
            }
        }

        Flight[] allFlights = new Flight[totalFlights];

        int index = 0;
        for(Airline a : airlines){
            for(Flight flight : a.getFlights()){
                if (flight != null){
                    allFlights[index]= flight;
                    index ++;
                }
            }

        }

       
        Object[][] data = new Object[totalFlights][7];

      
        for(int i =0; i< totalFlights;i++){
                Flight flight = allFlights[i];
                data[i][0] = flight.getflightNumber();
                data[i][1] = flight.getAirline();
                data[i][2] = flight.getSource();
                data[i][3] = flight.getDestination();
                data[i][4] = flight.getDepartureTime();
                data[i][5] = flight.getArrivalTime();
                data[i][6] = "$150";
        }

        JTable table = new JTable(data,columnNames);
        add(new JScrollPane(table),BorderLayout.CENTER);

        JButton bookButton = new JButton("Book Ticket");
        JButton backButton = new JButton("See Tickets");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        buttonPanel.add(bookButton);
        add(buttonPanel,BorderLayout.SOUTH);

        bookButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if(selectedRow == -1){
                JOptionPane.showMessageDialog(this, "Please select a flight");
                return;
            }

            Flight selectedFlight = allFlights[selectedRow];

            Ticket[] flightTickets= java.util.Arrays.stream(tickets).filter(ticket ->
            ticket.getFlight().equals(selectedFlight)).toArray(Ticket[]::new);

            new BookGui(loggedinUser,selectedFlight, tickets,airlines).setVisible(true);
        });

          backButton.addActionListener(e ->{
            dispose();
            new BookManagementGUI(loggedinUser, tickets,selectedFlight, airlines).setVisible(true);
        });


        setVisible(true);
    }


    
}
