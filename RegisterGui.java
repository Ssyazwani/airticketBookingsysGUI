import javax.swing.*;
import java.awt.*;

public class RegisterGui extends JFrame{
    private JTextField userIdArea;
    private JTextField nameArea;
    private JTextField emailArea;
    private JPasswordField passwordArea;
    private JButton registerButton;
    private User[] users;

    public RegisterGui(User[]users){
        this.users = users;

        setTitle("Register");
        setSize(300,180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        nameArea = new JTextField(15);
        emailArea = new JTextField(15);
        userIdArea = new JTextField(15);
        passwordArea= new JPasswordField(15);
        registerButton = new JButton("Register");

        JPanel panel = new JPanel(new GridLayout(5,2));
        panel.add(new JLabel("Name:"));
        panel.add(nameArea);
        panel.add(new JLabel("Email:"));
        panel.add(emailArea);
        panel.add(new JLabel("User ID:"));
        panel.add(userIdArea);
        panel.add(new JLabel("Password:"));
        panel.add(passwordArea);
        panel.add(new JLabel());
        panel.add(registerButton);

        add(panel);

        registerButton.addActionListener(e-> {
            String userId = userIdArea.getText();
            String name = nameArea.getText();
            String email = emailArea.getText();
            String password = new String(passwordArea.getPassword());

            if(userId.isEmpty() || name.isEmpty()|| email.isEmpty()||password.isEmpty()){
                JOptionPane.showMessageDialog(this, "All fields are required");
                return;
            }

            boolean added = false;
            for(int i =0; i <users.length; i++){
                if(users[i]== null){
                    users[i] = new User(userId,name,email,password);
                    added = true;
                    break;
                }
            }

            if(added){
                JOptionPane.showMessageDialog(this, "Registeration successful");
                dispose();
            } else{
                JOptionPane.showMessageDialog(this, "User list is full. Sorry");
            }
        });


        
    }

}