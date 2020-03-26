package AddressBook;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.*;

public class PersonTest {

  private Person TestPerson;

  @BeforeEach
  void setUP() {
    TestPerson = new Person("test", "person", "street", "city",
        "state", "num", "phone");
  }

  @Test
  void getFirstName() {
    String firstName = TestPerson.getFirstName();
    assertEquals("test", firstName);
  }

  @Test
  void getLastName() {
    String lastName = TestPerson.getLastName();
    assertEquals("person", lastName);
  }

  @Test
  void getAddress() {
    String address = TestPerson.getAddress();
    assertEquals("street", address);
  }

  @Test
  void getFieldFirstName() {
    int field = 1;
    String firstName = TestPerson.getFirstName();

    String testFirstName = TestPerson.getField(field);

    assertEquals(firstName, testFirstName);

  }

  @Test
  void getFieldCity() {
    int field = 3;
    String city = TestPerson.getCity();

    String testCity = TestPerson.getField(field);

    assertEquals(city, testCity);

  }




}
