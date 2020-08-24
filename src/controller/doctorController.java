package controller;

import Serialisation.Serialiser;
import users.patient;
import view.gui;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class doctorController {

    public static void dropdown(gui gui){
        //get patient details
        ArrayList<patient> patientList = new ArrayList();
        patientList = (ArrayList<patient>) Serialiser.readPatientData(patientList);

        //adds each patient to drop down
        for (patient patient:patientList){
            gui.getPatientCombo().addItem(patient.getFirstName() + " " + patient.getSurname() + "(" + patient.getUserID() + ")");
        }
    }

}
