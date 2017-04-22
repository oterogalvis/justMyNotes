package example06;

// Java Objects => Delivering the MVP
class Hangman {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("You need to pass a word to start the game.");
			System.exit(0);
		}
		Game game = new Game(args[0]);
		Prompter prompter = new Prompter(game);
		prompter.play();
	}	
}