import java.io.Console;

// This class is made to use other componets of the game through the console.
class Example_05_prompter {
	private Example_05_game mGame;

	public Example_05_prompter(Example_05_game game){
		mGame = game;
	}
	
	public boolean promptForGuess(){
		Console console = System.console();
		String guessAsString = console.readLine("Enter a letter: ");
		char guess = guessAsString.charAt(0);
		return mGame.applyGuess(guess);
	}
	
	public void displayProgress() {
		System.out.printf("You have %d tries left to solve: %s\n", 
			mGame.getRemainingTries(),
			mGame.getCurrentProgress());
	}

	public void play(){
		while (mGame.getRemainingTries() > 0){
			displayProgress();
			promptForGuess();
		}
	}
}