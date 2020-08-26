package controller;

import Serialisation.Serialiser;
import users.doctor;

import javax.swing.*;
import java.util.ArrayList;

public class administratorController {

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
}