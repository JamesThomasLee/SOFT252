package Serialisation;

import users.patient;

import java.io.*;
import java.util.ArrayList;

public class Serialiser {
    private String name;

    public Serialiser(String filename){
        name = filename;
    }

    public void setName(String filename){
        name = filename;
    }

    public String getName(){
        return name;
    }


    public static Serializable readPatientData(ArrayList<patient> patient) {
        try {
            FileInputStream fileIn = new FileInputStream("src/Serialisation/patientData.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            patient = (ArrayList) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Data loaded from: " + "src/Serialisation/patientData.ser");
        } catch (IOException i) {
            System.out.println("File not found.");
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        return patient;
    }

    public static boolean writeObject(Serializable object, String location){
        try {
            //output location
            String outputLocation = "src/Serialisation/" + location + ".ser";

            //output location
            FileOutputStream fileOut = new FileOutputStream(outputLocation, true);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(object);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in: " + "patientData.ser");
            return true;
        } catch (IOException i) {
            i.printStackTrace();
            return false;
        }
    }
}
