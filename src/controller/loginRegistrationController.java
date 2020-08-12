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
        gui.getTabs().setTitleAt(0, "Sign In");
        gui.getTabs().add(gui.getRegisterPanel());
        gui.getTabs().setTitleAt(1, "Register");
    }

    public static void patientLoggedIn(gui gui){
        gui.getTabs().removeAll();
        gui.getTabs().add(gui.getAppointmentsPanel());
        gui.getTabs().setTitleAt(0, "Appointments");
        gui.getTabs().add(gui.getMedicalhistoryPanel());
        gui.getTabs().setTitleAt(1, "Medical History and Prescriptions");
        gui.getTabs().add(gui.getDoctorsPanel());
        gui.getTabs().setTitleAt(2, "Doctors");
        gui.getTabs().add(gui.getlogOutPanel());
        gui.getTabs().setTitleAt(3, "Log Out");
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
