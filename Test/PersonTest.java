package Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.*;
import AddressBook.*;


public class PersonTest {

  private Person testPerson;
  private AddressBook testBook;

  @BeforeEach
  void setUP() {
    testPerson = new Person("test", "person", "street", "city",
        "state", "zip", "phone");
    testBook = new AddressBook();
    testBook.add(testPerson);
  }

  @Test
  void getFirstName() {
    String firstName = testPerson.getFirstName();
    assertEquals("test", firstName);
  }

  @Test
  void getLastName() {
    String lastName = testPerson.getLastName();
    assertEquals("person", lastName);
  }

  @Test
  void getAddress() {
    String address = testPerson.getAddress();
    assertEquals("street", address);
  }

  @Test
  void getCity(){
    String city = testPerson.getCity();
    assertEquals("city", city);
  }

  @Test
  void getZip(){
    String zip = testPerson.getZip();
    assertEquals("zip", zip);
  }

  @Test
  void getPhone(){
    String phone = testPerson.getPhone();
    assertEquals("phone", phone);
  }

  @Test
  void containsString(){
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

  @Test
  void testToString(){
    assertEquals("person, test", testPerson.toString());
  }

  @Test
  void personFirstNameEmpty(){
    assertThrows(IllegalArgumentException.class, ()-> new Person("", "person",
        "street", "city", "state", "zip", "phone"));
  }

  @Test
  void personFirstNameNull(){
    assertThrows(IllegalArgumentException.class, ()-> new Person(null, "person",
        "street", "city", "state", "zip", "phone"));
  }

  @Test
  void personLastNameEmpty(){
    assertThrows(IllegalArgumentException.class, ()-> new Person("test", "",
        "street", "city", "state", "zip", "phone"));
  }

  @Test
  void personLastNameNull(){
    assertThrows(IllegalArgumentException.class, ()-> new Person("test", null,
        "street", "city", "state", "zip", "phone"));
  }

  @Test
  void personAddressEmptyTest(){
    assertThrows(IllegalArgumentException.class, ()-> new Person("test", "person",
        "", "city", "state", "zip", "phone"));
  }
  @Test
  void personAddressNull(){
    assertThrows(IllegalArgumentException.class, ()-> new Person("test", "person",
        null, "city", "state", "zip", "phone"));
  }
  @Test
  void personCityEmpty(){
    assertThrows(IllegalArgumentException.class, ()-> new Person("test", "person",
        "street", "", "state", "zip", "phone"));
  }
  @Test
  void personCityNull(){
    assertThrows(IllegalArgumentException.class, ()-> new Person("test", "person",
        "street", null, "state", "zip", "phone"));
  }
  @Test
  void personStateEmpty(){
    assertThrows(IllegalArgumentException.class, ()-> new Person("test", "person",
        "street", "city", "", "zip", "phone"));
  }
  @Test
  void personStateNull(){
    assertThrows(IllegalArgumentException.class, ()-> new Person("test", "person",
        "street", "city", null, "zip", "phone"));
  }
  @Test
  void personZipEmpty(){
    assertThrows(IllegalArgumentException.class, ()-> new Person("test", "person",
        "street", "city", "state", "", "phone"));
  }
  @Test
  void personZipNull(){
    assertThrows(IllegalArgumentException.class, ()-> new Person("test", "person",
        "street", "city", "state", null, "phone"));
  }
  @Test
  void personPhoneEmpty(){
    assertThrows(IllegalArgumentException.class, ()-> new Person("test", "person",
        "street", "city", "state", "zip", ""));
  }
  @Test
  void personPhoneNull(){
    assertThrows(IllegalArgumentException.class, ()-> new Person("test", "person",
        "street", "city", "state", "zip", null));
  }




}
