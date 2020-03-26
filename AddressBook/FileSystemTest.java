package AddressBook;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.jupiter.api.*;



public class FileSystemTest {

  private AddressBook TestBook;
  private File file;

  @BeforeEach
  void setUp(){
    TestBook = new AddressBook();

  }


  @Test
  void saveFile(AddressBook addressBook, File file) throws SQLException {

    Connection connection = DriverManager.getConnection("jdbc:sqlite:" + file.getAbsolutePath());
    Statement statement = connection.createStatement();
    statement.execute("DROP TABLE IF EXISTS persons");
    statement.execute("CREATE TABLE persons (firstName TEXT, lastName TEXT, address TEXT, city TEXT, state TEXT, zip TEXT, phone TEXT)");
    // Insert the data into the database
    PreparedStatement insert = connection.prepareStatement("INSERT INTO persons (lastName, firstName, address, city, state, zip, phone) VALUES (?, ?, ?, ?, ?, ?, ?)");
    for (Person p : addressBook.getPersons()) {
      for (int i = 0; i < Person.fields.length; i++) {
        insert.setString(i + 1, p.getField(i));
      }
      insert.executeUpdate();
    }

    connection.close();

  }

}
