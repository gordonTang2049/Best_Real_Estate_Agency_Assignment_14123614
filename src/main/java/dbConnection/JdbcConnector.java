package dbConnection;
// https://www.oracle.com/java/technologies/dataaccessobject.html

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnector {

  Connection connection;
  private String url, user, pass, driver;

  public JdbcConnector(String url, String user, String pass, String driver) {
    super();
    this.url = url;
    this.user = user;
    this.pass = pass;
    this.driver = driver;

  }

  public void Connectivity(){

    try {

      Class.forName(this.driver);
      connection = DriverManager.getConnection(this.url, this.user, this.pass);

    } catch (ClassNotFoundException e) {

      e.printStackTrace();

    } catch (SQLException e) {

      e.printStackTrace();

    }
  }

  public PreparedStatement preStatement(String query) throws SQLException {
    return connection.prepareStatement(query);
  }


  public void close() throws SQLException {
    connection.close();

  }

}
//
// try {
//     PreparedStatement preStatement=conn.prepareStatement("Select * from tbl_name where id=?");
//     DataInputStream dis=new DataInputStream(System.in);
//     System.out.println("Enter id:- ");
//     int id=Integer.parseInt(dis.readLine());

//     preStatement.setInt(1, id);

//     ResultSet result = preStatement.executeQuery();

//     while(result.next()){
//     // fetch the data
//     }
//     }catch(Exception ex){ ... }