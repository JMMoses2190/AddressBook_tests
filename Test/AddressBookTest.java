package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import AddressBook.AddressBook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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


  }

  @Test
  void set() {
    bookTest.add(personTest);
    bookTest.set(0, personTest);

  }

  @Test
  void get() {
    bookTest.add(personTest);
    bookTest.get(0);

  }

  @Test
  void clear() {
    bookTest.add(personTest);
    bookTest.clear();
  }

  @Test
  void getRowCount() {
    bookTest.getRowCount();
  }

  @Test
  void getColumnCount() {
    bookTest.getColumnCount();
  }

  @Test
  void getValueAt() {
    bookTest.add(personTest);
    bookTest.getValueAt(0, 0);

  }

  @Test
  void getColumnName() {
    bookTest.getColumnName(0);
  }


}