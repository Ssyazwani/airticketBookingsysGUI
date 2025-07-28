import javax.swing.*;
import java.awt.*;

public class BookManagementGUI extends JFrame{

    public BookManagementGUI(String status,String passengerName, String seatNumber, String confirmationNum,String flightNumber,String passportNum, String paymentMethod){
        setTitle("Book Ticket");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7,2,10,10));

        panel.add(new JLabel("Passenger Name:"));
        panel.add(new JLabel(passengerName));

        panel.add(new JLabel("Seat Number:"));
        panel.add(new JLabel(seatNumber));

        panel.add(new JLabel("Flight Number:"));
        panel.add(new JLabel(flightNumber));

        panel.add(new JLabel("Payment Method:"));
        panel.add(new JLabel(paymentMethod));

        panel.add(new JLabel("Passport/ID:"));
        panel.add(new JLabel(passportNum));

        panel.add(new JLabel("Status:"));
        panel.add(new JLabel(status));

        panel.add(new JLabel("Confirmation Number :"));
        panel.add(new JLabel(confirmationNum));

        String[] columnNames = {"Required", "Information"};
        Object[][] data ={
            {"Payment Method",confirmationNum},
            {"Passport/ID",passengerName},
            {"Flight Number",passportNum},
            {"Confirmation Number",flightNumber},
            {"Seat Number",seatNumber},
            {"Status",paymentMethod},
            {"Passenger Name",status}
        };

        JTable table = new JTable(data, columnNames);
        table.setEnabled(false);
        table.setRowHeight(25);

        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane);


    }


}
