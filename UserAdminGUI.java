import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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

        DefaultTableModel tableModel = new DefaultTableModel(columns,0);
        JTable userTable = new JTable(tableModel);
        refreshTableData(tableModel);
        // Object[][] data = users.stream()
        // .map(u -> new Object[]{
        //     u.getUserId(),
        //     u.getName(),
        //     u.getEmail(),
        //     "Active"
        // }).toArray(Object[][] :: new);

        // JTable userTable = new JTable(data,columns);
        JScrollPane scrollPane = new JScrollPane(userTable);

        JButton addButton = new JButton("Add User");
        JButton deleteButton = new JButton("Delete User");
        JButton editButton = new JButton("Edit User");
        JButton flightButton = new JButton("To Flight Editor");

        addButton.addActionListener(e ->{
           UserFormDialog dialog = new UserFormDialog(this, null);
           dialog.setVisible(true);

           if(dialog.isSaved()){
            User newUser = dialog.getUser();
            users.add(newUser);
            refreshTableData(tableModel);
            JOptionPane.showMessageDialog(this, "User added.");
           }

        });

        
        deleteButton.addActionListener(e ->{
            int row = userTable.getSelectedRow();
            if(row == -1){
                JOptionPane.showMessageDialog(this, "Select a flight to delete");
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this");
            if(confirm == JOptionPane.YES_OPTION){
                users.remove(row);
                refreshTableData(tableModel);
                JOptionPane.showMessageDialog(this, "User deleted.");
            }
        });

         editButton.addActionListener(e ->{
            int row = userTable.getSelectedRow();
            if(row == -1){
                JOptionPane.showMessageDialog(this, "Please select a user to edit");
                return;
            }

            User existUser = users.get(row);
            UserFormDialog dialog = new UserFormDialog(this, existUser);
            dialog.setVisible(true);

            if(dialog.isSaved()){
                users.set(row,dialog.getUser());
                refreshTableData(tableModel);
                JOptionPane.showMessageDialog(this, "User Updated");
            }
           
        });

        flightButton.addActionListener(e ->{
            dispose();
            new FlightAdminGUI(flights, users).setVisible(true);
        });


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(editButton);
        buttonPanel.add(flightButton);

        add(scrollPane,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.SOUTH);



    }

    private void refreshTableData (DefaultTableModel tableModel){
      tableModel.setRowCount(0);

        for(User u : users){
            tableModel.addRow(new Object[]{
                u.getUserId(),
                u.getName(),
                u.getEmail()
            });
        }

    }
    
}



