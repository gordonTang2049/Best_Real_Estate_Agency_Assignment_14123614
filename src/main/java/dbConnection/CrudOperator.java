package dbConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrudOperator {

  //  Create
  public String createUser() {
    String createUser = "INSERT INTO users (user_name, password_digest) VALUES (?, ?);";
    return createUser;
  }

  // read -> login
  public String selectUser() {
    String selectUser = "SELECT * from users where user_name='?'";
    return selectUser;
  }

  public String createPropertyProfile() {
//    13 fields
    String createPropertyProfile =
        "INSERT INTO property_Profiles (create_at, user_id, property_image_link,"
            + "address, State, suburb, price, property_type, Num_of_bathroom, Num_of_Parking_Spaces,"
            + "owner_contact, owner_name, transaction_type) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

    return createPropertyProfile;
  }

  public String createAdvertisementProfile() {
//    5 fields
    String createAdvertisementProfile = "INSERT INTO advertisement_profile ("
        + "create_at, advertisement_start_date, advertisement_finish_date,"
        + "user_id, property_Profiles_id) VALUES (?,?,?,?,?)";

    return createAdvertisementProfile;
  }

  public String allProperty() {
    return "Select * from property_Profiles";
  }

  public String allAdvertisement() {
    return "Select * from advertisement_profile";
  }

  public String allUser() {
    return "Select * from users";
  }


}

//  INSERT INTO users (user_name, password_digest) VALUES ('dummyUsers1', 'dummyPassword1');