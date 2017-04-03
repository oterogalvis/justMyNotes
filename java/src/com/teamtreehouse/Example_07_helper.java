package com.teamtreehouse;

import java.io.*;

public class Example_07_helper {
	public static void save(Example_07_package[] Example_07_helper) {
		try (
                // Create new file
                FileOutputStream fos = new FileOutputStream("Example_07_helper.ser");
                // Pass new file into object ObjectOutputStream
                ObjectOutputStream oos = new ObjectOutputStream(fos);
			) {
				// Write object method.
				oos.writeObject(Example_07_helper);
			} catch(IOException ioe) {
				System.out.println("Problem saving Example_07_helper");
				ioe.printStackTrace();
		}
	}
	public static Example_07_package[] load() {
		Example_07_package[] treets = new Example_07_package[0];
			try (
                    FileInputStream fis = new FileInputStream("Example_07_helper.ser");
                    ObjectInputStream ois = new ObjectInputStream(fis);
			) {
				treets = (Example_07_package[]) ois.readObject();
			} catch(IOException ioe){
				System.out.println("Error reading file.");
				ioe.printStackTrace();
			} catch(ClassNotFoundException cnfe) {
				System.out.println("Error loading treets");
				cnfe.printStackTrace();
			}
		return treets;
	}
}