import javax.swing.*;
import java.awt.*;

public class BookTicketGui extends JFrame {
    private User loggedinUser;

    public BookTicketGui(User user){
        this.loggedinUser = user;

        setTitle("Available Flights");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }


    
}
