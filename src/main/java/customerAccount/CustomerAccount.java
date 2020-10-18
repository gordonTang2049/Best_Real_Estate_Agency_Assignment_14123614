package customerAccount;

import dbConnection.JdbcConnector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.Optional;

public class CustomerAccount {

  private static final String URL = "jdbc:postgresql:ENV_DB";
  private static final String USER = "ENV_USER";
  private static final String PASSWORD = "ENV_PASSWORD";
  private static final String DRIVER = "org.postgresql.Driver";

  public boolean isAccountNameExist(String inputUsername) {
//    LinkedList<CustomerAccount> users = new LinkedList<CustomerAccount>();
    boolean isMatch = false;
    String username;

    try {
      JdbcConnector jdbcConnector = new JdbcConnector(URL, USER, PASSWORD, DRIVER);
      jdbcConnector.Connectivity();

      PreparedStatement entry = jdbcConnector
          .preStatement("SELECT EXISTS(SELECT * from users where user_name = ?)");

      entry.setString(1, inputUsername
          .trim()
          .toLowerCase()
      );

      ResultSet results = entry.executeQuery();

      while(results.next()){

        String isExist = results.getString("exists");

        if(isExist.equals("t")){
          isMatch = true;
          jdbcConnector.close();
        }

        return isMatch;
      }

      jdbcConnector.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return false;

  }


}
