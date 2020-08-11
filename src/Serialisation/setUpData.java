package Serialisation;

import users.patient;
import java.util.ArrayList;
import java.io.Serializable;


public class setUpData implements Serializable{

    public void addStartUpData(){
        //set up ArrayLists
        ArrayList<patient> patients = new ArrayList<>();

        //create patients to insert into system
        patient p = new patient("P", "password1", "James", "Lee", "Male", "99 Elford Crescent", "Plymouth", "Devon", "PL7 4BU", "07366593516", "jamesthomaslee@virginmedia.com", "P001");
        patients.add(p);
        p = new patient("P", "password2", "Brooke", "Lee", "Male", "99 Elford Crescent", "Plymouth", "Devon", "PL7 4BU", "07366593516", "jamesthomaslee@virginmedia.com", "P002");
        patients.add(p);
        p = new patient("P", "password3", "Milly", "Lee", "Male", "99 Elford Crescent", "Plymouth", "Devon", "PL7 4BU", "07366593516", "jamesthomaslee@virginmedia.com", "P003");
        patients.add(p);
    }
}

