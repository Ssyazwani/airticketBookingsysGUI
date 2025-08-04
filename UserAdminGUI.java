import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;



public class UserAdminGUI extends JFrame{
    private List<User> users;

    public UserAdminGUI(List<User> users){
        this.users = users;
        setTitle("User Management");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        String[] columns = {"User ID", "Name", "Email", "Status"};
        Object[][] data = users.stream()
        .map(u -> new Object[]{
            u.getUserId(),
            u.getName(),
            u.getEmail(),
            "Active"
        }).toArray(Object[][] :: new);

        JTable userTable = new JTable(data,columns);
        JScrollPane scrollPane = new JScrollPane(userTable);

        JButton activateButton = new JButton("Activate");
        JButton deactivateButton = new JButton("Deactivate");
        JButton editButton = new JButton("Edit User");

        activateButton.addActionListener(e ->{
            int row = userTable.getSelectedRow();
            if(row == -1){
                JOptionPane.showMessageDialog(this, "Select a flight to delete");
                return;
            }

           users.add(null);
           JOptionPane.showMessageDialog(this, "User activated");

        });

        
        deactivateButton.addActionListener(e ->{
            int row = userTable.getSelectedRow();
            if(row == -1){
                JOptionPane.showMessageDialog(this, "Select a flight to delete");
                return;
            }

           users.remove(e);
           JOptionPane.showMessageDialog(this, "User activated");

        });

         deactivateButton.addActionListener(e ->{
            int row = userTable.getSelectedRow();
            if(row == -1){
                JOptionPane.showMessageDialog(this, "Select a flight to delete");
                return;
            }

           //users.edit(e);
           JOptionPane.showMessageDialog(this, "User activated");

        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(activateButton);
        buttonPanel.add(deactivateButton);
        buttonPanel.add(editButton);

        add(scrollPane,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.SOUTH);



    }
}
