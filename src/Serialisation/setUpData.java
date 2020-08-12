package Serialisation;

import users.patient;
import users.doctor;

import javax.swing.*;
import java.util.ArrayList;
import java.io.Serializable;


public class setUpData implements Serializable{

    public static void addStartUpData(){

        //patient data
        ArrayList<patient> patients = new ArrayList<>();

        //create patients to insert into system
        patient p = new patient("P001", "Password1", "James", "Lee", "99 Elford Crescent", "Plymouth", "Devon", "PL7 4BU", "Male");
        patients.add(p);
        p = new patient("P002", "Password2", "Brooke", "Lee", "99 Elford Crescent", "Plymouth", "Devon", "PL7 4BU", "Female");
        patients.add(p);
        p = new patient("P003", "Password3", "Milly", "Lee", "Sherford", "Plymouth", "Devon", "Sherf", "Female");
        patients.add(p);

        Serialiser.writeObject(patients, "patientData");

        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "Patient Data Created");


        //Doctor Data
        ArrayList<doctor> doctors = new ArrayList<>();

        //create patients to insert into system
        doctor d = new doctor("D001", "Password1", "Sassy", "Sasquatch", "99 Clarence Street", "Brown Town", "Kingdom Come", "CL9 KC6");
        doctors.add(d);
        d = new doctor("D002", "Password2", "Lezly", "Mackerel", "46 Clarence Street", "Brown Town", "Kingdom Come", "CL9 KC8");
        doctors.add(d);
        d = new doctor("D003", "Password3", "Mike", "Nolan", "86 Clarence Street", "Brown Town", "Kingdom Come", "CL9 KC1");
        doctors.add(d);
        d = new doctor("D004", "Password4", "Donny", "Dealer", "23 Clarence Street", "Brown Town", "Kingdom Come", "CL9 KC2");
        doctors.add(d);

        Serialiser.writeObject(doctors, "doctorData");

        JOptionPane.showMessageDialog(frame, "Doctor Data Created");
    }
}

