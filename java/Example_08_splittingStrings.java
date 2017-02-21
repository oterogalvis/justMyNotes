import java.util.Arrays;
import java.io.Console;

public class Example_08_splittingStrings {

	private String example = "@how do we get each...  #of these words?";
	private String[] example_split_s = example.split(" ");
	// String[] example_split_s = [@how, do, we, get, each..., , #of, these, words?]
	private String[] example_split_w = example.split("\\w");
	// String[] example_split_w = [@, , ,  , ,  , ,  , , ,  , , , , ...  #, ,  , , , , ,  , , , , , ?]
	private String[] example_split_nw = example.split("[^\\w]");
	// String[] example_split_nw = [, how, do, we, get, each, , , , , , of, these, words]
	private String[] example_split_nws = example.split("[^\\w#@]");
	// String[] example_split_nws = [@how, do, we, get, each, , , , , #of, these, words]
	private String[] example_split_nwsp = example.split("[^\\w#@]+");
	// String[] example_split_nwsp = [@how, do, we, get, each, #of, these, words]
	
  	// How to return Arrays.
  	public String[] getWords() {
    	String[] wordsArray = example.split("\\s+");
    	return wordsArray; 
	}
}
