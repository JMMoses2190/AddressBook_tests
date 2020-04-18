package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import AddressBook.AddressBook;
import AddressBook.AddressBookController;
import AddressBook.FileSystem;
import AddressBook.Person;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class AddressBookControllerTest {

  //Initialize Unit testing objects
  AddressBook bookTest = new AddressBook();
  AddressBookController controllerTest = new AddressBookController(bookTest);
  Person personTest = new Person("test", "person", "street", "city",
      "state", "num", "phone");
  Person personTest2 = new Person("Jordan", "Moses", "street coastal",
      "Estero", "Florida", "33967", "12345");


  //Testing that person is properly added to a book
  @Test
  void add() {
    controllerTest.add(personTest);
    Assertions.assertEquals(personTest, controllerTest.get(0));
  }

  //Testing that a person is specifically set to given index
  @Test
  void set() {
    controllerTest.add(personTest2);
    controllerTest.add(personTest);

    Assertions.assertEquals(personTest2, controllerTest.get(0));
    Assertions.assertEquals(personTest, controllerTest.get(1));

    controllerTest.set(1, personTest2);
    controllerTest.set(0, personTest);

    Assertions.assertEquals(personTest, controllerTest.get(0));
    Assertions.assertEquals(personTest2, controllerTest.get(1));
  }

  //Testing that a person can be properly removed from book
  @Test
  void remove() {
    controllerTest.add(personTest);
    controllerTest.set(0, personTest);
    controllerTest.remove(0);

    assertEquals(0, bookTest.getRowCount());

  }

  //Test that a person can be retrieved from a given index
  @Test
  void get() {
    controllerTest.add(personTest);
    controllerTest.set(0, personTest);
    controllerTest.get(0);

    Assertions.assertEquals(personTest, controllerTest.get(0));
  }

  //Test that an address book can be cleared
  @Test
  void clear() {
    controllerTest.add(personTest);

    Assertions.assertEquals(personTest, controllerTest.get(0));

    controllerTest.clear();

    assertEquals(0, bookTest.getRowCount());
  }

  //Test that time to open is less than 5 seconds
  @Test
  void timeToOpen() throws FileNotFoundException, SQLException {
    //Start timing the process
    long startTime = System.nanoTime();
    long endTime = 0;

    Throwable exception = assertThrows(FileNotFoundException.class, () -> {
      throw new FileNotFoundException("FileNotFound");
    });

    Throwable exception2 = assertThrows(SQLException.class, () -> {
      throw new SQLException("SQL Exception");
    });

    File fileTest = new File("Book Test");
    new FileSystem().saveFile(bookTest, fileTest);
    controllerTest.open(new File("Book Test"));

    boolean canReadTest = fileTest.canRead();

    assertEquals("SQL Exception", exception2.getMessage());
    assertEquals("FileNotFound", exception.getMessage());

    //If process completes successfully then set ending time
    if (canReadTest == true) {
      endTime = System.nanoTime();
    }

    //Calculate how long it too and convert to seconds from nanoseconds
    long timeElapsed = endTime - startTime;
    double seconds = (double) timeElapsed / 1000000000.0;

    boolean testPassed = false;

    //If the time is less than required 5 seconds then the test will pass
    if (seconds <= 5.0) {
      testPassed = true;
    }

    assertTrue(testPassed);

  }

  //Testing tha file can be properly opened
  @Test
  void open() throws FileNotFoundException, SQLException {

    Throwable exception = assertThrows(FileNotFoundException.class, () -> {
      throw new FileNotFoundException("FileNotFound");
    });

    Throwable exception2 = assertThrows(SQLException.class, () -> {
      throw new SQLException("SQL Exception");
    });

    File fileTest = new File("Book Test");
    new FileSystem().saveFile(bookTest, fileTest);
    controllerTest.open(new File("Book Test"));

    boolean canReadTest = fileTest.canRead();

    assertEquals("SQL Exception", exception2.getMessage());
    assertEquals("FileNotFound", exception.getMessage());
    assertTrue(canReadTest);

  }


  //Testing that a file can be properly saved
  @Test
  void save() throws SQLException {

    Throwable exception2 = assertThrows(SQLException.class, () -> {
      throw new SQLException("SQL Exception");
    });

    File fileTest = new File("Book Test");
    controllerTest.save(fileTest);

    boolean existTest = fileTest.exists();

    assertTrue(existTest);

  }

  
}