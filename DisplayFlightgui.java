import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.util.List;

public class DisplayFlightgui extends JFrame {
    private User loggedinUser;
    private Airline airline;
    private Airline[] airlines;
    private Ticket[] tickets;
    private Flight selectedFlight;
    private List<Ticket> tickets2;

    public DisplayFlightgui(User user, Airline airline, Airline[] airlines,List<Ticket> tickets2){
        this.loggedinUser = user;
        this.airline = airline;
        this.airlines = airlines;
        this.tickets2 = tickets2;

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
                data[i][6] = "150";
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

            Ticket[] flightTickets= tickets2.stream().filter(ticket ->
            ticket.getFlight().equals(selectedFlight)).toArray(Ticket[]::new);

            new BookGui(loggedinUser,selectedFlight, tickets2,airlines).setVisible(true);
        });

          backButton.addActionListener(e ->{
            dispose();
            new BookManagementGUI(loggedinUser, tickets2,selectedFlight, airlines).setVisible(true);
        });


        setVisible(true);
    }


    
}
