package controller;

import Serialisation.Serialiser;
import users.patient;
import users.doctor;
import users.secretary;
import users.administrator;
import view.gui;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class loginRegistrationController {
    public static void registerUser(String userType, char[] password, String firstName, String surname,
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

    public static void secretaryLoggedIn(gui gui){
        gui.getTabs().removeAll();
        gui.getTabs().add(gui.getlogOutPanel());
        gui.getTabs().setTitleAt(0, "Log Out");
    }

    public static void administratorLoggedIn(gui gui){
        gui.getTabs().removeAll();
        gui.getTabs().add(gui.getlogOutPanel());
        gui.getTabs().setTitleAt(0, "Log Out");
    }

    public static void logIn(String userID, char[] Password, gui gui){
        char type = userID.charAt(0);
        String login = "false";
        if(type == 'P'){
            ArrayList<patient> patientList = new ArrayList();
            patientList = (ArrayList<patient>) Serialiser.readPatientData(patientList);

            for (patient patient:patientList){
                if(userID.equals(patient.getUserID())) {
                    if (Arrays.equals(Password, patient.getPassword())) {
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
                    if (Arrays.equals(Password, doctor.getPassword())) {
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
            ArrayList<administrator> administratorList = new ArrayList();
            administratorList = (ArrayList<administrator>) Serialiser.readAdministratorData(administratorList);

            for (administrator administrator:administratorList){
                if(userID.equals(administrator.getUserID())) {
                    if (Arrays.equals(Password, administrator.getPassword())) {
                        administratorLoggedIn(gui);
                        login = "true";
                    }
                }
            }
            if(login.equals("false")){
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Incorrect login credentials.");
            }
        }else if(type == 'S'){
            ArrayList<secretary> secretaryList = new ArrayList();
            secretaryList = (ArrayList<secretary>) Serialiser.readSecretaryData(secretaryList);

            for (secretary secretary:secretaryList){
                if(userID.equals(secretary.getUserID())) {
                    if (Arrays.equals(Password, secretary.getPassword())) {
                            secretaryLoggedIn(gui);
                            login = "true";
                    }
                }
            }
            if(login.equals("false")){
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Incorrect login credentials.");
            }

        }
    }
}
