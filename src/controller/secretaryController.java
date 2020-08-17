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
                                "          Surname: " + patient.getSurname() + "          Postcode: " + patient.getPostcode());
        }

        //assign data model to list
        users.setModel(patients);

    }
/*
    public static void displayPatientDetails(gui gui, object object){

    }
 */
}
