package Serialisation;

import users.patient;
import users.doctor;
import users.secretary;
import users.administrator;
import systemClasses.appointment;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.Date;


public class setUpData implements Serializable{

    public static void addStartUpData(){


        //patient data
        ArrayList<patient> patients = new ArrayList<>();

        //password
        char[] password = new char[]{'P', 'a', 't', 'i', 'e', 'n', 't'};

        //create patients to insert into system
        patient p = new patient("P001", password, "James", "Lee", "99 Elford Crescent", "Plymouth", "Devon", "PL7 4BU", "Male", "Yes");
        patients.add(p);
        p = new patient("P002", password, "Brooke", "Lee", "99 Elford Crescent", "Plymouth", "Devon", "PL7 4BU", "Female", "Yes");
        patients.add(p);
        p = new patient("P003", password, "Milly", "Lee", "Sherford", "Plymouth", "Devon", "Sherf", "Female", "No");
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


        //Administrator Data
        ArrayList<administrator> administrators = new ArrayList<>();

        //password
        password = new char[]{'A', 'd', 'm', 'i', 'n', 'i', 's', 't', 'r', 'a', 't', 'o', 'r'};

        //create administrators to insert into system
        administrator a = new administrator("A001", password, "Denny", "Keller", "27 High Street", "Strathalbyn", "SA", "5255");
        administrators.add(a);

        Serialiser.writeObject(administrators, "administratorData");

        //JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "Administrator Data Created");
        */

        //Appointment data
        ArrayList<appointment> appointments = new ArrayList<>();

        //create appointment
        char[] date = new char[]{'0', '1', '/', '0', '8', '/', '2', '0', '2', '0'};
        char[] time = new char[]{'0', '9', ':', '0', '0'};
        appointment a = new appointment("P001", "D001", date, time, "Yes", "Patient reported regular headaches." +
                "Is going to report lifestyle choices over period of 14 days to identify triggers.");
        appointments.add(a);
        date = new char[]{'0', '7', '/', '0', '8', '/', '2', '0', '2', '0'};
        time = new char[]{'0', '9', ':', '0', '0'};
        a = new appointment("P001", "D001", date, time, "Yes", "Patient identified migraines occuring" +
                "after strenuous exercise. Referred for a scan. Will report back for results.");
        appointments.add(a);
        date = new char[]{'1', '4', '/', '0', '8', '/', '2', '0', '2', '0'};
        time = new char[]{'0', '9', ':', '0', '0'};
        a = new appointment("P001", "D001", date, time, "Yes", "Scan reveals minor split in spine" +
                "potentially cause migraines after exercise. Referred for physio therapy.");
        appointments.add(a);
        //create appointment
        date = new char[]{'0', '1', '/', '0', '8', '/', '2', '0', '2', '0'};
        time = new char[]{'0', '9', ':', '3', '0'};
        a = new appointment("P002", "D001", date, time, "Yes", "Patient reported cold like symptoms for a" +
                "period of over 2 weeks.");
        appointments.add(a);
        date = new char[]{'0', '7', '/', '0', '8', '/', '2', '0', '2', '0'};
        time = new char[]{'0', '9', ':', '3', '0'};
        a = new appointment("P002", "D001", date, time, "Yes", "Patient reported that medication had not" +
                "help relieve symptoms");
        appointments.add(a);
        date = new char[]{'1', '4', '/', '0', '8', '/', '2', '0', '2', '0'};
        time = new char[]{'1', '3', ':', '0', '0'};
        a = new appointment("P002", "D001", date, time, "Yes", "Test results determine patient" +
                "is carrying a virus.");
        appointments.add(a);
        //create appointment
        date = new char[]{'0', '1', '/', '0', '8', '/', '2', '0', '2', '0'};
        time = new char[]{'1', '1', ':', '3', '0'};
        a = new appointment("P003", "D003", date, time, "Yes", "Patient states they cannot sleep" +
                "regularly.");
        appointments.add(a);
        date = new char[]{'0', '7', '/', '0', '8', '/', '2', '0', '2', '0'};
        time = new char[]{'1', '4', ':', '3', '0'};
        a = new appointment("P003", "D003", date, time, "Yes", "Sleeping medication helped but didn't" +
                "mitigate the problem.");
        appointments.add(a);
        date = new char[]{'1', '4', '/', '0', '8', '/', '2', '0', '2', '0'};
        time = new char[]{'1', '5', ':', '0', '0'};
        a = new appointment("P003", "D003", date, time, "Yes", "Diagnosed with tinnitus and referred" +
                "to a specialist.");
        appointments.add(a);

        //JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "Appointment Data Created");
    }
}

