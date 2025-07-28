import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class BookGui extends JFrame {
    private Flight selectedFlight;
    private Ticket[] tickets;

    public BookGui(Flight selectedFlight, Ticket[] tickets) {
        this.selectedFlight = selectedFlight;
        this.tickets = tickets;

        setTitle("Book Ticket");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel jpanel = new JPanel(new GridLayout(11,2,7,7));

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

        jpanel.add(new JLabel("Passport Number/Identification:"));
        JTextField passportNumberField = new JTextField();
        jpanel.add(passportNumberField);

        jpanel.add(new JLabel("Seat Number:"));
        JComboBox<String> seatDropdown = new JComboBox<>();

        for(Ticket ticket : tickets){
            if (ticket.getStatus().equalsIgnoreCase("available")){
                seatDropdown.addItem(ticket.getseatNumber());
            }
        }
        jpanel.add(seatDropdown);

        jpanel.add(new JLabel("Payment Method:"));
        JComboBox<String> paymentDropdown = new JComboBox<>();
        paymentDropdown.addItem("Credit Card");
        paymentDropdown.addItem("Debit Card");
        paymentDropdown.addItem("PayPal");
        paymentDropdown.addItem("Paynow");
        jpanel.add(paymentDropdown);

       JButton bookButton = new JButton("Book Ticket");
       jpanel.add(new JLabel());
       jpanel.add(bookButton);

       add(jpanel);

       bookButton.addActionListener( e ->{
        String passengerName = passengerNameField.getText().trim();
        String passportNum = passportNumberField.getText().trim();
        String seatNumber = (String) seatDropdown.getSelectedItem();
        String paymentMethod = (String) paymentDropdown.getSelectedItem();

        Random random = new Random();
        String Num = String.format("%03d",random.nextInt(1000));
        char letter = (char) ('A' + random.nextInt(26));
        String confirmationNum = Num + letter;




        for(Ticket ticket:tickets){
            if(ticket.getseatNumber().equals(seatNumber) && ticket.getStatus().equalsIgnoreCase("available")){
                ticket.setPassenger(passengerName);
                ticket.setStatus("Confirmed");
                
                JOptionPane.showMessageDialog(this, 
                "Booking Confirmed!\n" +
                "Booking Confirmation Num :" + confirmationNum + "\n" +
                "Passenger Name: "+ passengerName +"\n" +
                "Passport/ID: "+ passportNum +"\n" +
                "Seat: "+ seatNumber +"\n" +
                "Payment: "+ paymentMethod +"\n" 
                );

                new BookManagementGUI(passengerName,passportNum,seatNumber,paymentMethod,confirmationNum,selectedFlight.getflightNumber(),ticket.getStatus()).setVisible(true);
                //arguements much match the bookmanagementgui please check
                dispose();
                break;
            }
            
        }

        

       
       });


       
    }

    

}
