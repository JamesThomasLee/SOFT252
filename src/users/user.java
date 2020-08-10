package users;
import java.io.Serializable;

public class user implements Serializable{
    protected String userType;
    protected String password;
    protected String firstName;
    protected String surname;
    protected String gender;
    protected String address;
    protected String city;
    protected String county;
    protected String postcode;
    protected String tel;
    protected String email;
    protected String userID;
    //protected IState state;

    public user(String type, String password, String forename, String surname, String gender, String address, String city, String county, String postcode, String tel, String email, String username) {
        this.userType = type;
        this.password = password;
        this.firstName = forename;
        this.surname = surname;
        this.gender = gender;
        this.address = address;
        this.city = city;
        this.county = county;
        this.postcode = postcode;
        this.tel = tel;
        this.email = email;
        this.userID = username;
    }


    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*
    public IState getState() {

        return state;
    }

    public void setState(IState state) {
        this.state = state;
    }
    */
}
