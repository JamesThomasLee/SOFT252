package controller;

import view.gui;
import users.user;

import javax.swing.*;

public class loginRegistrationController {
    public static void registerUser(String type, String forename, String surname, String gender, String address, String city,
                                        String county, String postcode, String tel, String email, String password){
        String popup = JOptionPane.showInputDialog(type);
        String username = type + "001";
        user registeredUser = new user(type, password, forename, surname, gender, address, city, county, postcode, tel, email, username);
    }
}
