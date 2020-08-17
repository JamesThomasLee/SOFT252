package Serialisation;

import users.patient;
import users.doctor;
import users.secretary;
import users.administrator;

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

    //Function used to read patient data from the appropriate file.
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

    //Function used to read doctor data from the appropriate file.
    public static Serializable readDoctorData(ArrayList<doctor> doctor) {
        try {
            FileInputStream fileIn = new FileInputStream("src/Serialisation/doctorData.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            doctor = (ArrayList) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Data loaded from: " + "src/Serialisation/doctorData.ser");
        } catch (IOException i) {
            System.out.println("File not found.");
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        return doctor;
    }

    //Function used to read secretary data from the appropriate file.
    public static Serializable readSecretaryData(ArrayList<secretary> secretary) {
        try {
            FileInputStream fileIn = new FileInputStream("src/Serialisation/secretaryData.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            secretary = (ArrayList) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Data loaded from: " + "src/Serialisation/secretaryData.ser");
        } catch (IOException i) {
            System.out.println("File not found.");
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        return secretary;
    }

    //Function used to read administrator data from the appropriate file.
    public static Serializable readAdministratorData(ArrayList<administrator> administrator) {
        try {
            FileInputStream fileIn = new FileInputStream("src/Serialisation/administratorData.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            administrator = (ArrayList) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Data loaded from: " + "src/Serialisation/administratorData.ser");
        } catch (IOException i) {
            System.out.println("File not found.");
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        return administrator;
    }

    //Writes array lists to a flat file.
    public static boolean writeObject(Serializable object, String location){
        try {
            //output location
            String outputLocation = "src/Serialisation/" + location + ".ser";

            //output location
            FileOutputStream fileOut = new FileOutputStream(outputLocation);
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
