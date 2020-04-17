package Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import AddressBook.AddressBook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

import AddressBook.*;

class AddressBookTest {

  private AddressBook bookStub;


  private AddressBook bookMock = new AddressBook();
  private Person personMock = mock(Person.class);

  private AddressBook bookTest = new AddressBook();
  private Person personTest = new Person("test", "person", "street", "city",
      "state", "num", "phone");

  @BeforeEach
  public void setUp() {
    bookStub = mock(AddressBook.class);


  }


  @Test
  void addToStub() {
    bookStub.add(personTest);
    Assertions.assertEquals(personTest.getFirstName(), "test");
  }

  @Test
  void removeMock() {
    bookMock.add(personMock);
    bookMock.remove(0);
    assertEquals(bookMock.getRowCount(), 0);
  }

  @Test
  void getPersons() {
    AddressBook getTest = new AddressBook();
    Person[] result = getTest.getPersons();
    assertArrayEquals(result, getTest.getPersons());
  }

  @Test
  void set() {

    AddressBook setTest = new AddressBook();
    setTest.add(personTest);
    assertEquals(setTest.get(0), personTest);
    setTest.set(0, null);
    assertEquals(setTest.get(0), null);

  }

  @Test
  void get() {
    bookTest.add(personTest);
    bookTest.get(0);
    assertEquals(personTest, bookTest.get(0));

  }

  @Test
  void clear() {
    bookTest.add(personTest);
    bookTest.clear();
    assertEquals(bookTest.getRowCount(), 0);
  }

  @Test
  void getRowCount() {
    int rows = bookTest.getRowCount();
    assertEquals(rows, bookTest.getRowCount());
  }

  @Test
  void getColumnCount() {
    int columns = bookTest.getColumnCount();
    assertEquals(columns, bookTest.getColumnCount());
  }

  @Test
  void getValueAt() {
    bookTest.add(personTest);

    assertEquals(bookTest.getValueAt(0, 0), personTest.getLastName());


  }

  @Test
  void getColumnName() {
    String colName = bookTest.getColumnName(0);

    assertEquals(colName, bookTest.getColumnName(0));

  }


}