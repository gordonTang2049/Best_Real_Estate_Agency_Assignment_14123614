package guiWindows;

import customerAccount.CustomerAccount;
import dbConnection.UserController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterWindow extends JFrame implements ActionListener {

  private JPanel registerPanel;
  private JTextField usernameField;
  private JLabel warningMessage;
  private JPasswordField confirmPasswordField;
  private JButton signUpButton;
  private JButton exitButton;
  private JLabel usernameLabel;
  private JPasswordField passwordField;


  public RegisterWindow(String title) {

    super(title);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(registerPanel);
    this.pack();

    signUpButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        String username = usernameField.getText();
//        char[] password = passwordField.getPassword();
//        char[] confirmPassword = confirmPasswordField.getPassword();

        String pwd = new String(passwordField.getPassword());
        String confirmedPwd = new String(confirmPasswordField.getPassword());

        CustomerAccount customerAccount = new CustomerAccount();
        boolean isExist = customerAccount.isAccountNameExist(username);

        if (isExist) {
          warningMessage.setText("Please choose another other username, it has been used!!");

        }else{

          if(pwd.equals(confirmedPwd)){

            UserController registerUser = new UserController();
            int result = registerUser.registerUser(username,pwd);

            System.out.println(result);



          }else{
            warningMessage.setText("Password does not match with confirmed password, please type your password again!!");
          }


        }

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
