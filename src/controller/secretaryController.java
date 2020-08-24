package controller;

import Serialisation.Serialiser;
import users.patient;
import view.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView;
import java.util.ArrayList;

public class secretaryController {

    /*
    This function is used to display all patients to a secretary.
    A JList is used to display all patients.
     */
    public static void displayPatients(JList users){
        //create list and model
        DefaultListModel patients = new DefaultListModel();
        JList list = users;

        //get patient data
        ArrayList<patient> patientList = new ArrayList();
        patientList = (ArrayList<patient>) Serialiser.readPatientData(patientList);

        //loop patients into data model
        for (patient patient:patientList){
            patients.addElement("Patient ID: " + patient.getUserID() + "          Forename: " + patient.getFirstName() +
                                "          Surname: " + patient.getSurname() + "          Postcode: " + patient.getPostcode()
                                 + "          Approved: " + patient.getApproved());
        }

        //assign data model to list
        users.setModel(patients);
    }

    public static void authorisePatient(String userID){
        JFrame frame = new JFrame();
        //get patient data
        ArrayList<patient> patientList = new ArrayList();
        patientList = (ArrayList<patient>) Serialiser.readPatientData(patientList);

        String message = "Patient does not exist.";
        //loop patients into data model
        for (patient patient:patientList){
            if(patient.getUserID().equals(userID)){
                if(patient.getApproved().equals("No")){
                    //authorise
                    patient.setApproved("Yes");

                    //write new list to file
                    Serialiser.writeObject(patientList, "patientData");

                    //display confirmation message
                    message = "Patient authorised.";

                    //refresh patient display list
                    displayPatients(gui.getGui().getSecAccManagement());
                    break;
                }else if(patient.getApproved().equals("Yes")){
                    message = "Patient already authorised.";
                    break;
                }
            }
        }
        JOptionPane.showMessageDialog(frame, message);
    }

    public static void deletePatient(String userID){
        JFrame frame = new JFrame();
        //get patient data
        ArrayList<patient> patientList = new ArrayList();
        patientList = (ArrayList<patient>) Serialiser.readPatientData(patientList);

        String message = "Patient does not exist.";
        //loop patients into data model
        for (patient patient:patientList) {
            if (patient.getUserID().equals(userID)) {
                int index = patientList.indexOf(patient);
                int confirm = JOptionPane.YES_NO_OPTION;
                int outcome = JOptionPane.showConfirmDialog(null,
                        "Are you sure you would like to delete patient " + userID + "?", "Are you sure?", confirm);
                if (outcome == JOptionPane.YES_OPTION) {
                    patientList.remove(index);

                    //write new list to file
                    Serialiser.writeObject(patientList, "patientData");

                    //refresh patient display list
                    displayPatients(gui.getGui().getSecAccManagement());
                    message = "Patient account deleted.";
                    break;
                }
            }
        }
        JOptionPane.showMessageDialog(frame, message);
    }
/*
    public static void displayPatientDetails(gui gui, object object){

    }
 */
}
