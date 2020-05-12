
package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import AddressBook.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddressBookIT {
  //Creating the stub
  private AddressBook bookStub;

  //Creating the mocks
  private AddressBook bookMock = new AddressBook();
  private Person personMock = mock(Person.class);

  private Person personTest = new Person("test", "person", "street", "city",
      "state", "num", "phone");


  //Initializing the stub
  @BeforeEach
  public void setUp() {
    bookStub = mock(AddressBook.class);


  }
  //Using a stub to test if a person is added correctly
  @Test
  void addToStub() {
    bookStub.add(personTest);
    assertEquals(personTest.getFirstName(), "test");
  }

  //Using a Mock to test that removing a person
  @Test
  void removeMock() {
    bookMock.add(personMock);
    bookMock.remove(0);
    assertEquals(bookMock.getRowCount(), 0);
  }

}
