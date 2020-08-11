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

    public static Serializable readObject(ArrayList<patient> patient){
        Serializable loadedObject = null;
        try {
            FileInputStream fileIn = new FileInputStream(name);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            loadedObject = (Serializable) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Data loaded from: "+ name);
        } catch (IOException i) {
            System.out.println("File not found.");
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        return loadedObject;
    }

    public static boolean writeObject(Serializable object){
        try {
            FileOutputStream fileOut = new FileOutputStream("src/Serialisation/fileOut.ser", true);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(object);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in: " + "fileOut.ser");
            return true;
        } catch (IOException i) {
            i.printStackTrace();
            return false;
        }
    }
}
