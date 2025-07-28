import javax.swing.*;
import javax.swing.border.Border;

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



public MainGui(User[] users, Airline[] airlines, Ticket[] tickets){
this.users = users;
this.airlines = airlines;
this.tickets = tickets;

setTitle("Login");
setSize(300,180);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);

textUserId = new JTextField(15);
textPassword = new JPasswordField(15);
buttonLogin = new JButton("Login");
lblStatus = new JLabel(" ");
buttonRegister = new JButton("Register");

JPanel panel = new JPanel(new GridLayout(4,2));
panel.add(new JLabel("User ID:"));
panel.add(textUserId);
panel.add(new JLabel("Password:"));
panel.add(textPassword);


JPanel bottomPanel = new JPanel();
bottomPanel.add(buttonLogin);
bottomPanel.add(buttonRegister);

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
    for (User u: users){
        if (u != null && u.Login(userId, password)){
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

}
}