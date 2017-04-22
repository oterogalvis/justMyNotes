package example07.com.teamtreehouse;

import java.io.*;

public class TreetsSerializator {
	public static void save(Treet[] Example_07_helper) {
		try (
				// Create new file
				FileOutputStream fos = new FileOutputStream("example07/TreetsSerializator.ser");
				// Pass new file into object ObjectOutputStream
				ObjectOutputStream oos = new ObjectOutputStream(fos);
			) {
				// Write object method.
				oos.writeObject(Example_07_helper);
			} catch(IOException ioe) {
				System.out.println("Problem saving TreetsSerializator");
				ioe.printStackTrace();
		}
	}
	public static Treet[] load() {
		Treet[] treets = new Treet[0];
			try (
					FileInputStream fis = new FileInputStream("example07/TreetsSerializator.ser");
					ObjectInputStream ois = new ObjectInputStream(fis);
			) {
				treets = (Treet[]) ois.readObject();
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