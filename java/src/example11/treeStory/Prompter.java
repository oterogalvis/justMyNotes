package example11.treeStory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Prompter {
    private BufferedReader mReader;
    private Set<String> mCensoredWords;

    public Prompter() {
        mReader = new BufferedReader(new InputStreamReader(System.in));
        loadCensoredWords();
    }

    private void loadCensoredWords() {
        mCensoredWords = new HashSet<String>();
        Path file = Paths.get("src/example11/treeStory/", "censored_words.txt");
        List<String> words = null;
        try {
            words = Files.readAllLines(file);
        } catch (IOException e) {
            System.out.println("Couldn't load censored words");
            e.printStackTrace();
        }
        mCensoredWords.addAll(words);
    }

    public void run(Template tmpl) {
        List<String> results = null;
        try {
            results = promptForWords(tmpl);
        } catch (IOException e) {
            System.out.println("There was a problem prompting for words");
            e.printStackTrace();
            System.exit(0);
        }
        String render = tmpl.render(results);
        System.out.printf("Your TreeStory:%n%n%s", render);
    }

    /**
     * Prompts user for each of the blanks
     *
     * @param tmpl The compiled template
     * @return
     * @throws IOException
     */
    public List<String> promptForWords(Template tmpl) throws IOException {
        List<String> words = new ArrayList<String>();
        for (String phrase : tmpl.getPlaceHolders()) {
            String word = promptForWord(phrase);
            words.add(word);
        }
        return words;
    }


    /**
     * Prompts the user for the answer to the fill in the blank.  Value is guaranteed to be not in the censored words list.
     *
     * @param phrase The word that the user should be prompted.  eg: adjective, proper noun, name
     * @return What the user responded
     */
    public String promptForWord(String phrase) {
        System.out.printf("Introduce %s: ", phrase);
        String readLine = "";
        try {
            readLine = mReader.readLine();
        } catch (IOException e) {
            System.out.printf("Problem getting input. %s\n", e.getMessage());
        }
        for (String censuredWord : mCensoredWords) {
            if (readLine.equals(censuredWord)) {
                System.out.printf("That word in censored. please try again.\n");
                readLine = promptForWord(phrase);
            }
        }
        return readLine;
    }

    public String promptForStory(String askForStory) {
        System.out.printf("%s : ", askForStory);
        String readLine = "";
        try {
            readLine = mReader.readLine();
        } catch (IOException e) {
            System.out.printf("Problem getting input. %s\n", e.getMessage());
        }
        return readLine;
    }
}
