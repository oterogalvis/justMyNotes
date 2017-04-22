package example11.treeStory;

public class Main {

    public static void main(String[] args) {
        Prompter prompter = new Prompter();
        String story = prompter.promptForStory("Enter the story");
        Template tmpl = new Template(story);
        prompter.run(tmpl);
    }
}
