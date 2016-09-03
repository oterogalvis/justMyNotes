import java.io.Console;

public class example_01 {
	public static void main(String[] args){
		Console console = System.console();
		String name = console.readLine("Enter your name: ");
		String adjective = console.readLine("Enter an adjective: ");
		console.printf("%s it's very %s\n", name, adjective );
	}
}