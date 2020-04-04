package Test;

import static org.junit.jupiter.api.Assertions.*;

import AddressBook.AddressBook;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import AddressBook.*;



class AddressBookControllerTest {

  AddressBook bookTest = new AddressBook();
  AddressBookController controllerTest = new AddressBookController(bookTest);
  Person personTest = new Person("test", "person", "street", "city",
      "state", "num", "phone");
  Person personTest2 = new Person("Jordan", "Moses", "street coastal",
      "Estero", "Florida", "33967", "12345");

  @Test
  void add() {
    controllerTest.add(personTest);
    Assertions.assertEquals(personTest, controllerTest.get(0));
  }

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

  @Test
  void remove() {
    controllerTest.add(personTest);
    controllerTest.set(0, personTest);
    controllerTest.remove(0);

    assertEquals(0, bookTest.getRowCount());

  }

  @Test
  void get() {
    controllerTest.add(personTest);
    controllerTest.set(0, personTest);
    controllerTest.get(0);

    Assertions.assertEquals(personTest, controllerTest.get(0));
  }

  @Test
  void clear() {
    controllerTest.add(personTest);

    Assertions.assertEquals(personTest, controllerTest.get(0));

    controllerTest.clear();

    assertEquals(0, bookTest.getRowCount());
  }

  @Test
  void open() throws FileNotFoundException, SQLException {

    Throwable exception = assertThrows(FileNotFoundException.class, ()-> {
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

  @Test
  void getModel() {

    Assertions.assertEquals(bookTest, controllerTest.getModel());

  }
}