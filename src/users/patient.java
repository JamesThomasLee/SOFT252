package users;
import java.io.Serializable;

public class patient extends user implements Serializable{
    protected String gender;
    protected String approved;

    public patient(String userID, String password, String firstName, String surname, String address, String city, String county, String postcode, String gender, String approved) {
        this.userID = userID;
        this.password = password;
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
        this.city = city;
        this.county = county;
        this.postcode = postcode;
        this.gender = gender;
        this.approved = approved;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }
}
