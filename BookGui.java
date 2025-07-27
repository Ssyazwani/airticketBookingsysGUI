import javax.swing.*;
import java.awt.*;

public class BookGui extends JFrame {
    private Flight selectedFlight;
    private Ticket[] tickets;

    public BookGui(Flight selectedFlight, Ticket[] tickets) {
        this.selectedFlight = selectedFlight;
        this.tickets = tickets;

        setTitle("Login");
        setSize(400,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        
       
    }

}
