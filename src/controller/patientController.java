package controller;

import Serialisation.Serialiser;
import users.patient;
import systemClasses.appointment;
import view.gui;

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
                if(date.equals(dateCompare)){
                    gui.getPatientAppointmentTime().setText("");
                    gui.getPatientAppointmentDoctor().setText(appointment.getDoctorID());
                    gui.getPatientAppointmentNotes().setText(appointment.getNotes());
                }
            }
        }
    }
}
