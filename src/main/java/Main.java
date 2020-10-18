import customerAccount.CustomerAccount;
import dbConnection.PropertyProfileController;
import dbConnection.UserController;
import guiWindows.LoginWindow;
import java.awt.EventQueue;
import javax.swing.JFrame;

//  in another class
//  Usage
  /*
  Connectivity connect = new Connectivity();
  Statement st = connect.getStatement();
  ResultSet r = st.executeQuery(sql);

   */


public class Main {

  public static void main(String[] args) {

//    CustomerAccount customerAccount = new CustomerAccount();
//    boolean isMatch = customerAccount.isAccountNameExist("dummyUsers99");
//    System.out.println(isMatch);
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {

          JFrame frame = new LoginWindow("Best Real Estate Login - 14123614");
          frame.setVisible(true);

        } catch (Exception e) {
          e.printStackTrace();
        }

      }

    });

  }
}

//    PropertyProfileController propertyProfileController = new PropertyProfileController();
//    propertyProfileController.printPropertyProfiles();
//    UserController crudController = new UserController();
//    int resp = crudController.registerUser("dummyUsers9999", "dummyUsers1");