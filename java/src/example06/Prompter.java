package example06;

import java.io.Console;
// This class is made to use other componets of the game through the console.
class Prompter {
	private Game mGame;

	public Prompter(Game game){
		mGame = game;
	}
	
	public boolean promptForGuess(){
		Console console = System.console();
		boolean isHit = false;
		boolean isValidGuess = false;
		while (!isValidGuess){
			String guessAsString = console.readLine("Enter a letter: ");
			try{
				isHit = mGame.applyGuess(guessAsString);
				isValidGuess = true;
			}catch (IllegalArgumentException iae){
				console.printf("%s. Please try again.\n", iae.getMessage());
			}
		}
		return isHit;
	}
	
	public void displayProgress() {
		System.out.printf("You have %d tries left to solve: %s\n", 
			mGame.getRemainingTries(),
			mGame.getCurrentProgress());
	}

	public void play(){
		while (mGame.getRemainingTries() > 0 && !mGame.isSolve()){
			displayProgress();
			promptForGuess();
		}
		if (mGame.isSolve()){
			System.out.printf("Congratulations you won with %d tries remaining.\n", 
				mGame.getRemainingTries());
		} else {
			System.out.printf("Bummer the word was %s.\n", mGame.getAnswer());
		}
	}
}