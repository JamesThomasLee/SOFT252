package Serialisation;

import users.patient;
import users.doctor;
import users.secretary;

import javax.swing.*;
import java.util.ArrayList;
import java.io.Serializable;


public class setUpData implements Serializable{

    public static void addStartUpData(){

        /*
        //patient data
        ArrayList<patient> patients = new ArrayList<>();

        //password
        char[] password = new char[]{'P', 'a', 't', 'i', 'e', 'n', 't'};

        //create patients to insert into system
        patient p = new patient("P001", password, "James", "Lee", "99 Elford Crescent", "Plymouth", "Devon", "PL7 4BU", "Male", "yes");
        patients.add(p);
        p = new patient("P002", password, "Brooke", "Lee", "99 Elford Crescent", "Plymouth", "Devon", "PL7 4BU", "Female", "yes");
        patients.add(p);
        p = new patient("P003", password, "Milly", "Lee", "Sherford", "Plymouth", "Devon", "Sherf", "Female", "no");
        patients.add(p);

        Serialiser.writeObject(patients, "patientData");

        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "Patient Data Created");

        /*
        //Doctor Data
        ArrayList<doctor> doctors = new ArrayList<>();

        //password
        password = new char[]{'D', 'o', 'c', 't', 'o', 'r'};

        //create doctors to insert into system
        doctor d = new doctor("D001", password, "Sassy", "Sasquatch", "99 Clarence Street", "Brown Town", "Kingdom Come", "CL9 KC6");
        doctors.add(d);
        d = new doctor("D002", password, "Lezly", "Mackerel", "46 Clarence Street", "Brown Town", "Kingdom Come", "CL9 KC8");
        doctors.add(d);
        d = new doctor("D003", password, "Mike", "Nolan", "86 Clarence Street", "Brown Town", "Kingdom Come", "CL9 KC1");
        doctors.add(d);
        d = new doctor("D004", password, "Donny", "Dealer", "23 Clarence Street", "Brown Town", "Kingdom Come", "CL9 KC2");
        doctors.add(d);

        Serialiser.writeObject(doctors, "doctorData");

        JOptionPane.showMessageDialog(frame, "Doctor Data Created");

         */

        //Secretary Data
        ArrayList<secretary> secretaries = new ArrayList<>();

        //password
        char[] password = new char[]{'S', 'e', 'c', 'r', 'e', 't', 'a', 'r', 'y'};

        //create secretaries to insert into system
        secretary s = new secretary("S001", password, "Thomas", "Johnson", "17 High Street", "Strathalbyn", "SA", "5255");
        secretaries.add(s);

        Serialiser.writeObject(secretaries, "secretaryData");

        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "Secretary Data Created");

    }
}

