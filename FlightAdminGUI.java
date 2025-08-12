import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class FlightAdminGUI extends JFrame {
    private List<Flight> flights;
    private DefaultTableModel tableModel;
    private JTable flightTable;
    private List<User> users;

    public FlightAdminGUI(List<Flight> flights, List<User> users){
        this.flights = flights;
        this.users = users;

        setTitle("Manage Flights");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columns = {"Flight Number", "Airline","Source","Destinaton","Arrival Time","Departure Time"};
        tableModel = new DefaultTableModel(columns,0);
        flightTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(flightTable);

        refreshTable();

        JButton addButton = new JButton("Add Flight");
        JButton editButton = new JButton("Edit Flight");
        JButton deleteButton = new JButton("Delete Flight");
        JButton userButton = new JButton("User Editor");

        addButton.addActionListener( e -> {
            FlightFormDialog dialog = new FlightFormDialog(this,null);
            dialog.setVisible(true);
            if (dialog.isSaved()){
                Flight newFlight = dialog.getFlight();
                flights.add(newFlight);
                JOptionPane.showMessageDialog(this, "Flight Added");
                refreshTable();
            }
        });

        editButton.addActionListener(e ->{
            int row = flightTable.getSelectedRow();
            if(row == -1){
                JOptionPane.showMessageDialog(this, "Select a flight to edit");
                return;
            }

            Flight Editflight = flights.get(row);
            FlightFormDialog dialog = new FlightFormDialog(this, Editflight);
            dialog.setVisible(true);
            if(dialog.isSaved()){
                flights.set(row, dialog.getFlight());
                updateFlightInTable(row, dialog.getFlight());
                JOptionPane.showMessageDialog(this, "Flight Updated");

            }
        });

            deleteButton.addActionListener(e ->{
            int row = flightTable.getSelectedRow();
            if(row == -1){
                JOptionPane.showMessageDialog(this, "Select a flight to delete");
                return;
            }

           flights.remove(row);
           tableModel.removeRow(row);
           JOptionPane.showMessageDialog(this, "Flight Deleted");

        });

        userButton.addActionListener(e ->{
            dispose();
            new UserAdminGUI(users,flights).setVisible(true);
        });





        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(userButton);

        add(scrollPane,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.SOUTH);


    }

    
        private void refreshTable(){
            tableModel.setRowCount(0);
            for(Flight f: flights){
                addFlightToTable(f);
            }
        }


        
        private void addFlightToTable(Flight flight){
            tableModel.addRow(new Object[]{
                flight.getflightNumber(),
                flight.getAirline(),
                flight.getSource(),
                flight.getDestination(),
                flight.getArrivalTime(),
                flight.getDepartureTime(),
            });
        }

        private void updateFlightInTable(int row, Flight flight){
            tableModel.setValueAt(flight.getflightNumber(),row,0);
            tableModel.setValueAt(flight.getAirline(),row,1);
            tableModel.setValueAt(flight.getSource(),row,2);
            tableModel.setValueAt(flight.getDestination(),row,3);
            tableModel.setValueAt(flight.getArrivalTime(),row,4);
            tableModel.setValueAt(flight.getDepartureTime(),row,5);
        }


}
