import java.io.Console;

public class workspace {
	public static void main(String[] args){
		Console console = System.console();
		if (mypasta()){
			System.out.println("It's is UpperCase");
		} else{
			System.out.println("It's not upperCase");
		}
	}
	public static boolean mypasta(){
		String fieldName = "m_first_name";
		return Character.isLowerCase(fieldName.charAt(1));
	}
}
