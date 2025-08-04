import javax.swing.*;
import javax.swing.border.Border;
import java.util.List;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

public class MainGui extends JFrame{
    private JTextField textUserId;
    private JPasswordField textPassword;
    private JButton buttonLogin;
    private JLabel lblStatus;   
    private User[] users;
    private Airline airline;
    private Airline[] airlines;
    private Ticket[] tickets;
    private JButton buttonRegister;
    private List<Flight> flights;
    private List<User> userList;
    private User loggedUser;



public MainGui(List<User> userList, Airline[] airlines, Ticket[] tickets,List<Flight> flights){
this.userList = userList;
this.airlines = airlines;
this.tickets = tickets;
this.flights = flights;

setTitle("Login");
setSize(300,180);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);

textUserId = new JTextField(15);
textPassword = new JPasswordField(15);
buttonLogin = new JButton("Login");
lblStatus = new JLabel(" ");
buttonRegister = new JButton("Register");
JButton buttonAdmin = new JButton("Admin");

JPanel panel = new JPanel(new GridLayout(4,2));
panel.add(new JLabel("User ID:"));
panel.add(textUserId);
panel.add(new JLabel("Password:"));
panel.add(textPassword);


JPanel bottomPanel = new JPanel();
bottomPanel.add(buttonLogin);
bottomPanel.add(buttonRegister);
bottomPanel.add(buttonAdmin);

JPanel statusPanel = new JPanel();
statusPanel.add(lblStatus);

add(panel, BorderLayout.CENTER);
add(bottomPanel,BorderLayout.SOUTH);
add(statusPanel,BorderLayout.NORTH);

buttonLogin.addActionListener( e-> {
    String userId = textUserId.getText();
    String password = new String(textPassword.getPassword());

    boolean loggedIn = false;
    User loggedUser = null;
    for (User u: userList){
        if (u != null && u.login(userId, password)){
            loggedIn = true;
            loggedUser = u;
            break;
        }
    }

    if(loggedIn){
        JOptionPane.showMessageDialog(this, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
        lblStatus.setText("Welcome, "+ loggedUser.getName());
        new DisplayFlightgui(loggedUser, airlines[0],airlines,tickets).setVisible(true);
        dispose();

    } else {
        lblStatus.setText("Invalid user Id or password");
    }


});
  
 buttonRegister.addActionListener( e ->{
    new RegisterGui(users).setVisible(true);
 });

 buttonAdmin.addActionListener(e ->{
            dispose();
            new AdminGUI(userList, flights, tickets).setVisible(true);
        });


}
}