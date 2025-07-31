import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class FlightFormDialog extends JFrame {
    private boolean saved = false;
    private Flight flight;

    public FlightFormDialog(Flight existingFlight){

        setTitle("Flight Editor");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextField flightNumberField = new JTextField();
        JTextField airlineField = new JTextField();
        JTextField sourceField = new JTextField();
        JTextField destinationField= new JTextField();
        JTextField departureTimeField = new JTextField();
        JTextField arrivalTimeField = new JTextField();

        add(new JLabel("Flight Number:")); add (flightNumberField);
        add(new JLabel("Airline:")); add (airlineField);
        add(new JLabel("Source:")); add (sourceField);
        add(new JLabel("Destination:")); add (destinationField);
        add(new JLabel("Departure Time:")); add (departureTimeField);
        add(new JLabel("Arrival Time:")); add (arrivalTimeField);


        JButton saveButton = new JButton("Save");
        JButton cancelButton = new JButton("Cancel");

        add(saveButton);
        add(cancelButton);

        if(existingFlight != null){
            flightNumberField.setText(existingFlight.getflightNumber());
            airlineField.setText(existingFlight.getAirline());
            sourceField.setText(existingFlight.getSource());
            destinationField.setText(existingFlight.getDestination());
            departureTimeField.setText(existingFlight.getDepartureTime());
            arrivalTimeField.setText(existingFlight.getArrivalTime());
        }

        saveButton.addActionListener( e -> {
            saved = true;
            flight = new Flight(flightNumberField.getText(), 
            airlineField.getText(),
            sourceField.getText(),
            destinationField.getText(),
            departureTimeField.getText(), 
            arrivalTimeField.getText());
             dispose();
        });

        cancelButton.addActionListener( e -> 
        dispose());
    }

   

    public boolean isSaved() {
        return saved;
    }

    public Flight getFlight() {
        return flight;
    }

}
