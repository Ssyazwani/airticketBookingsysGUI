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

        JTable flightTable = new JTable(data,columns);
        JScrollPane scrollPane = new JScrollPane(flightTable);

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

        editButton.addActionListener(e ->{
            int row = flightTable.getSelectedRow();
            if(row == -1){
                JOptionPane.showMessageDialog(this, "Select a flight to edit");
                return;
            }

            Flight Editflight = flights.get(row);
            FlightFormDialog dialog = new FlightFormDialog(this, Editflight);
            dialog.setVisible(true);
            if(dialog.isSaved()){

            }
        });

            deleteButton.addActionListener(e ->{
            int row = flightTable.getSelectedRow();
            if(row == -1){
                JOptionPane.showMessageDialog(this, "Select a flight to delete");
                return;
            }

           flights.remove(row);

        });


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        add(scrollPane,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.SOUTH);



    }

}
