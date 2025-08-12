
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class UserFormDialog extends JDialog{
    private boolean saved = false;
    private User user;;

    public UserFormDialog(Frame owner, User user){
        super(owner,"User Editor",true);
        this.user= user;
        setSize(400,250);
        setLocationRelativeTo(owner);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout(10,10));

        JPanel form = new JPanel(new GridLayout(4,2,5,5));
   

        JTextField usernameField = new JTextField();
        JTextField fullNameField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField passwordField= new JTextField();
        

        form.add(new JLabel("Username:"));
        form.add (usernameField);
        form.add(new JLabel("Full Name:"));
        form.add (fullNameField);
        form.add(new JLabel("Email:"));
        form.add (emailField);
        form.add(new JLabel("Password:"));
        form.add (passwordField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton saveButton = new JButton("Save");
        JButton cancelButton = new JButton("Cancel");

        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        add(form,BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

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
        dispose();

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
