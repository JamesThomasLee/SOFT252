package controller;

import Serialisation.Serialiser;
import users.administrator;
import users.doctor;
import users.patient;
import view.gui;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * A controller to hold all functions relating to the administrator aspect of the system.
 */
public class administratorController {

    /**
     * a function to display all registered doctor accounts to the administrator
     * @param doctors - jlist
     */
    public static void displayDoctors(JList doctors){
        //create list and model
        DefaultListModel doctorModel = new DefaultListModel();
        JList list = doctors;

        //get doctor data
        ArrayList<doctor> doctorList = new ArrayList();
        doctorList = (ArrayList<doctor>) Serialiser.readDoctorData(doctorList);

        //loop doctors into data model
        for (doctor doctor:doctorList){
            doctorModel.addElement("<html>Dr " + doctor.getFirstName() + " " + doctor.getSurname()
                                    + "<br/>Doctor ID: " + doctor.getUserID() + "</html>");
        }

        //assign data model to list
        doctors.setModel(doctorModel);
    }

    /**
     * A function to delete a registered doctor account.
     * @param doctorID - doctor ID to be deleted.
     * @param gui - gui.
     */
    public static void deleteDoctor(String doctorID, gui gui){
        JFrame frame = new JFrame();

        //get doctor data
        ArrayList<doctor> doctorList = new ArrayList();
        doctorList = (ArrayList<doctor>) Serialiser.readDoctorData(doctorList);

        String message = "Doctor does not exist.";
        //loop patients into data model
        for (doctor doctor:doctorList) {
            if (doctor.getUserID().equals(doctorID)) {
                int index = doctorList.indexOf(doctor);
                int confirm = JOptionPane.YES_NO_OPTION;
                int outcome = JOptionPane.showConfirmDialog(null,
                        "Are you sure you would like to delete doctor " + doctorID + "?", "Are you sure?", confirm);
                if (outcome == JOptionPane.YES_OPTION) {
                    doctorList.remove(index);

                    //write new list to file
                    Serialiser.writeObject(doctorList, "doctorData");

                    //refresh patient display list
                    displayDoctors(gui.getGui().getDoctorAccounts());
                    message = "Doctor account deleted.";
                    break;
                }
            }
        }
        JOptionPane.showMessageDialog(frame, message);
    }

    /**
     * A function that takes input from the action listener (doctors details) and registers them with an account.
     * @param gui
     * @param password
     * @param firstName
     * @param surname
     * @param address
     * @param city
     * @param county
     * @param postcode
     * @return - return "complete" so action listener can clear text inputs.
     */
    public static Serializable registerDoctor(gui gui, char[] password, String firstName, String surname,
                                              String address, String city, String county, String postcode){
        //get array list
        ArrayList<doctor> doctorList = new ArrayList();
        doctorList = (ArrayList<doctor>) Serialiser.readDoctorData(doctorList);

        //generate new user ID
        String doctorID = createDoctorID(doctorList);

        //create new user
        doctor d = new doctor(doctorID, password, firstName, surname, address, city, county, postcode);
        //add to array list
        doctorList.add(d);
        //reserialize
        Serialiser.writeObject(doctorList, "doctorData");

        String complete = "complete";
        return complete;
    }

    /**
     * A function to create a unique doctor ID.
     * @param doctors - arraylist of all registered doctors.
     * @return
     */
    public static String createDoctorID(ArrayList<doctor> doctors){
        doctor lastDoctor = doctors.get(doctors.size()-1);
        String lastID = lastDoctor.getUserID();
        char firstDigit = lastID.charAt(1);
        char secondDigit = lastID.charAt(2);
        char thirdDigit = lastID.charAt(3);
        int newThirdDigit = Character.getNumericValue(thirdDigit) + '1';
        thirdDigit = (char)newThirdDigit;
        String newID =  "A" + firstDigit + secondDigit + thirdDigit;
        return newID;
    }
}