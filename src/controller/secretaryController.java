package controller;

import Serialisation.Serialiser;
import controller.userList;
import users.patient;
import view.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView;
import java.util.ArrayList;

public class secretaryController {

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
}
