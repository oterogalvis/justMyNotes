import java.io.Console;
 
public class example_00 {
  
    public static void main(String[] args) {
        Console console = System.console();
        String firstName = console.readLine("What is your name?: ");
        console.printf("Hello, I'm %s\n", firstName);
  }
}