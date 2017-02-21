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
			oos.writeObject("Example_07_helper");
			} catch(IOException ioe) {
				System.out.println("Problem saving Treets");
				ioe.printStackTrace();
			}
		}
	}
}