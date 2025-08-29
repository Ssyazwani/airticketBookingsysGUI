import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BookManagementGUI extends JFrame{
    private User user;
    private Ticket[]  tickets;
    private Flight flight;
    private Airline[] airlines;
    private List<Ticket> tickets2;

    public BookManagementGUI(User user, List<Ticket> tickets2, Flight flight, Airline[] airlines){
        this.user = user;
        this.tickets2 = tickets2;
        this.flight = flight;
        this.airlines = airlines;

        setTitle("Manage Your Tickets");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        List<Ticket> managedTickets = tickets2.stream()
        .filter( ticket -> ticket.getOwner() != null && 
        ticket.getOwner().equals(user)  && 
       ("Confirmed".equalsIgnoreCase(ticket.getStatus())||"Cancelled".equalsIgnoreCase(ticket.getStatus()))).collect(Collectors.toList());

        String[] columnNames={"Seat","Flight","Status","Payment Method", "Confirmation Number"};
        Object[][] data = managedTickets.stream()
        .map(ticket -> new Object[]{
            ticket.getseatNumber(),
            ticket.getFlight().getflightNumber(),
            ticket.getStatus(),
            ticket.getPaymentMethod(),
            ticket.getConfirmationNum()
        }).toArray(Object[][]::new);

        JTable table = new JTable(data,columnNames);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setRowHeight(25);    
        JScrollPane scrollPane = new JScrollPane(table);  

        JButton cancelButton = new JButton("Cancel Selected Ticket");
        JButton backButton = new JButton("Back to Flights");

        cancelButton.addActionListener((ActionEvent e)->{
            int selectedRow = table.getSelectedRow();
            if(selectedRow ==-1){
                JOptionPane.showMessageDialog(this, "Selected the ticket you want to cancel");
                return;
            }

            Ticket selectedTicket = managedTickets.get(selectedRow);
            if(selectedTicket.getStatus().equalsIgnoreCase("Cancelled")){
                JOptionPane.showMessageDialog(this, "This ticket is already cancelled");
                return;
            }

            Ticket Cancelticket = managedTickets.get(selectedRow);
            user.cancelTicket(Cancelticket);
            JOptionPane.showMessageDialog(this, "Ticket cancelled");
            dispose();
            new BookManagementGUI(user, tickets2, flight,airlines).setVisible(true);
        });

        backButton.addActionListener(e ->{
            dispose();
            new DisplayFlightgui(user, airlines[0],airlines,tickets2).setVisible(true);
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(cancelButton);
        buttonPanel.add(backButton);

        add(scrollPane,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.SOUTH);



       


    }


}
