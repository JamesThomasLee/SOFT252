package controller;

import view.gui;
import users.user;
import Serialisation.Serialiser;

import javax.swing.*;

public class loginRegistrationController {
    public static void registerUser(String type, String forename, String surname, String gender, String address, String city,
                                        String county, String postcode, String tel, String email, String password){

        String usernum = "001";
        String username = type + usernum;

        user registeredUser = new user(type, password, forename, surname, gender, address, city, county, postcode, tel, email, username);
        Serialiser.writeObject(registeredUser);

        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "User Registered\n" +
                                                        "User ID: " + username + "\n");
    }
}
