import com.teamtreehouse.Example_07_package;
import java.util.Date;

class Example_07_typecasting {
	public Example_07_typecasting() {
		Example_07_package treet = new Example_07_package("","", new Date());

	//	Upcasting or casting up to the inheritance
		Object obj = treet;


	//	Downcasting or casting down to the inheritance
		Example_07_package another = (Example_07_package) obj;


		Object[] someStuff = {treet, "a string"};
		((Example_07_package) someStuff[0]).getDescription();
	//	((Example_07_package) someStuff[1]).getDescription();

		if( someStuff[0] instanceof Example_07_package) {
			System.out.println("someStuff[0] is a Example_07_package");
		} else {System.out.println("someStuff[0] is not a Example_07_package");}

		if( someStuff[1] instanceof Example_07_package) {
			System.out.println("someStuff[1] is a Example_07_package");
		} else {System.out.println("someStuff[1] is not a Example_07_package");}
	}
}