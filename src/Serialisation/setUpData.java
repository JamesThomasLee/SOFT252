package Serialisation;

import users.patient;

import javax.swing.*;
import java.util.ArrayList;
import java.io.Serializable;


public class setUpData implements Serializable{

    public static void addStartUpData(){
        ArrayList<patient> patients = new ArrayList<>();

        //create patients to insert into system
        patient p = new patient("P", "001", "Password1", "James", "Lee", "99 Elford Crescent", "Plymouth", "Devon", "PL7 4BU", "Male");
        patients.add(p);
        p = new patient("P", "002", "Password2", "Brooke", "Lee", "99 Elford Crescent", "Plymouth", "Devon", "PL7 4BU", "Female");
        patients.add(p);
        p = new patient("P", "003", "Password3", "Milly", "Lee", "Sherford", "Plymouth", "Devon", "Sherf", "Female");
        patients.add(p);

        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "Test");

        Serialiser.writeObject(patients);
    }
}

