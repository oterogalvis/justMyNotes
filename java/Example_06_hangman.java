// Java Objects => Delivering the MVP 
class Example_06_hangman {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("You need to pass a word to start the game.");
			System.exit(0);
		}
		Example_06_game game = new Example_06_game(args[0]);
		Example_06_prompter prompter = new Example_06_prompter(game);
		prompter.play();
	}	
}