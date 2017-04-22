package example07;

import java.util.Date;

import example07.com.teamtreehouse.Treet;
import example07.com.teamtreehouse.TreetsSerializator;

class Main {
	public static void main(String[] args) {
		Treet treet = new Treet(
			"Jorge Otero",
			"I'm becoming Gandalf",
			new Date(1421849732000L));
		System.out.printf("This is a new treet: %s %n", treet);

		LearningTypeCasting typecast = new LearningTypeCasting();

		Treet treet2 = new Treet(
			"Dark Phoenix",
			"I can't control it.",
			new Date());
		System.out.printf("This is a new treet: %s %n", treet2);

		System.out.println(treet.compareTo(treet2));
		System.out.println(treet2.compareTo(treet));
		System.out.println(treet2.compareTo(treet2));

		Treet[] treets = {treet, treet2};

		TreetsSerializator.save(treets);

		Treet[] reloadedTreets = TreetsSerializator.load();
		for (Treet reloaded : reloadedTreets) {
			System.out.println(reloaded);
		}
	}
}