package controller;

import Serialisation.Serialiser;
import users.doctor;
import users.patient;
import view.gui;

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
}