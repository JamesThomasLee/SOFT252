package controller;

import users.patient;

import java.util.ArrayList;

public class loginRegistrationController {
    public static void registerUser(String type, String forename, String surname, String gender, String address, String city,
                                        String county, String postcode, String tel, String email, String password){

        String usernum = "001";
        String username = type + usernum;

        //create user
        //user registeredUser = new user(type, password, forename, surname, gender, address, city, county, postcode, tel, email, username);

        //create array list
        //ArrayList<user> user = new ArrayList();
        //Serialiser.writeObject(user);

        //deserialize array list
        ArrayList<patient> patient = new ArrayList();

        //add new user to array list




        //JFrame frame = new JFrame();
        //JOptionPane.showMessageDialog(frame, "User Registered\n" +
                                                       // "User ID: " + username + "\n");
    }
}
