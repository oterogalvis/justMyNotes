// Java Objects => Delivering the MVP 
class Example_06_hangman {
	public static void main(String[] args) {
		Example_06_game game = new Example_06_game("treehouse");
		Example_06_prompter prompter = new Example_06_prompter(game);
		prompter.play();
	}	
}