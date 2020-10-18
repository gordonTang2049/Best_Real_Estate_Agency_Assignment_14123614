package dbConnection;


import java.lang.*;
import java.security.PrivilegedAction;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.LinkedList;
import javax.print.DocFlavor.STRING;
import org.postgresql.replication.PGReplicationConnectionImpl;

public class PropertyProfileController {

  private static final String URL = "jdbc:postgresql:ENV_DB";
  private static final String USER = "ENV_USER";
  private static final String PASSWORD = "ENV_PASSWORD";
  private static final String DRIVER = "org.postgresql.Driver";

  enum PropertyType {
    house,
    apartment,
    studio,
    terrace,
    others
  }

  enum TransactionType {
    sale,
    rent,
    buy
  }

  private class PropertyProfile {

    int id;
    Timestamp createAt;
    private int userId;
    private String property_image_link;
    private String address;
    private String State;
    private String suburb;
    private int price;
    private PropertyType propertyType;
    private int numOfBathroom;
    private int numOfParkingSpaces;
    private int ownerContact;
    private String ownerName;
    private TransactionType transactionType;

    public PropertyProfile(int id, Timestamp createAt, int userId, String property_image_link,
        String address, String state, String suburb, int price,
        PropertyType propertyType, int numOfBathroom, int numOfParkingSpaces, int ownerContact,
        String ownerName, TransactionType transactionType) {
      this.id = id;
      this.createAt = createAt;
      this.userId = userId;
      this.property_image_link = property_image_link;
      this.address = address;
      State = state;
      this.suburb = suburb;
      this.price = price;
      this.propertyType = propertyType;
      this.numOfBathroom = numOfBathroom;
      this.numOfParkingSpaces = numOfParkingSpaces;
      this.ownerContact = ownerContact;
      this.ownerName = ownerName;
      this.transactionType = transactionType;
    }

    public int getId() {
      return id;
    }

    public Timestamp getCreateAt() {
      return createAt;
    }

    public int getUserId() {
      return userId;
    }

    public String getProperty_image_link() {
      return property_image_link;
    }

    public String getAddress() {
      return address;
    }

    public String getState() {
      return State;
    }

    public String getSuburb() {
      return suburb;
    }

    public int getPrice() {
      return price;
    }

    public PropertyType getPropertyType() {
      return propertyType;
    }

    public int getNumOfBathroom() {
      return numOfBathroom;
    }

    public int getNumOfParkingSpaces() {
      return numOfParkingSpaces;
    }

    public int getOwnerContact() {
      return ownerContact;
    }

    public String getOwnerName() {
      return ownerName;
    }

    public TransactionType getTransactionType() {
      return transactionType;
    }
  }

  public int createPropertyProfile(
      int userId,
      String property_image_link,
      String address,
      String state,
      String suburb,
      int price,
      PropertyType propertyType,
      int numOfBathroom,
      int numOfParkingSpaces,
      int ownerContact,
      String ownerName,
      TransactionType transactionType
  ) {

    int result = 0;

    try {
      JdbcConnector jdbcConnector = new JdbcConnector(URL, USER, PASSWORD, DRIVER);
      jdbcConnector.Connectivity();

      PreparedStatement entry = jdbcConnector
          .preStatement(
              "INSERT INTO property_Profiles (create_at, user_id,"
                  + " property_image_link, address,"
                  + " State, suburb, price,"
                  + " property_type, Num_of_bathroom,"
                  + " Num_of_Parking_Spaces, owner_contact,"
                  + " owner_name, transaction_type"
                  + ") VALUES (current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?)");

      entry.setInt(1, userId);
      entry.setString(2, property_image_link);
      entry.setString(3, address);
      entry.setString(4, state);
      entry.setString(5, suburb);
      entry.setInt(6, price);
//      instead of .toString() not to lost the type
//      preparedStatement.setString(1, MY_ENUM.name());
      entry.setString(7, propertyType.name());
      entry.setInt(8, numOfBathroom);
      entry.setInt(9, numOfParkingSpaces);
      entry.setInt(10, ownerContact);
      entry.setString(11, ownerName);
      entry.setString(12, transactionType.name());

      result = entry.executeUpdate();

      jdbcConnector.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }


  public void printPropertyProfiles() {

    LinkedList<PropertyProfile> propertyProfiles = new LinkedList<PropertyProfile>();
    int id;
    Timestamp createAt;
    int userId;
    String propertyImageLink;
    String address;
    String state;
    String suburb;
    int price;
    PropertyType propertyType;
    int numOfBathroom;
    int numOfParkingSpaces;
    int ownerContact;
    String ownerName;
    TransactionType transactionType;

    try {

      JdbcConnector jdbcConnector = new JdbcConnector(URL, USER, PASSWORD, DRIVER);
      jdbcConnector.Connectivity();

      PreparedStatement entry = jdbcConnector
          .preStatement("SELECT * FROM property_profiles");

      ResultSet results = entry.executeQuery();

      while (results.next()) {

        id = results.getInt("id");
        createAt = results.getTimestamp("create_at");
        userId = results.getInt("user_id");
        propertyImageLink = results.getString("property_image_link");
        address = results.getString("address");
        state = results.getString("state");
        suburb = results.getString("suburb");
        price = results.getInt("price");
        propertyType = PropertyType.valueOf(results.getString("property_type"));
        numOfBathroom = results.getInt("num_of_bathroom");
        numOfParkingSpaces = results.getInt("num_of_parking_spaces");
        ownerContact = (int) results.getLong("owner_contact");
        ownerName = results.getString("owner_name");
        transactionType = TransactionType.valueOf(results.getString("transaction_type"));

        PropertyProfile propertyProfile = new PropertyProfile(
            id,
            createAt,
            userId,
            propertyImageLink,
            address,
            state,
            suburb,
            price,
            propertyType,
            numOfBathroom,
            numOfParkingSpaces,
            ownerContact,
            ownerName,
            transactionType
        );

        propertyProfiles.add(propertyProfile);

      }

      propertyProfiles.forEach(property ->
          System.out.println(
              property.getId() +
                  " " +
                  property.getPrice()
//                  +
//                  " " +
//                  property.getId() +
//                  " " +
//                  property.getId() +
//                  " " +
//                  property.getId() +
//                  " " +
//                  property.getId() +
//                  " " +
//                  property.getId() +
//                  " " +
//                  property.getId() +
//                  " " +
//                  property.getId() +
//                  " " +
          ));


    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
