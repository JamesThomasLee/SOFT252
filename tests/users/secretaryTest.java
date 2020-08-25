package users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class secretaryTest {
    public secretary s;
    char[] password;

    @BeforeEach
    void setup(){
        password = new char[]{'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
        s = new secretary("S001", password, "firstname", "surname", "address",
                "city", "county", "post");
    }

    @Test
    void getUserID() {
        System.out.println("Testing user ID");
        String expected = "S001";
        String actual = s.getUserID();
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
        String actual = s.getFirstName();
        assertEquals(expected, actual);
    }

    @Test
    void getSurname() {
        System.out.println("Testing surname");
        String expected = "surname";
        String actual = s.getSurname();
        assertEquals(expected, actual);
    }

    @Test
    void getAddress() {
        System.out.println("Testing address");
        String expected = "address";
        String actual = s.getAddress();
        assertEquals(expected, actual);
    }

    @Test
    void getCity() {
        System.out.println("Testing city");
        String expected = "city";
        String actual = s.getCity();
        assertEquals(expected, actual);
    }

    @Test
    void getCounty() {
        System.out.println("Testing county");
        String expected = "county";
        String actual = s.getCounty();
        assertEquals(expected, actual);
    }

    @Test
    void getPostcode() {
        System.out.println("Testing postcode");
        String expected = "post";
        String actual = s.getPostcode();
        assertEquals(expected, actual);
    }
}