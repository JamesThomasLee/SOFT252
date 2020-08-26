package controller;

import Serialisation.Serialiser;
import users.doctor;
import systemClasses.appointment;
import view.gui;

import java.awt.*;
import java.util.ArrayList;

/**
 * A controller to control all patient aspects.
 */
public class patientController {

    /**
     * Fills combo box with a patients appointments
     *
     * @param gui    - gui
     * @param userID - logged in patients user ID.
     */
    public static void dropdown(gui gui, String userID) {
        //get appointment details
        ArrayList<appointment> appointmentList = new ArrayList();
        appointmentList = (ArrayList<appointment>) Serialiser.readAppointmentData(appointmentList);

        gui.getPatientID().setText(userID);

        //adds each patient to drop down
        for (appointment appointment : appointmentList) {
            if (userID.equals(appointment.getPatientID())) {
                String date = "";
                for (char c : appointment.getDate()) {
                    date = date + c;
                }
                ;
                gui.getPatientAppointments().addItem(date);
            }
        }
    }

    /**
     * Gets the selected index from the drop down box and populates the form fields with appointment data.
     * @param gui - gui
     * @param index - dropdown selected index
     */
    public static void appointmentDetails(gui gui, int index) {
        //get appointment details
        ArrayList<appointment> appointmentList = new ArrayList();
        appointmentList = (ArrayList<appointment>) Serialiser.readAppointmentData(appointmentList);

        String date = (String) gui.getPatientAppointments().getSelectedItem();
        String userID = gui.getPatientID().getText();

        for (appointment appointment : appointmentList) {
            if (userID.equals(appointment.getPatientID())) {
                String dateCompare = "";
                for (char c : appointment.getDate()) {
                    dateCompare = dateCompare + c;
                }
                String time = "";
                for(char c:appointment.getTime()){
                    time = time + c;
                };
                if(date.equals(dateCompare)){
                    gui.getPatientAppointmentTime().setText(time);
                    gui.getPatientAppointmentTime().setDisabledTextColor(Color.darkGray);
                    String doctor = getDoctor(appointment.getDoctorID());
                    gui.getPatientAppointmentDoctor().setText(doctor);
                    gui.getPatientAppointmentDoctor().setDisabledTextColor(Color.darkGray);
                    gui.getPatientAppointmentNotes().setText(appointment.getNotes());
                    gui.getPatientAppointmentNotes().setDisabledTextColor(Color.darkGray);
                }
            }
        }
    }

    /**
     * A function used to return a doctors name from their ID.
     * @param doctorID - doctor ID returned from appointment.
     * @return
     */
    public static String getDoctor(String doctorID){
        ArrayList<doctor> doctorList = new ArrayList();
        doctorList = (ArrayList<doctor>) Serialiser.readDoctorData(doctorList);

        String doctorName = "";
        for (doctor doctor:doctorList) {
            if (doctorID.equals(doctor.getUserID())) {
                doctorName = "Dr " + doctor.getFirstName() + " " + doctor.getSurname();
            }
        }
        return doctorName;
    }
}
