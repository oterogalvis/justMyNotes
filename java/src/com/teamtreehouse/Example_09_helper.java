package com.teamtreehouse;

import java.io.*;

public class Example_09_helper {
	public static void save(Example_09_package[] Example_09_helper) {
		try (
				// Create new file
				FileOutputStream fos = new FileOutputStream("Example_09_helper.ser");
				// Pass new file into object ObjectOutputStream
				ObjectOutputStream oos = new ObjectOutputStream(fos);
			) {
				// Write object method.
				oos.writeObject(Example_09_helper);
			} catch(IOException ioe) {
				System.out.println("Problem saving Example_09_helper");
				ioe.printStackTrace();
		}
	}
	public static Example_09_package[] load() {
		Example_09_package[] treets = new Example_09_package[0];
			try (
				FileInputStream fis = new FileInputStream("Example_09_helper.ser");
				ObjectInputStream ois = new ObjectInputStream(fis);
			) {
				treets = (Example_09_package[]) ois.readObject();
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