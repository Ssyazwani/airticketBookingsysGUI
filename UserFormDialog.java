
import javax.swing.*;
import java.awt.*;

public class UserFormDialog extends JDialog{
    private boolean saved = false;
    private User user;;

    public UserFormDialog(Frame owner, User user){
        super(owner,"User Editor",true);
        this.user= user;

        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(owner);

        JTextField usernameField = new JTextField();
        JTextField fullNameField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField passwordField= new JTextField();
        

        add(new JLabel("Username:")); add (usernameField);
        add(new JLabel("Full Name:")); add (fullNameField);
        add(new JLabel("Email:")); add (emailField);
        add(new JLabel("Password:")); add (passwordField);
       

        JButton saveButton = new JButton("Save");
        JButton cancelButton = new JButton("Cancel");

        add(saveButton);
        add(cancelButton);

        if(user != null){
           usernameField.setText(user.getUserId());
           fullNameField.setText(user.getName());
           emailField.setText(user.getEmail());
           passwordField.setText(user.getPassword());
            
        }

        saveButton.addActionListener( e -> {
            saved = true;
            this.user = new User(usernameField.getText(), 
            fullNameField.getText(),
            emailField.getText(),
            passwordField.getText());
        });

        cancelButton.addActionListener( e -> 
        dispose());
    }

       public boolean isSaved() {
        return saved;
    }

    public User getUser() {
        return user;
    }


   
}
