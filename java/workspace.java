import java.io.Console;

public class workspace {
	public static void main(String[] args){
		Console console = System.console();
		if (mypasta()){
			System.out.println("The char at 1 is not a letter.");
		} else{
			System.out.println("The char at 1 is a letter.");
		}
	}
	public static boolean mypasta(){
		String fieldName = "mfirst_name";
		return !Character.isLetter(fieldName.charAt(1));
	}
}
