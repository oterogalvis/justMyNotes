import java.io.Console;

// This class is made to use other componets of the game through the console.
class Example_06_prompter {
	private Example_06_game mGame;

	public Example_06_prompter(Example_06_game game){
		mGame = game;
	}
	
	public boolean promptForGuess(){
		Console console = System.console();
		boolean isHit = false;
		boolean isValidGuess = false;
		while (!isValidGuess){
			String guessAsString = console.readLine("Enter a letter: ");
			char guess = guessAsString.charAt(0);
			try{
				isHit = mGame.applyGuess(guess);
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
		while (mGame.getRemainingTries() > 0){
			displayProgress();
			promptForGuess();
		}
	}
}