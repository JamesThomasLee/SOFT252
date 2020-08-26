package Serialisation;

import users.patient;
import users.doctor;
import users.secretary;
import users.administrator;
import systemClasses.appointment;

import java.io.*;
import java.util.ArrayList;

/**
 * The serialiser class is used to write array lists to a text file for storage.
 */
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

    /**
     * This function reads patient data from the patient array list.
     * @param patient - array list.
     * @return
     */
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

    /**
     * This function reads doctor data from the doctor array list.
     * @param doctor - array list.
     * @return
     */
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

    /**
     * This function reads secretary data from the secretary array list.
     * @param secretary - array list.
     * @return
     */
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

    /**
     * This function reads administrator data from the administrator array list.
     * @param administrator
     * @return
     */
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

    /**
     * This function reads appointment data from the appointment array list.
     * @param appointment
     * @return
     */
    public static Serializable readAppointmentData(ArrayList<appointment> appointment){
        try {
            FileInputStream fileIn = new FileInputStream("src/Serialisation/appointmentData.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            appointment = (ArrayList) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Data loaded from: " + "src/Serialisation/appointmentData.ser");
        } catch (IOException i) {
            System.out.println("File not found.");
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        return appointment;
    }

    /**
     * This function serialises array lists to a flat file text format.
     * @param object - the array list
     * @param location - the file name to be written to.
     * @return
     */
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
