import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class AdminNaviGUI extends JFrame {
      private List<User> users;
      private List<Flight> flights;
      private List<Ticket> tickets2;
      private Ticket[] tickets;

    public AdminNaviGUI(List<User> users, List<Flight> flights, List<Ticket> tickets2){
        this.users = users;
        this.flights = flights;
        this.tickets2 = tickets2;
        setTitle("Admin Login");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel bottomPanel = new JPanel();
        JButton flightButton = new JButton("Flight Button");
        JButton userButton = new JButton("User Button");

        bottomPanel.add(flightButton);
        bottomPanel.add(userButton);

        add(bottomPanel,BorderLayout.CENTER);

        flightButton.addActionListener(e ->{
            dispose();
            new FlightAdminGUI(flights, users).setVisible(true);
        });


        userButton.addActionListener(e ->{
            dispose();
            new UserAdminGUI(users, flights).setVisible(true);
        });




    }
    
    
}
