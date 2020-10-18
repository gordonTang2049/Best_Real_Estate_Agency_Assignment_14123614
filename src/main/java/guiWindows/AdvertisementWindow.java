package guiWindows;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectStreamClass;
import java.util.LinkedList;
import java.util.Objects;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AdvertisementWindow extends JFrame implements ActionListener {

  private class AdvertisementProperty {

    private String propertyImageLink;
    private String dateOfAdvertisement;
    private String contactName;
    private String contactNumber;
    private String address;
    private String state;
    private String suburb;
    private String price;
    private String propertyType;
    private String numOfBathroom;
    private String numOfParkingSpaces;
    private String transactionType;

    public AdvertisementProperty(String propertyImageLink, String dateOfAdvertisement,
        String contactName, String contactNumber, String address, String state, String suburb,
        String price, String propertyType, String numOfBathroom, String numOfParkingSpaces,
        String transactionType) {
      this.propertyImageLink = propertyImageLink;
      this.dateOfAdvertisement = dateOfAdvertisement;
      this.contactName = contactName;
      this.contactNumber = contactNumber;
      this.address = address;
      this.state = state;
      this.suburb = suburb;
      this.price = price;
      this.propertyType = propertyType;
      this.numOfBathroom = numOfBathroom;
      this.numOfParkingSpaces = numOfParkingSpaces;
      this.transactionType = transactionType;
    }

    public String getPropertyImageLink() {
      return propertyImageLink;
    }

    public String getDateOfAdvertisement() {
      return dateOfAdvertisement;
    }

    public String getContactName() {
      return contactName;
    }

    public String getContactNumber() {
      return contactNumber;
    }

    public String getAddress() {
      return address;
    }

    public String getState() {
      return state;
    }

    public String getSuburb() {
      return suburb;
    }

    public String getPrice() {
      return price;
    }

    public String getPropertyType() {
      return propertyType;
    }

    public String getNumOfBathroom() {
      return numOfBathroom;
    }

    public String getNumOfParkingSpaces() {
      return numOfParkingSpaces;
    }

    public String getTransactionType() {
      return transactionType;
    }
  }

  private JPanel advertisementPanel;

  private String[] header = {
      "Property Image Link123",
      "Date of Advertisement",
      "Contact Name",
      "Contact Number",
      "Address",
      "State",
      "Suburb",
      "Price",
      "Property Type",
      "Number of Bathroom",
      "Number of Parking Spaces",
      "Transaction Type"
  };

  private LinkedList<AdvertisementProperty> advertisementProperties = new LinkedList<AdvertisementProperty>();

  public AdvertisementWindow(String title) {
    super(title);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(advertisementPanel);
    this.pack();

  }


  @Override
  public void actionPerformed(ActionEvent actionEvent) {

  }

  private void createUIComponents() {
    // TODO: place custom component creation code here
  }
}
//
//  DefaultTableModel dm = new DefaultTableModel(0, 0);
//  String header[] = new String[] { "Status", "Task Title", "Start",
//      "Pause", "Stop", "Statulses" };
//    dm.setColumnIdentifiers(header);
//        tblTaskList.setModel(dm);
//
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

//
//  DefaultTableModel dm = new DefaultTableModel();
//    table1 = new JTable(dm);
//        dm.addColumn("col1");
//        dm.addColumn("col2");
//        dm.addRow(new Object[]{"1","2"});
//
//    table1 = new JTable(advertisementProperties, header);

//    dm.addColumn("123");
//      dm.setColumnIdentifiers(header);
//    for(int count = 1; count <=30; count++){
//      dm.addRow(header1);
//    }
//    Object[] row = new Object[2];
//    advertisementProperties.forEach(property -> {

//      dm.addRow(header1);
//
//    });

/*
  AdvertisementProperty advertisementProperty1 = new AdvertisementProperty("1", "2", "3", "4",
      "5", "6", "7", "8", "9", "10", "11", "12");
  AdvertisementProperty advertisementProperty2 = new AdvertisementProperty("1", "2", "3", "4",
      "5", "6", "7", "8", "9", "10", "11", "12");

    advertisementProperties.add(advertisementProperty1);
        advertisementProperties.add(advertisementProperty2);


    table1 = new JTable();
    DefaultTableModel dtm = new DefaultTableModel(0, 0);
// add header of the table
    String header[] = new String[] { "Prority", "Task Title", "Start",
        "Pause", "Stop", "Statulses" };

// add header in table model
    dtm.setColumnIdentifiers(header);

 //set model into the table object
    table1.setModel(dtm);

    // add row dynamically into the table
    for (int count = 1; count <= 30; count++) {
      dtm.addRow(new Object[] { "data", "data", "data",
          "data", "data", "data" });
    }
 */
