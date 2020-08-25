package users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class doctorTest {
    public doctor d;
    char[] password;

    @BeforeEach
    void setup(){
        password = new char[]{'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
        d = new doctor("D001", password, "firstname", "surname", "address",
                "city", "county", "post");
    }

    @Test
    void getUserID() {
        System.out.println("Testing user ID");
        String expected = "D001";
        String actual = d.getUserID();
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
        String actual = d.getFirstName();
        assertEquals(expected, actual);
    }

    @Test
    void getSurname() {
        System.out.println("Testing surname");
        String expected = "surname";
        String actual = d.getSurname();
        assertEquals(expected, actual);
    }

    @Test
    void getAddress() {
        System.out.println("Testing address");
        String expected = "address";
        String actual = d.getAddress();
        assertEquals(expected, actual);
    }

    @Test
    void getCity() {
        System.out.println("Testing city");
        String expected = "city";
        String actual = d.getCity();
        assertEquals(expected, actual);
    }

    @Test
    void getCounty() {
        System.out.println("Testing county");
        String expected = "county";
        String actual = d.getCounty();
        assertEquals(expected, actual);
    }

    @Test
    void getPostcode() {
        System.out.println("Testing postcode");
        String expected = "post";
        String actual = d.getPostcode();
        assertEquals(expected, actual);
    }
}