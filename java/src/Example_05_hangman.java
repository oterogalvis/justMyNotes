// Java Objects => Creating the MVP 
class Example_05_hangman {
	public static void main(String[] args) {
		Example_05_game game = new Example_05_game("treehouse");
		Example_05_prompter prompter = new Example_05_prompter(game);
		prompter.play();
	}	
}