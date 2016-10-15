import java.util.Date;
import com.teamtreehouse.Example_07_package;

class Example_07 {
	public static void main(String[] args) {
		Example_07_package treet = new Example_07_package(
			"Jorge Otero",
			"I'm becoming Gandalf",
			new Date(1421849732000L));
		System.out.printf("This is a new treet: %s %n", treet);
	}
}