package example03;

public class Pez {
	public static void main(String[] args) {
		System.out.println("We are making a new pez dispenser.	");
		PezDispenser dispenser = new PezDispenser("Vergil");
		System.out.printf("The dispenser caracter is: %s\n", dispenser.getCaracterName());
	}
}