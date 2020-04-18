package Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import AddressBook.AddressBook;
import AddressBook.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PersonTest {

  //Creating the testing objects
  private Person testPerson;
  private AddressBook testBook;

  //Initializing the testing objects
  @BeforeEach
  void setUP() {
    testPerson = new Person("test", "person", "street", "city",
        "state", "zip", "phone");
    testBook = new AddressBook();
    testBook.add(testPerson);
  }

  //Testing that the first name can be properly retrieved
  @Test
  void getFirstName() {
    String firstName = testPerson.getFirstName();
    assertEquals("test", firstName);
  }

  //Testing that the last name can be properly retrieved
  @Test
  void getLastName() {
    String lastName = testPerson.getLastName();
    assertEquals("person", lastName);
  }

  //Testing that the address can be properly retrieved
  @Test
  void getAddress() {
    String address = testPerson.getAddress();
    assertEquals("street", address);
  }

  //Testing that the city can be properly retrieved
  @Test
  void getCity() {
    String city = testPerson.getCity();
    assertEquals("city", city);
  }

  //Testing that the zip code string can be properly retrieved
  @Test
  void getZip() {
    String zip = testPerson.getZip();
    assertEquals("zip", zip);
  }

  //Testing that the phone number string can be properly retrieved
  @Test
  void getPhone() {
    String phone = testPerson.getPhone();
    assertEquals("phone", phone);
  }

  //Testing that all inputs can be searched by partial strings
  @Test
  void containsString() {
    boolean firstName = testPerson.containsString("tes");
    boolean lastName = testPerson.containsString("per");
    boolean address = testPerson.containsString("str");
    boolean city = testPerson.containsString("cit");
    boolean zip = testPerson.containsString("zi");
    boolean phone = testPerson.containsString("pho");

    assertTrue(firstName);
    assertTrue(lastName);
    assertTrue(address);
    assertTrue(city);
    assertTrue(zip);
    assertTrue(phone);
  }

  //Testing that book can be sorted by field
  @Test
  void getField() {
    String lastName = testPerson.getField(0);
    String firstName = testPerson.getField(1);
    String address = testPerson.getField(2);
    String city = testPerson.getField(3);
    String state = testPerson.getField(4);
    String zip = testPerson.getField(5);
    String phone = testPerson.getField(6);
    Exception exception = assertThrows(Exception.class, () -> testPerson.getField(8));

    assertEquals("test", firstName);
    assertEquals("person", lastName);
    assertEquals("street", address);
    assertEquals("city", city);
    assertEquals("state", state);
    assertEquals("zip", zip);
    assertEquals("phone", phone);

    assertEquals("Field number out of bounds", exception.getMessage());

  }

  //Testing that the book can be printed out
  @Test
  void testToString() {
    assertEquals("person, test", testPerson.toString());
  }

  //Checking that exceptions are thrown if an field is either empty or null
  @Test
  void personFirstNameEmpty() {
    assertThrows(IllegalArgumentException.class, () -> new Person("", "person",
        "street", "city", "state", "zip", "phone"));
  }

  @Test
  void personFirstNameNull() {
    assertThrows(IllegalArgumentException.class, () -> new Person(null, "person",
        "street", "city", "state", "zip", "phone"));
  }

  @Test
  void personLastNameEmpty() {
    assertThrows(IllegalArgumentException.class, () -> new Person("test", "",
        "street", "city", "state", "zip", "phone"));
  }

  @Test
  void personLastNameNull() {
    assertThrows(IllegalArgumentException.class, () -> new Person("test", null,
        "street", "city", "state", "zip", "phone"));
  }

  @Test
  void personAddressEmptyTest() {
    assertThrows(IllegalArgumentException.class, () -> new Person("test", "person",
        "", "city", "state", "zip", "phone"));
  }

  @Test
  void personAddressNull() {
    assertThrows(IllegalArgumentException.class, () -> new Person("test", "person",
        null, "city", "state", "zip", "phone"));
  }

  @Test
  void personCityEmpty() {
    assertThrows(IllegalArgumentException.class, () -> new Person("test", "person",
        "street", "", "state", "zip", "phone"));
  }

  @Test
  void personCityNull() {
    assertThrows(IllegalArgumentException.class, () -> new Person("test", "person",
        "street", null, "state", "zip", "phone"));
  }

  @Test
  void personStateEmpty() {
    assertThrows(IllegalArgumentException.class, () -> new Person("test", "person",
        "street", "city", "", "zip", "phone"));
  }

  @Test
  void personStateNull() {
    assertThrows(IllegalArgumentException.class, () -> new Person("test", "person",
        "street", "city", null, "zip", "phone"));
  }

  @Test
  void personZipEmpty() {
    assertThrows(IllegalArgumentException.class, () -> new Person("test", "person",
        "street", "city", "state", "", "phone"));
  }

  @Test
  void personZipNull() {
    assertThrows(IllegalArgumentException.class, () -> new Person("test", "person",
        "street", "city", "state", null, "phone"));
  }

  @Test
  void personPhoneEmpty() {
    assertThrows(IllegalArgumentException.class, () -> new Person("test", "person",
        "street", "city", "state", "zip", ""));
  }

  @Test
  void personPhoneNull() {
    assertThrows(IllegalArgumentException.class, () -> new Person("test", "person",
        "street", "city", "state", "zip", null));
  }


}
