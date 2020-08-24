package systemClasses;

import java.text.SimpleDateFormat;
import java.util.Date;

public class appointment {
    protected String patientID;
    protected String doctorID;
    protected char[] date;
    protected char[] time;
    protected String authorised;
    protected String notes;

    public appointment(String patientID, String doctorID, char[] date, char[] time, String authorised, String notes) {
        this.patientID = patientID;
        this.doctorID = doctorID;
        this.date = date;
        this.time = time;
        this.authorised = authorised;
        this.notes = notes;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public char[] getDate() {
        return date;
    }

    public void setDate(char[] date) {
        this.date = date;
    }

    public char[] getTime() {
        return time;
    }

    public void setTime(char[] time) {
        this.time = time;
    }

    public String getAuthorised() {
        return authorised;
    }

    public void setAuthorised(String authorised) {
        this.authorised = authorised;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
