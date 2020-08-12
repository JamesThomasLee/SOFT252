package controller;

import Serialisation.Serialiser;
import users.patient;
import view.gui;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class loginRegistrationController {
    public static void registerUser(String userType, String password, String firstName, String surname,
                                    String address, String city, String county, String postcode, String gender){


        //setUpData.addStartUpData();

        /*
        //read data
        ArrayList<patient> patientList = new ArrayList();
        patientList = (ArrayList<patient>) Serialiser.readPatientData(patientList);
        */

        //generate user ID

        //register user

        //display userID
    }

    //change state of tabs to only display log in and register tabs
    public static void loadInitialTabs(gui gui){
        gui.getTabs().removeAll();
        gui.getTabs().add(gui.getSignInPanel());
        gui.getTabs().add(gui.getRegisterPanel());
    }

    public static void patientLoggedIn(gui gui){
        gui.getTabs().removeAll();
        gui.getTabs().add(gui.getLoggedInPanel());
    }

    public static void logIn(String userID, String Password, gui gui){
        char type = userID.charAt(0);
        if(type == 'P'){
            ArrayList<patient> patientList = new ArrayList();
            patientList = (ArrayList<patient>) Serialiser.readPatientData(patientList);

            for (patient patient:patientList){
                if(userID.equals(patient.getUserID())) {
                    if (Password.equals(patient.getPassword())) {
                        patientLoggedIn(gui);
                    }
                }
            }
        }else if(type == 'D'){

        }
        else if(type == 'A'){

        }else if(type == 'S'){

        }
    }
}
