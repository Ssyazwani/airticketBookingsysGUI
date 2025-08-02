import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AdminGUI extends JFrame{
        private User user;
        private List<Flight> flights;

        public AdminGUI(){
        setTitle("Admin Login");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();

        JLabel passLabel = new JLabel("Password: ");
        JPasswordField passField = new JPasswordField();

        JButton loginButton = new JButton("Login");

        panel.add(userLabel);
        panel.add(userField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(new JLabel());
        panel.add(loginButton);

        add(panel);

        loginButton.addActionListener( e-> {
    String userId = userField.getText();
    String password = new String(passField.getPassword());

    if ("admin".equals(userId) && "admin".equals(password)){
        JOptionPane.showMessageDialog(this, "Login Successfull");
        new FlightAdminGUI(flights).setVisible(true);
        dispose();
    } else {
        JOptionPane.showMessageDialog(this, "Invalid");
    }
    

    
    });

}

      public static void main(String[]args){
         SwingUtilities.invokeLater(()->{
        new AdminGUI().setVisible(true);
    });
}

  
    



}