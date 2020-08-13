package users;

public class secretary extends user{

    public secretary(String userID, char[] password, String firstName, String surname, String address, String city, String county, String postcode) {
        this.userID = userID;
        this.password = password;
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
        this.city = city;
        this.county = county;
        this.postcode = postcode;
    }
}
