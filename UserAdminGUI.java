import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;



public class UserAdminGUI extends JFrame{
    private List<User> users;
    private List<Flight> flights;

    public UserAdminGUI(List<User> users, List<Flight> flights){
        this.users = users;
        this.flights = flights;
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
        JButton flightButton = new JButton("To Flight Editor");

        activateButton.addActionListener(e ->{
            int row = userTable.getSelectedRow();
            if(row == -1){
                JOptionPane.showMessageDialog(this, "Please select a user to activate");
                return;
            }

            User user = users.get(row);
           if(user.isActive()){
            JOptionPane.showMessageDialog(this, "User activated");
           } else {
            user.setActive(true);
            JOptionPane.showMessageDialog(this, "User is activated");
            refreshTableData(columns);
           }

        });

        
        deactivateButton.addActionListener(e ->{
            int row = userTable.getSelectedRow();
            if(row == -1){
                JOptionPane.showMessageDialog(this, "Select a flight to delete");
                return;
            }

           User user = users.get(row);
           if(user.isActive()){
            JOptionPane.showMessageDialog(this, "User activated");
           } else {
            user.setActive(true);
            JOptionPane.showMessageDialog(this, "User is activated");
            refreshTableData(columns);
           }
        });

         editButton.addActionListener(e ->{
            int row = userTable.getSelectedRow();
            if(row == -1){
                JOptionPane.showMessageDialog(this, "Please select a user to edit");
                return;
            }

          User user = users.get(row);
          String name = JOptionPane.showInputDialog(this, "Enter new name: ",user.getName());
          if (name != null && !name.isEmpty()){
            user.setName(name);
            JOptionPane.showMessageDialog(this, "User activated");
            refreshTableData(columns);
          }
           
        });

        flightButton.addActionListener(e ->{
            dispose();
            new FlightAdminGUI(flights, users).setVisible(true);
        });


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(activateButton);
        buttonPanel.add(deactivateButton);
        buttonPanel.add(editButton);
        buttonPanel.add(flightButton);

        add(scrollPane,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.SOUTH);



    }

    private void refreshTableData (String [] columns){
        Object[][] data = users.stream()
        .map ( u -> new Object[]{
            u.getUserId(),
            u.getName(),
            u.getEmail()
        }).toArray(Object[][]::new);

    }
    
}



