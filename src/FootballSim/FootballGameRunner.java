package FootballSim;

/**
 * Plays football games and outputs results to the command line
 * @author Rick
 * 
 */
public class FootballGameRunner {
	static FootballGame game = new FootballGame();

	public static void main(String[] args) {
		game.fbField.printField();
	}
}
