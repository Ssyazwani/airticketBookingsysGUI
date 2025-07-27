import javax.swing.*;
import java.awt.*;

public class BookGui extends JFrame {
    private Flight selectedFlight;
    private Ticket[] tickets;

    public BookGui(Flight selectedFlight, Ticket[] tickets) {
        this.selectedFlight = selectedFlight;
        this.tickets = tickets;

        setTitle("Book Ticket");
        setSize(400,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel jpanel = new JPanel(new GridLayout(8,2,5,5));

        jpanel.add(new JLabel("Flight Number:"));
        jpanel.add(new JLabel(selectedFlight.getflightNumber()));

        jpanel.add(new JLabel("Airline:"));
        jpanel.add(new JLabel(selectedFlight.getAirline()));

        jpanel.add(new JLabel("From:"));
        jpanel.add(new JLabel(selectedFlight.getSource()));

        jpanel.add(new JLabel("To:"));
        jpanel.add(new JLabel(selectedFlight.getDestination()));

        jpanel.add(new JLabel("Departure Time:"));
        jpanel.add(new JLabel(selectedFlight.getDepartureTime()));

        jpanel.add(new JLabel("Arrival Time:"));
        jpanel.add(new JLabel(selectedFlight.getArrivalTime()));

        jpanel.add(new JLabel("Passenger Name:"));
        JTextField passengerNameField = new JTextField();
        jpanel.add(passengerNameField);

        jpanel.add(new JLabel("Seat Number:"));
        JComboBox<String> seatDropdown = new JComboBox<>();

        for(Ticket ticket : tickets){
            if (ticket.getStatus().equalsIgnoreCase("available")){
                seatDropdown.addItem(ticket.getseatNumber());
            }
        }
        jpanel.add(seatDropdown);

       JButton bookButton = new JButton("Book Ticket");
       jpanel.add(new JLabel());
       jpanel.add(bookButton);

       add(jpanel);

       bookButton.addActionListener( e ->{
        String passengerName = passengerNameField.getText().trim();
        String seatNumber = (String) seatDropdown.getSelectedItem();

        for(Ticket ticket:tickets){
            if(ticket.getseatNumber().equals(seatNumber)){
                ticket.setPassenger(passengerName);
                ticket.setStatus("Confirmed");
                JOptionPane.showMessageDialog(this, "Booked for " + passengerName);
                break;

            }
        }

        setVisible(true);
       });


       
    }

    

}
