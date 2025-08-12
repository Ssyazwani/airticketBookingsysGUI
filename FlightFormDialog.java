import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class FlightFormDialog extends JDialog {
    private boolean saved = false;
    private Flight flight;

    public FlightFormDialog(Frame owner, Flight existingFlight){
        super(owner,"Flight Editor",true);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(owner);

        setLayout(new BorderLayout(10,10));

        JPanel form = new JPanel(new GridLayout(6,2,5,5));
   

        JTextField flightNumberField = new JTextField();
        JTextField airlineField = new JTextField();
        JTextField sourceField = new JTextField();
        JTextField destinationField= new JTextField();
        JTextField departureTimeField = new JTextField();
        JTextField arrivalTimeField = new JTextField();

        form.add(new JLabel("Flight Number:")); 
        form.add (flightNumberField);
        form.add(new JLabel("Airline:")); 
        form.add (airlineField);
        form.add(new JLabel("Source:"));
        form.add (sourceField);
        form.add(new JLabel("Destination:"));
        form.add (destinationField);
        form.add(new JLabel("Departure Time:")); 
        form.add (departureTimeField);
        form.add(new JLabel("Arrival Time:"));
        form.add (arrivalTimeField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton saveButton = new JButton("Save");
        JButton cancelButton = new JButton("Cancel");

        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        add(form,BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

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
