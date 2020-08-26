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

/**
 * This controller controls all aspects of a user logging into a system and registering a new account.
 */
public class loginRegistrationController {

    /**
     * This function is used when a new patient is registering.
     * It generates a new unique ID that will be assigned to them.
     * @param patients - arraylist of all patients
     * @return
     */
    public static String createPatientID(ArrayList<patient> patients) {
        patient lastPatient = patients.get(patients.size() - 1);
        String lastID = lastPatient.getUserID();
        char firstDigit = lastID.charAt(1);
        char secondDigit = lastID.charAt(2);
        char thirdDigit = lastID.charAt(3);
        int newThirdDigit = Character.getNumericValue(thirdDigit) + '1';
        thirdDigit = (char) newThirdDigit;
        String newID = "P" + firstDigit + secondDigit + thirdDigit;
        return newID;
    }

    /**
     * Used when an administrator is registering a new account.
     * A unique ID is generated for the new administrator.
     * @param administrators
     * @return
     */
    public static String createAdminID(ArrayList<administrator> administrators){
        administrator lastAdministrator = administrators.get(administrators.size()-1);
        String lastID = lastAdministrator.getUserID();
        char firstDigit = lastID.charAt(1);
        char secondDigit = lastID.charAt(2);
        char thirdDigit = lastID.charAt(3);
        int newThirdDigit = Character.getNumericValue(thirdDigit) + '1';
        thirdDigit = (char)newThirdDigit;
        String newID =  "A" + firstDigit + secondDigit + thirdDigit;
        return newID;
    }

    /**
     * This function gathers user inputs and registers a new account.
     * If statements are used to determine the user type.
     * The new account is then serialized in the appropriate file.
     * @param gui - gui
     * @param userType - collected user details
     * @param password - collected user details
     * @param firstName - collected user details
     * @param surname - collected user details
     * @param address - collected user details
     * @param city - collected user details
     * @param county - collected user details
     * @param postcode - collected user details
     * @param gender - collected user details
     * @return
     */
    public static Serializable registerUser(gui gui, String userType, char[] password, String firstName, String surname,
                                      String address, String city, String county, String postcode, String gender){
        if(userType.equals("Patient")){
            //get array list
            ArrayList<patient> patientList = new ArrayList();
            patientList = (ArrayList<patient>) Serialiser.readPatientData(patientList);

            //generate new user ID
            String userID = createPatientID(patientList);

            //create new user
            patient p = new patient(userID, password, firstName, surname, address, city, county, postcode, gender, "No");
            //add to array list
            patientList.add(p);
            //reserialize
            Serialiser.writeObject(patientList, "patientData");

            //user output
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "New User Account Created \n" + "User ID: " + userID + "\n" +
                                            "Please use your credentials to sign in. \n" + "Account approval may be necessary.");

            //
            String complete = "complete";
            return complete;

        }else if(userType.equals("Administrator")){
            //get array list
            ArrayList<administrator> adminstratorList = new ArrayList();
            adminstratorList = (ArrayList<administrator>) Serialiser.readAdministratorData(adminstratorList);

            //generate new user ID
            String userID = createAdminID(adminstratorList);

            //create new user
            administrator a = new administrator(userID, password, firstName, surname, address, city, county, postcode);
            //add to array list
            adminstratorList.add(a);
            //reserialize
            Serialiser.writeObject(adminstratorList, "administratorData");

            //user output
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "New User Account Created \n" + "User ID: " + userID + "\n" + "Please use your credentials to sign in.");

            //
            String complete = "complete";
            return complete;
        }
        String complete = "incomplete";
        return complete;
    }

    /**
     * Loads initial sign in and register tabs.
     * @param gui
     */
    public static void loadInitialTabs(gui gui){
        gui.getTabs().removeAll();
        gui.getTabs().add(gui.getSignInPanel());
        gui.getTabs().setTitleAt(0, "Sign In");
        gui.getTabs().add(gui.getRegisterPanel());
        gui.getTabs().setTitleAt(1, "Register");
    }

    /**
     * This function collects user log in credentials and then attempts a log in.
     * If statements are used to determine the user type when trying to log in.
     * @param userID - user log in credentials
     * @param Password - user password
     * @param gui - gui
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
                        if(approved.equals("Yes")){
                            patientLoggedIn(gui, userID);
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

        }else{
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Incorrect login credentials.");
        }
    }

    /**
     * When a patient successfully logs in, this function is used to display the relevant tabs on the gui.
     * @param gui - gui
     */
    public static void patientLoggedIn(gui gui, String userID){
        gui.getTabs().removeAll();
        gui.getTabs().add(gui.getMedicalhistoryPanel());
        gui.getTabs().setTitleAt(0, "Medical History and Prescriptions");
        patientController.dropdown(gui, userID);
        gui.getTabs().add(gui.getDoctorsPanel());
        gui.getTabs().setTitleAt(1, "Doctors");
        gui.getTabs().add(gui.getlogOutPanel());
        gui.getTabs().setTitleAt(2, "Log Out");
    }

    /**
     * When a doctor successfully logs in, this function is used to display the relevant tabs on the gui.
     * @param gui - gui
     */
    public static void doctorLoggedIn(gui gui){
        gui.getTabs().removeAll();
        gui.getTabs().add(gui.getPatientsPanel());
        gui.getTabs().setTitleAt(0, "Patients");
        doctorController.dropdown(gui);
        gui.getTabs().add(gui.getlogOutPanel());
        gui.getTabs().setTitleAt(1, "Log Out");
    }

    /**
     * When a secretary successfully logs in, this function is used to display the relevant tabs on the gui.
     * @param gui - gui
     */
    public static void secretaryLoggedIn(gui gui){
        gui.getTabs().removeAll();
        gui.getTabs().add(gui.getAccountManagementPanel());
        gui.getTabs().add(gui.getlogOutPanel());
        gui.getTabs().setTitleAt(0, "Patient Account Management");
        gui.getTabs().setTitleAt(1, "Log Out");

        secretaryController.displayPatients(gui.getSecAccManagement());

    }

    /**
     * When an administrator successfully logs in, this function is used to display the relevant tabs on the gui.
     * @param gui - gui
     */
    public static void administratorLoggedIn(gui gui){
        gui.getTabs().removeAll();
        gui.getTabs().add(gui.getDoctorAccManage());
        gui.getTabs().setTitleAt(0, "Doctor Account Management");
        administratorController.displayDoctors(gui.getDoctorAccounts());
        gui.getTabs().add(gui.getlogOutPanel());
        gui.getTabs().setTitleAt(1, "Log Out");
    }

}
