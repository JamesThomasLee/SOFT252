package controller;

import Serialisation.Serialiser;
import users.patient;
import users.doctor;
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

    public static void doctorLoggedIn(gui gui){
        gui.getTabs().removeAll();
        gui.getTabs().add(gui.getlogOutPanel());
        gui.getTabs().setTitleAt(0, "Log Out");
    }

    public static void logIn(String userID, String Password, gui gui){
        char type = userID.charAt(0);
        String login = "false";
        if(type == 'P'){
            ArrayList<patient> patientList = new ArrayList();
            patientList = (ArrayList<patient>) Serialiser.readPatientData(patientList);

            for (patient patient:patientList){
                if(userID.equals(patient.getUserID())) {
                    if (Password.equals(patient.getPassword())) {
                        String approved = patient.getApproved();
                        if(approved.equals("yes")){
                            patientLoggedIn(gui);
                            login = "true";
                        }else{
                            login = "not approved";
                            JFrame frame = new JFrame();
                            JOptionPane.showMessageDialog(frame, "Account not approved. Please contact an administrator.");
                        }
                    }
                }
            }
            if(login.equals("false")){
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Incorrect login credentials.");
            }
        }else if(type == 'D'){
            ArrayList<doctor> doctorList = new ArrayList();
            doctorList = (ArrayList<doctor>) Serialiser.readDoctorData(doctorList);

            for (doctor doctor:doctorList){
                if(userID.equals(doctor.getUserID())) {
                    if (Password.equals(doctor.getPassword())) {
                        doctorLoggedIn(gui);
                        login = "true";
                    }
                }
            }
            if(login == "false"){
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Incorrect login credentials.");
            }
        }
        else if(type == 'A'){

        }else if(type == 'S'){

        }
    }
}
