package example07;

import example07.com.teamtreehouse.Treet;

import java.util.Date;

class LearningTypeCasting {
	public LearningTypeCasting() {
		Treet treet = new Treet("","", new Date());

	//	Upcasting or casting up to the inheritance
		Object obj = treet;


	//	Downcasting or casting down to the inheritance
		Treet another = (Treet) obj;


		Object[] someStuff = {treet, "a string"};
		((Treet) someStuff[0]).getDescription();
	//	((Treet) someStuff[1]).getDescription();

		if( someStuff[0] instanceof Treet) {
			System.out.println("someStuff[0] is a Treet");
		} else {System.out.println("someStuff[0] is not a Treet");}

		if( someStuff[1] instanceof Treet) {
			System.out.println("someStuff[1] is a Treet");
		} else {System.out.println("someStuff[1] is not a Treet");}
	}
}