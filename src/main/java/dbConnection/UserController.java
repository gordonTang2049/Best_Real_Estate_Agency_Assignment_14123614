package dbConnection;

import customerAccount.CustomerAccount;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class UserController {

  private static final String URL = "jdbc:postgresql:ENV_DB";
  private static final String USER = "ENV_USER";
  private static final String PASSWORD = "ENV_PASSWORD";
  private static final String DRIVER = "org.postgresql.Driver";

  private class User {

    private int userId;
    private String username;
    private String password;

    public User(int userId, String username, String password) {
      this.userId = userId;
      this.username = username;
      this.password = password;
    }

    public int getUserId() {
      return userId;
    }

    public String getUsername() {
      return username;
    }

    public String getPassword() {
      return password;
    }
  }


  public void printUser() {

    LinkedList<User> users = new LinkedList<User>();
    int userid;
    String username;
    String password;

    try {
      JdbcConnector jdbcConnector = new JdbcConnector(URL, USER, PASSWORD, DRIVER);
      jdbcConnector.Connectivity();

      PreparedStatement entry = jdbcConnector
          .preStatement("Select * from users");

      ResultSet results = entry.executeQuery();

      while (results.next()) {

        userid = results.getInt("id");
        username = results.getString("user_name");
        password = results.getString("password_digest");

        User user = new User(userid, username, password);

        users.add(user);

      }

      users.forEach(user -> System.out
          .println(user.getUserId() + " " + user.getUsername() + " " + user.getPassword()));

      jdbcConnector.close();
      results.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public int registerUser(String username, String password) {
    int result = 0;
    CustomerAccount customerAccount = new CustomerAccount();
    boolean isAccNameExist = customerAccount.isAccountNameExist(username);

    if (isAccNameExist) {
      System.out.println("Account Name is already exist, please choose another account name.");

    } else {

      try {
        JdbcConnector jdbcConnector = new JdbcConnector(URL, USER, PASSWORD, DRIVER);
        jdbcConnector.Connectivity();

        PreparedStatement entry = jdbcConnector
            .preStatement("INSERT INTO users (user_name, password_digest) VALUES (?,?)");

        entry.setString(1, username.trim().toLowerCase());
        entry.setString(2, password.trim());

        result = entry.executeUpdate();

        jdbcConnector.close();

      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    return result;

  }


}


/*
private static final String URL = "jdbc:postgresql:codech";
  private static final String USER = "gordon";
  private static final String PASSWORD = "123456";
  private static final String DRIVER = "org.postgresql.Driver";


  CrudOperator crudOperator = new CrudOperator();
  JdbcConnector jdbcConnector = new JdbcConnector(URL, USER, PASSWORD, DRIVER);

    jdbcConnector.Connectivity();

        try {

        int userid;
        String username;
        String password;

//      PreparedStatement entry = jdbcConnector
//          .preStatement(crudOperator.createUser());
//
//      entry.setString(1, "dummyuser2");
//      entry.setString(2, "dummypassword2");
//
//      ResultSet results = entry.executeQuery();

//      while (results.next()) {
//        userid = results.getInt("id");
//        username = results.getString("user_name");
//        password = results.getString("password_digest");
//        System.out.println(userid + username + password);
//      }

        PreparedStatement entry = jdbcConnector
        .preStatement(crudOperator.allUser());

        ResultSet results = entry.executeQuery();

        CustomerAccountValidator customerAccountValidator = new CustomerAccountValidator();

        try {
        customerAccountValidator.isAccountNameExist(results, "dummyUsers1");

        } catch (Exception e) {
        System.out.println(e);
        }

        jdbcConnector.close();
        results.close();

        } catch (Exception e) {
        e.printStackTrace();
        }


        }


//    String Input= JOptionPane.showInputDialog(null, "How's your day?");
//    System.out.println(Input);

//
//  ResultSet results = statement.executeQuery("Select * From customers");
//
//
//  int id = 0;
//  String cName ="";
//      while (results.next()) {
//
//          id = results.getInt("id");
//          cName = results.getString("name");
//          String output = String.format("%d  %s ",id,cName);
//          System.out.println(output);
//          }
//          results.close();
//          statement.close();
//          connection.close();
//
//          } catch (Exception e) {
//          System.out.println(e);
//          System.out.println("Connection or other Issues persist");
//          }

//      ResultSet results = jdbcConnector
//          .preStatement(crudOperator.createUser())
//          .setString(1, "dummyuser2")
//          .setString(2,"dummyPassword")
//          .executeQuery();

//      int id=Integer.parseInt(dis.readLine());
//      preStatement.setInt(1, id);
//      ResultSet results = jdbcConnector
//          .getStatement()
//          .executeQuery();
 */