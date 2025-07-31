import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class FlightAdminGUI extends JFrame {
    private List<Flight> flights;

    public FlightAdminGUI(List<Flight> flights){
        this.flights = flights;

        setTitle("Manage Flights");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columns = {};
        Object[][]data = flights.stream().map( f -> new Object[]{
            f.getflightNumber(),
            f.getAirline(),
            f.getSource(),
            f.getSource(),
            f.getArrivalTime(),
            f.getDepartureTime()
        }).toArray(Object[][]::new);

        JTable flighTable = new JTable(data,columns);
        JScrollPane scrollPane = new JScrollPane(flighTable);

        JButton addButton = new JButton("Add Flight");
        JButton editButton = new JButton("Edit Flight");
        JButton deleteButton = new JButton("Delete Flight");

        addButton.addActionListener( e -> {
            FlightFormDialog dialog = new FlightFormDialog(this,null);
            dialog.setVisible(true);
            if (dialog.isSaved()){
                Flight newFlight = dialog.getFlight();
                flights.add(newFlight);
            }
        });


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        add(scrollPane,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.SOUTH);





    }

}
