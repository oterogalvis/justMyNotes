import java.io.Console;

public class workspace {
	public static void main(String[] args){
		Console console = System.console();
		String code = "repead";
		String answer;
		do {
			answer = console.readLine("What is de code? :");
		} while (answer.equals(code));
	}
}