package example05;

import java.io.Console;

// This class is made to use other componets of the game through the console.
class Prompter {
	private Game mGame;

	public Prompter(Game game){
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