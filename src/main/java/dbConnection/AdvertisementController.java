package dbConnection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.concurrent.ExecutionException;

public class AdvertisementController {

  private static final String URL = "jdbc:postgresql:ENV_DB";
  private static final String USER = "ENV_USER";
  private static final String PASSWORD = "ENV_PASSWORD";
  private static final String DRIVER = "org.postgresql.Driver";


  private class Advertisement {

    private int id;
    private Timestamp createAt;
    private Timestamp advertisementStartDate;
    private Timestamp advertisementFinishDate;
    private int userId;
    private int propertyProfilesId;

    public Advertisement(int id, Timestamp createAt, Timestamp advertisementStartDate,
        Timestamp advertisementFinishDate, int userId, int propertyProfilesId) {
      this.id = id;
      this.createAt = createAt;
      this.advertisementStartDate = advertisementStartDate;
      this.advertisementFinishDate = advertisementFinishDate;
      this.userId = userId;
      this.propertyProfilesId = propertyProfilesId;
    }

    public int getId() {
      return id;
    }

    public Timestamp getCreateAt() {
      return createAt;
    }

    public Timestamp getAdvertisementStartDate() {
      return advertisementStartDate;
    }

    public Timestamp getAdvertisementFinishDate() {
      return advertisementFinishDate;
    }

    public int getUserId() {
      return userId;
    }

    public int getPropertyProfilesId() {
      return propertyProfilesId;
    }

  }


  public int createAdvertisement(
      int advertisementStartYear,
      int advertisementStartMonth,
      int advertisementStartDay,
      int advertisementFinishYear,
      int advertisementFinishMonth,
      int advertisementFinishDay,
      int userId,
      int PropertyProfilesId
  ) {

//    Calendar myCalendar = new GregorianCalendar(2014, 2, 11);
//    Date myDate = myCalendar.getTime();

    int result = 0;
    Calendar advertisementStartDate = Calendar.getInstance();
    Calendar advertisementFinishDate = Calendar.getInstance();

    advertisementStartDate
        .set(Calendar.YEAR, advertisementStartYear);
    advertisementStartDate
        .set(Calendar.MONTH, advertisementStartMonth);
    advertisementStartDate
        .set(Calendar.DAY_OF_MONTH, advertisementStartDay);

    advertisementFinishDate
        .set(Calendar.YEAR, advertisementFinishYear);
    advertisementFinishDate
        .set(Calendar.YEAR, advertisementFinishMonth);
    advertisementFinishDate
        .set(Calendar.YEAR, advertisementFinishDay);

    Timestamp advertisementStartTime = new Timestamp(advertisementStartDate.getTimeInMillis());
    Timestamp advertisementFinishTime = new Timestamp(advertisementFinishDate.getTimeInMillis());

    try {
      JdbcConnector jdbcConnector = new JdbcConnector(URL, USER, PASSWORD, DRIVER);
      jdbcConnector.Connectivity();

      PreparedStatement entry = jdbcConnector
          .preStatement(
              "INSERT INTO advertisement_profiles(create_at,"
                  + " advertisement_start_date, advertisement_finish_date,"
                  + " user_id, property_profiles_id) VALUES (current_timestamp,?,?,?,?)");
      entry.setTimestamp(1, advertisementStartTime);
      entry.setTimestamp(2, advertisementFinishTime);
      entry.setInt(3, userId);
      entry.setInt(4, PropertyProfilesId);

      result = entry.executeUpdate();

      jdbcConnector.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

  public void printAdvertisement() {
    LinkedList<Advertisement> Advertisements = new LinkedList<Advertisement>();
    int id;
    Timestamp createAt;
    Timestamp advertisementStartDate;
    Timestamp advertisementFinishDate;
    int userId;
    int propertyProfilesId;

    try {

      JdbcConnector jdbcConnector = new JdbcConnector(URL, USER, PASSWORD, DRIVER);
      jdbcConnector.Connectivity();

      PreparedStatement entry = jdbcConnector
          .preStatement("SELECT * FROM property_profiles");

      ResultSet results = entry.executeQuery();

      while(results.next()){

        id = results.getInt("id");
        createAt = results.getTimestamp("create_at");
        advertisementStartDate = results.getTimestamp("advertisement_start_date");
        advertisementFinishDate = results.getTimestamp("advertisement_finish_date");
        userId = results.getInt("user_id");
        propertyProfilesId = results.getInt("property_profiles_id");

        Advertisement advertisement = new Advertisement(
            id,
            createAt,
            advertisementStartDate,
            advertisementFinishDate,
            userId,
            propertyProfilesId
        );

        Advertisements.add(advertisement);
      }
      Advertisements.forEach(advertisement ->
              System.out.println(
                  advertisement.getId()
                      + " " +
                      advertisement.getAdvertisementStartDate()
                  )
          );

    } catch (Exception e) {
      e.printStackTrace();

    }

  }

}

/*
  String createAdvertisementProfile = "INSERT INTO advertisement_profile ("
      + "create_at, advertisement_start_date, advertisement_finish_date,"
      + "user_id, property_Profiles_id) VALUES (?,?,?,?,?)";
 */