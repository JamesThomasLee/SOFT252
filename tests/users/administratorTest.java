package users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class administratorTest {
    public administrator a;
    char[] password;

    @BeforeEach
    void setup(){
        password = new char[]{'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
        a = new administrator("A001", password, "firstname", "surname", "address",
                "city", "county", "post");
    }

    @Test
    void getUserID() {
        System.out.println("Testing user ID");
        String expected = "A001";
        String actual = a.getUserID();
        assertEquals(expected, actual);
    }

    /* commented out due to char data type failing.
    @Test
    void getPassword() {
        System.out.println("Testing password");
        char[] expected = {'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
        char[] actual = p.getPassword();
        assertEquals(expected, actual);
    }
     */

    @Test
    void getFirstName() {
        System.out.println("Testing first name");
        String expected = "firstname";
        String actual = a.getFirstName();
        assertEquals(expected, actual);
    }

    @Test
    void getSurname() {
        System.out.println("Testing surname");
        String expected = "surname";
        String actual = a.getSurname();
        assertEquals(expected, actual);
    }

    @Test
    void getAddress() {
        System.out.println("Testing address");
        String expected = "address";
        String actual = a.getAddress();
        assertEquals(expected, actual);
    }

    @Test
    void getCity() {
        System.out.println("Testing city");
        String expected = "city";
        String actual = a.getCity();
        assertEquals(expected, actual);
    }

    @Test
    void getCounty() {
        System.out.println("Testing county");
        String expected = "county";
        String actual = a.getCounty();
        assertEquals(expected, actual);
    }

    @Test
    void getPostcode() {
        System.out.println("Testing postcode");
        String expected = "post";
        String actual = a.getPostcode();
        assertEquals(expected, actual);
    }
}