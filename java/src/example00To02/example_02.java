package example00To02;

import java.io.Console;

public class example_02 {
	public static void main(String[] args){
		Console console = System.console();
		String ageString = console.readLine("Enter your age: ");
		int age = Integer.parseInt(ageString);
		if (age < 13) {
			console.printf("Get out of here you nob\n");
			System.exit(0);
		}
		String name = console.readLine("Enter your name: ");
		String adjective;
		boolean invalidWord;

		do {
			adjective = console.readLine("Enter an adjective: ");
			invalidWord = (adjective.equalsIgnoreCase("dork") || adjective.equalsIgnoreCase("jerk"));
			if (invalidWord) {
				console.printf("That language is not allowed madafaka\n\n");
			}
		} while (invalidWord);
		console.printf("%s it's very %s\n", name, adjective );

	}
}