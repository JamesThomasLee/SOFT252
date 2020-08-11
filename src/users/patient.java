package users;
import java.io.Serializable;

public class patient extends user implements Serializable{
    protected String gender;

    public patient(String userType, String userID, String password, String firstName, String surname, String address, String city, String county, String postcode, String gender) {
        this.userType = userType;
        this.userID = userID;
        this.password = password;
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
        this.city = city;
        this.county = county;
        this.postcode = postcode;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
