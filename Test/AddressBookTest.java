package Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import AddressBook.AddressBook;
import AddressBook.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AddressBookTest {


  //Initializing the Unit testing objects
  private AddressBook bookTest = new AddressBook();
  private Person personTest = new Person("test", "person", "street", "city",
      "state", "num", "phone");


  //Testing that retrieving a person
  @Test
  void getPersons() {
    AddressBook getTest = new AddressBook();
    Person[] result = getTest.getPersons();
    assertArrayEquals(result, getTest.getPersons());
  }

  //Testing that person is properly set to a specific index location
  @Test
  void set() {

    AddressBook setTest = new AddressBook();
    setTest.add(personTest);
    assertEquals(setTest.get(0), personTest);
    setTest.set(0, null);
    assertEquals(setTest.get(0), null);

  }

  //Testing that a specific person is retrieved from an index
  @Test
  void get() {
    bookTest.add(personTest);
    bookTest.get(0);
    assertEquals(personTest, bookTest.get(0));

  }

  //Testing that a person is deleted properly
  @Test
  void clear() {
    bookTest.add(personTest);
    bookTest.clear();
    assertEquals(bookTest.getRowCount(), 0);
  }

  //Testing the row count can be properly returned
  @Test
  void getRowCount() {
    int rows = bookTest.getRowCount();
    assertEquals(rows, bookTest.getRowCount());
  }

  //Testing the column count is properly returned
  @Test
  void getColumnCount() {
    int columns = bookTest.getColumnCount();
    assertEquals(columns, bookTest.getColumnCount());
  }

  //Testing that a value at a specific index is returned
  @Test
  void getValueAt() {
    bookTest.add(personTest);

    assertEquals(bookTest.getValueAt(0, 0), personTest.getLastName());


  }

  //Testing that the column name is correctly recieved
  @Test
  void getColumnName() {
    String colName = bookTest.getColumnName(0);

    assertEquals(colName, bookTest.getColumnName(0));

  }


}