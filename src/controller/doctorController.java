package controller;

import Serialisation.Serialiser;
import users.patient;
import users.doctor;
import systemClasses.appointment;
import view.gui;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This controller contains functions used by all doctor aspects of the system.
 */
public class doctorController {
    /**
     * adds patients to combo box ready for selected
     * @param gui - allowing system to call combo box
     */
    public static void dropdown(gui gui){
        //get patient details
        ArrayList<patient> patientList = new ArrayList();
        patientList = (ArrayList<patient>) Serialiser.readPatientData(patientList);

        //adds each patient to drop down
        for (patient patient:patientList){
            gui.getPatientCombo().addItem(patient.getFirstName() + " " + patient.getSurname() + "(" + patient.getUserID() + ")");
        }
    }

    /**
     * When a patient is selected from the dropdown box this function updates the JList displaying their appointments.
     * @param userID - the user ID selected
     * @param appoints - the jlist form component
     * @param gui - the gui
     */
    public static void updateAppointmentList(String userID, JList appoints, gui gui){
        //get patient ID from dropdown
        String patient = "";
        for(int i = 5; i > 1; i--){
            char ch = userID.charAt(userID.length() - i);
            patient = patient + String.valueOf(ch);
        }
        getPatientDetails(patient, gui);

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

                //get doctor info
                ArrayList<doctor> doctors = new ArrayList();
                doctors = (ArrayList<doctor>) Serialiser.readDoctorData(doctors);
                String doctorName = "";
                for (doctor doctor:doctors) {
                    if(appointment.getDoctorID().equals(doctor.getUserID())){
                        doctorName = "Dr " + doctor.getFirstName() + " " + doctor.getSurname();
                    }
                }


                appointmentslist.addElement("<html>Appointment <br/>" +
                        "Date: " + date + "<br/>Time: " + time +
                        "<br/>Doctor: " + doctorName +
                        "<br/>Appointment Notes: " + appointment.getNotes() + "</html>");
            }
        }
        appoints.setModel(appointmentslist);
    }

    /**
     * When a patient is selected, their details are displayed in the text components to the left of the form.
     * @param userID - userID of selected patient
     * @param gui - the gui
     */
    public static void getPatientDetails(String userID, gui gui){
        ArrayList<patient> patientList = new ArrayList();
        patientList = (ArrayList<patient>) Serialiser.readPatientData(patientList);

        for (patient patient:patientList) {
            if (userID.equals(patient.getUserID())) {
                gui.getPtFirstName().setText(patient.getFirstName());
                gui.getPtSurname().setText(patient.getSurname());
                gui.getPtGender().setText(patient.getGender());
                gui.getPtAddress().setText(patient.getAddress());
                gui.getPtCity().setText(patient.getCounty());
                gui.getPtCounty().setText(patient.getCounty());
                gui.getPtPostcode().setText(patient.getPostcode());
            }
        }
    }

}
