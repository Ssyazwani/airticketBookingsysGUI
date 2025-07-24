
/*
 * This is an interactive version of MyMenu of ReferenceProgram of Chapter8
 */
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.*;
import javax.swing.border.*;

public class MyMenuOrder extends JFrame implements ActionListener, ListSelectionListener
{
  private JTextArea jtxtMenu;
  private JRadioButton jradMC1;
  private JRadioButton jradMC2;
  private JRadioButton jradMC3;
  private JRadioButton jradMC4;
  private JRadioButton jradMC5;
  private JRadioButton jradMC6;
  private JRadioButton jradMC7;
  private JRadioButton jradCoffee;
  private JRadioButton jradTea;
  private JCheckBox jchkSoup;
  private JCheckBox jchkSalad;
  private JButton jbtConfirm;
  private JButton jbtExit;
  private JList jlst;
  private String selectedValue; /* To keep the selected item in List */

   private JMenuItem jmiAbout, jmiExit; /* Menu bar */
  
  public MyMenuOrder()
  {
  // String of Deserts
  String [] deserts = {"KEY LIME PIE","NEW YORK CHEESECAKE","TIRAMISU",
                              "SOUTHERN PECAN PIE","SOUR CREAM APPLE PIE"};
  jtxtMenu = new JTextArea();
  jtxtMenu.setText("");
  jtxtMenu.setRows(6);

  jradMC1 = new JRadioButton();
  jradMC1.setText("BLACKENED CATFISH");

  jradMC2 = new JRadioButton();
  jradMC2.setText("CRISPY SKIN RED SNAPPER");

  jradMC3 = new JRadioButton();
  jradMC3.setText("GRILLED ATLANTIC SALMON");

  jradMC4 = new JRadioButton();
  jradMC4.setText("MARINATED WHOLE ROASTED CORNISH HEN");

  jradMC5 = new JRadioButton();
  jradMC5.setText("HERB ROASTED HALF CHICKEN");

  jradMC6 = new JRadioButton();
  jradMC6.setText("BARBEQUED BABY BACK RIBS");

  jradMC7 = new JRadioButton();
  jradMC7.setText("GRILLED NY SIRLOIN");

  // Create a group for Entrees
  ButtonGroup btg = new ButtonGroup();
  btg.add(jradMC1);
  btg.add(jradMC2);
  btg.add(jradMC3);
  btg.add(jradMC4);
  btg.add(jradMC5);
  btg.add(jradMC6);
  btg.add(jradMC7);

  jradCoffee = new JRadioButton();
  jradCoffee.setText("COFFEE");

  jradTea = new JRadioButton();
  jradTea.setText("TEA");

  // Create a group for Hot Drinks
  ButtonGroup btgHD = new ButtonGroup();
  btgHD.add(jradCoffee);
  btgHD.add(jradTea);

  // Create a list for Deserts
  jlst = new JList(deserts);
  String selectedValue = "";
  jlst.setSelectionMode(0); //SINGLE_SELECTION
  // Handle list selection
  jlst.addListSelectionListener(this);  

  // Create a group of Appetizers
  jchkSoup = new JCheckBox();
  jchkSoup.setText("SOUP OF THE DAY");

  jchkSalad = new JCheckBox();
  jchkSalad.setText("HOUSE GREEN SALAD");

  // Create exit and confirm button with listener implemented
  jbtConfirm = new JButton("CONFIRM");
  jbtExit = new JButton("EXIT");

  jbtConfirm.addActionListener(this);
  jbtExit.addActionListener(this);
  
  JPanel p1 = new JPanel();
  p1.setLayout(new BorderLayout());
  p1.add(jtxtMenu, BorderLayout.NORTH);

  JPanel p2 = new JPanel();
  p2.setLayout(new GridLayout(7,1));
  p2.add(jradMC1);
  p2.add(jradMC2);
  p2.add(jradMC3);
  p2.add(jradMC4);
  p2.add(jradMC5);
  p2.add(jradMC6);
  p2.add(jradMC7);
  p2.setBorder(new TitledBorder("Entrees"));

  JPanel p3 = new JPanel();
  p3.setLayout(new GridLayout(1,2));
  p3.add(jchkSoup);
  p3.add(jchkSalad);
  p3.setBorder(new TitledBorder("Appetizers"));

  JPanel p4 = new JPanel();
  p4.setLayout(new GridLayout(1, 2));
  p4.add(jradCoffee);
  p4.add(jradTea);
  p4.setBorder(new TitledBorder("Hot Drink"));

  JPanel p5 = new JPanel();
  p5.setLayout(new GridLayout(1,1));
  p5.add(jlst);
  p5.setBorder(new TitledBorder("Deserts"));

  JPanel pA = new JPanel();
  pA.setLayout(new BorderLayout());
  pA.add(p2, BorderLayout.CENTER);
  pA.add(p3, BorderLayout.NORTH);

  JPanel pB = new JPanel();
  pB.setLayout(new BorderLayout());
  pB.add(p4, BorderLayout.NORTH);
  pB.add(p5, BorderLayout.CENTER);

  JPanel pC = new JPanel();
  pC.setLayout(new GridLayout(1, 2));
  pC.add(jbtConfirm);
  pC.add(jbtExit);
  
  setLayout(new BorderLayout());
  add(pA, BorderLayout.WEST);
  add(p1, BorderLayout.NORTH);
  add(pB, BorderLayout.CENTER);  
  add(pC, BorderLayout.SOUTH);

    // add a small menu
    JMenuBar jmb = new JMenuBar();
    setJMenuBar(jmb);
    JMenu menu = new JMenu("Menu");
    menu.setMnemonic('M');
    jmb.add(menu);

    menu.add(jmiAbout = new JMenuItem("About", 'A'));
    menu.add(jmiExit = new JMenuItem("Exit", 'E'));

        // Handle event
    jmiAbout.addActionListener(this);
    jmiExit.addActionListener(this);
  }

  public static void main(String[] args)
  {
    MyMenuOrder frame = new MyMenuOrder();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500,400);
    frame.setTitle("My Personal Menu");
    frame.setVisible(true);
  }

  /** Handle Action Events on buttons **/
  public void actionPerformed(ActionEvent e)
  {

    String actionCommand = e.getActionCommand();

   // Handle Next button event
   if(e.getSource() instanceof JButton){
    String menu = "";

    if (e.getSource()== jbtConfirm)
    { 
      jtxtMenu.setEditable(true);
      if (jchkSoup.isSelected()) menu = jchkSoup.getText();
      if (jchkSalad.isSelected()) menu = (menu==""? "": menu + "\n") + jchkSalad.getText();

      //find out which entree is selected
      if (jradMC1.isSelected()) menu = (menu==""? "": menu + "\n") + jradMC1.getText();
      else if (jradMC2.isSelected()) menu = (menu==""? "": menu + "\n")  + jradMC2.getText();
      else if (jradMC3.isSelected()) menu = (menu==""? "": menu + "\n")  + jradMC3.getText(); 
      else if (jradMC4.isSelected()) menu = (menu==""? "": menu + "\n")  + jradMC4.getText(); 
      else if (jradMC5.isSelected()) menu = (menu==""? "": menu + "\n")  + jradMC5.getText(); 
      else if (jradMC6.isSelected()) menu = (menu==""? "": menu + "\n")  + jradMC6.getText();
      else if (jradMC7.isSelected()) menu = (menu==""? "": menu + "\n")  + jradMC7.getText(); 

      //find out which hot drink is selected
      if (jradCoffee.isSelected())  menu = (menu==""? "": menu + "\n") + jradCoffee.getText(); 
      else if (jradTea.isSelected())  menu = (menu==""? "": menu + "\n") + jradTea.getText(); 

    if (selectedValue != null) menu = (menu==""? "": menu + "\n") + selectedValue;
    
      if (menu == null) jtxtMenu.setText("You have ordered Nothing.");
      else {
      jtxtMenu.setText("Your Order is as follow:\n" + menu);      
      jtxtMenu.setEditable(false);
      }
    }
    else if (e.getSource() == jbtExit)
    {
       JOptionPane.showMessageDialog(null,"Thanks for using the program!",
          "My Personal Menu",JOptionPane.INFORMATION_MESSAGE);
      System.exit(0);
    }
   }
      else if(e.getSource() instanceof JMenuItem) // Menu event
   {
     if("About".equals(actionCommand)){
        String s = "This is a Program written in Java. It aims to illustrate the features of GUI in Java.";
        JOptionPane.showMessageDialog(null,s, "My Simple Menu",JOptionPane.INFORMATION_MESSAGE);
     }
     else if ("Exit".equals(actionCommand))
      System.exit(0);
   }
  }

  /* Handle list selection */
  public void valueChanged(ListSelectionEvent e)
  { // Get selected indices
    selectedValue = (String) jlst.getSelectedValue();
  }
}
