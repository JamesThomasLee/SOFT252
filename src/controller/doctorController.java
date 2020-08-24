package controller;

import Serialisation.Serialiser;
import users.patient;
import systemClasses.appointment;
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

    //displays patient appointments when a patient is selected.
    public static void updateAppointmentList(String userID, JList appoints){
        //get patient ID from dropdown
        String patient = "";
        for(int i = 5; i > 1; i--){
            char ch = userID.charAt(userID.length() - i);
            patient = patient + String.valueOf(ch);
        }

        //create list and model
        DefaultListModel appointmentslist = new DefaultListModel();
        JList list = appoints;

        //get patient data
        ArrayList<appointment> appointmentList = new ArrayList();
        appointmentList = (ArrayList<appointment>) Serialiser.readAppointmentData(appointmentList);

        for(appointment appointment:appointmentList){
            if(appointment.getPatientID().equals(patient)){
                String date = "";
                for(char c:appointment.getDate()){
                    date = date + c;
                };
                String time = "";
                for(char c:appointment.getTime()){
                    time = time + c;
                };

            appointmentslist.addElement("<html>Appointment <br/>" +
                        "Date: " + date + "<br/>Time: " + time +
                        "<br/>Appointment Notes: " + appointment.getNotes() + "</html>");
            }
        }
        appoints.setModel(appointmentslist);
    }

}
