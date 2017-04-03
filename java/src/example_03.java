import java.io.Console;

public class example_03 {
	public static void main(String[] args) {
		System.out.println("We are making a new pez dispenser.	");
		example_03_class dispenser = new example_03_class("Vergil");
		System.out.printf("The dispenser caracter is: %s\n", dispenser.getCaracterName());
	}
}