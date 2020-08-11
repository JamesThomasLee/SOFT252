package Serialisation;

import java.io.Serializable;
import java.util.ArrayList;

import users.patient;

public class data implements Serializable {
    public ArrayList<patient> patient = new ArrayList();

    public data(ArrayList<users.patient> patient) {
        this.patient = patient;
    }

    public ArrayList<users.patient> getPatient() {
        return patient;
    }

    public void setPatient(ArrayList<users.patient> patient) {
        this.patient = patient;
    }
}
