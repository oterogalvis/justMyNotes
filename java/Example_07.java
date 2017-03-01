import java.util.Date;

import com.teamtreehouse.Example_07_package;
import com.teamtreehouse.Example_07_helper;

class Example_07 {
	public static void main(String[] args) {
		Example_07_package treet = new Example_07_package(
			"Jorge Otero",
			"I'm becoming Gandalf",
			new Date(1421849732000L));
		System.out.printf("This is a new treet: %s %n", treet);

		Example_07_typecasting typecast = new Example_07_typecasting();

		Example_07_package treet2 = new Example_07_package(
			"Dark Phoenix",
			"I can't control it.",
			new Date());
		System.out.printf("This is a new treet: %s %n", treet2);

		System.out.println(treet.compareTo(treet2));
		System.out.println(treet2.compareTo(treet));
		System.out.println(treet2.compareTo(treet2));

		Example_07_package[] treets = {treet, treet2};

		Example_07_helper.save(treets);

		Example_07_package[] reloadedTreets = Example_07_helper.load();
		for (Example_07_package reloaded : reloadedTreets) {
			System.out.println(reloaded);
		}
	}
}