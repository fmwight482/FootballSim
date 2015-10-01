package FootballSim;

/**
 * 
 * @author Rick
 * Plays football games and outputs results to the command line
 */
public class FootballGameRunner {
	static FootballGame game = new FootballGame();

	public static void main(String[] args) {
		game.fbField.printField();
	}
}
