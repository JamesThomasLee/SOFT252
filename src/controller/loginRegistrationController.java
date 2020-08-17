package controller;

import Serialisation.Serialiser;
import users.patient;
import users.doctor;
import users.secretary;
import users.administrator;
import view.gui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

public class loginRegistrationController {

    //Generating a unique ID for a registering user.
    public static String createPatientID(ArrayList<patient> patients){
        patient lastPatient = patients.get(patients.size()-1);
        String lastID = lastPatient.getUserID();
        char firstDigit = lastID.charAt(1);
        char secondDigit = lastID.charAt(2);
        char thirdDigit = lastID.charAt(3);
        int newThirdDigit = Character.getNumericValue(thirdDigit) + '1';
        thirdDigit = (char)newThirdDigit;
        String newID =  "P" + firstDigit + secondDigit + thirdDigit;
        return newID;
    }

    // The function used to register a new user.
    public static Serializable registerUser(gui gui, String userType, char[] password, String firstName, String surname,
                                      String address, String city, String county, String postcode, String gender){
        if(userType.equals("Patient")){
            //get array list
            ArrayList<patient> patientList = new ArrayList();
            patientList = (ArrayList<patient>) Serialiser.readPatientData(patientList);

            //generate new user ID
            String userID = createPatientID(patientList);

            //create new user
            patient p = new patient(userID, password, firstName, surname, address, city, county, postcode, gender, "no");
            //add to array list
            patientList.add(p);
            //reserialize
            Serialiser.writeObject(patientList, "patientData");

            //user output
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "New User Account Created \n" + "User ID: " + userID + "\n" + "Please use your credentials to sign in.");

            //
            String complete = "complete";
            return complete;

        }else if(userType.equals("Administrator")){
            //get array list

            //create new user

            //add to array list

            //reserialize
        }
        return userType;
    }

    //change state of tabs to only display log in and register tabs
    public static void loadInitialTabs(gui gui){
        gui.getTabs().removeAll();
        gui.getTabs().add(gui.getSignInPanel());
        gui.getTabs().setTitleAt(0, "Sign In");
        gui.getTabs().add(gui.getRegisterPanel());
        gui.getTabs().setTitleAt(1, "Register");
    }

    /*
    Function that retrieves log in credentials and does a user check. If credentials are correct then the appropriate
    user login function is called.
     */
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

    /*
    The function called if a user provides patient login details.
    This function will change the appropriate tabs state to display them to the user.
     */
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

    /*
    The function called if a user provides doctor login details.
    This function will change the appropriate tabs state to display them to the user.
    */
    public static void doctorLoggedIn(gui gui){
        gui.getTabs().removeAll();
        gui.getTabs().add(gui.getlogOutPanel());
        gui.getTabs().setTitleAt(0, "Log Out");
    }

    /*
    The function called if a user provides secretary login details.
    This function will change the appropriate tabs state to display them to the user.
    */
    public static void secretaryLoggedIn(gui gui){
        gui.getTabs().removeAll();
        gui.getTabs().add(gui.getAccountManagementPanel());
        gui.getTabs().add(gui.getlogOutPanel());
        gui.getTabs().setTitleAt(0, "Patient Account Management");
        gui.getTabs().setTitleAt(1, "Log Out");

        secretaryController.displayPatients(gui.getSecAccManagement());

    }

    /*
    The function called if a user provides administrator login details.
    This function will change the appropriate tabs state to display them to the user.
    */
    public static void administratorLoggedIn(gui gui){
        gui.getTabs().removeAll();
        gui.getTabs().add(gui.getlogOutPanel());
        gui.getTabs().setTitleAt(0, "Log Out");
    }

}
