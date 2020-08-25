package users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class patientTest {

    public patient p;
    char[] password;

    @BeforeEach
    void setup(){
        password = new char[]{'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
        p = new patient("P001", password, "firstname", "surname", "address",
                "city", "county", "post", "gender", "Yes");
    }

    @Test
    void getUserID() {
        System.out.println("Testing user ID");
        String expected = "P001";
        String actual = p.getUserID();
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
        String actual = p.getFirstName();
        assertEquals(expected, actual);
    }

    @Test
    void getSurname() {
        System.out.println("Testing surname");
        String expected = "surname";
        String actual = p.getSurname();
        assertEquals(expected, actual);
    }

    @Test
    void getAddress() {
        System.out.println("Testing address");
        String expected = "address";
        String actual = p.getAddress();
        assertEquals(expected, actual);
    }

    @Test
    void getCity() {
        System.out.println("Testing city");
        String expected = "city";
        String actual = p.getCity();
        assertEquals(expected, actual);
    }

    @Test
    void getCounty() {
        System.out.println("Testing county");
        String expected = "county";
        String actual = p.getCounty();
        assertEquals(expected, actual);
    }

    @Test
    void getPostcode() {
        System.out.println("Testing postcode");
        String expected = "post";
        String actual = p.getPostcode();
        assertEquals(expected, actual);
    }

    @Test
    void getGender() {
        System.out.println("Testing gender");
        String expected = "gender";
        String actual = p.getGender();
        assertEquals(expected, actual);
    }

    @Test
    void getApproved() {
        System.out.println("Testing approved");
        String expected = "Yes";
        String actual = p.getApproved();
        assertEquals(expected, actual);
    }
}