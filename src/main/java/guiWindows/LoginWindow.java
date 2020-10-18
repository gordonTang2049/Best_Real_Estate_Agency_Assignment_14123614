package guiWindows;

//Example GUI
//https://www.youtube.com/watch?v=5vSyylPPEko&ab_channel=ProgrammingKnowledge

import customerAccount.CustomerAccount;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginWindow extends JFrame implements ActionListener {

  private JButton signInButton;
  private JButton exitButton;
  private JButton signUpButton;
  private JTextField userField;
  private JPasswordField passwordField;
  private JPanel loginPanel;
  private JPanel innerPanel;
  private JLabel bestAgencyRealEstateLabel;
  private JLabel usernameLabel;
  private JLabel passwordLabel;

  public LoginWindow(String title) {

    super(title);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(loginPanel);
    this.pack();

    signInButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {

        String username = userField.getText();
        char[] password = passwordField.getPassword();
        CustomerAccount customerAccount = new CustomerAccount();

        boolean isMatch = customerAccount.isAccountNameExist(username);
        if(isMatch){
          dispose();
          JFrame frame = new AdvertisementWindow("Advertisement Display");
          frame.setVisible(true);
        }

      }
    });
    signUpButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {

        dispose();
        JFrame frame = new RegisterWindow("Sign Up");
        frame.setVisible(true);

      }
    });

    exitButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        setVisible(false);
        System.exit(0);
      }
    });
  }

  @Override
  public void actionPerformed(ActionEvent actionEvent) {

  }
}


//
//  DefaultTableModel dm = new DefaultTableModel(0, 0);

//  String header[] = new String[] { "Status", "Task Title", "Start",
//      "Pause", "Stop", "Statulses" };

//    dm.setColumnIdentifiers(header);

//        tblTaskList.setModel(dm);
//        for (int count = 1; count <= 10; count++) {
//        Vector<Object> data = new Vector<Object>();
//    data.add(count);
//    data.add("Project Title" + count);
//    data.add("Start");
//    data.add("Stop");
//    data.add("Pause");
//    data.add("Status");
//    System.out.println("test :- " + count);
//    dm.addRow(data);
//    }

/*
  DefaultTableModel model ;

  public DynRowAdd() {
    initComponents();
    model = new DefaultTableModel();

    jTable1.setModel(model);

    model.addColumn("Id");
    model.addColumn("First Name");
    model.addColumn("Last Name");
    model.addColumn("Company Name");
  }
  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

    model.addRow(new Object[]{jTextField1.getText(), jTextField2.getText(),jTextField3.getText(),jTextField4.getText()});

  }

 */