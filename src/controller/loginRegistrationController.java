package controller;

import Serialisation.Serialiser;
import users.patient;
import Serialisation.setUpData;

import javax.swing.*;
import java.util.ArrayList;

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

    public static void logIn(String userID, String Password){
        char type = userID.charAt(0);
        if(type == 'P'){
            ArrayList<patient> patientList = new ArrayList();
            patientList = (ArrayList<patient>) Serialiser.readPatientData(patientList);



            for (patient patient:patientList){
                if(userID.equals(patient.getUserID())) {
                    if (Password.equals(patient.getPassword())) {
                        //Successful login
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
