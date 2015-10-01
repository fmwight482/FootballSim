package FootballSim;

/**
 * An exception thrown for football related issues
 * @author Rick
 *
 */
public class FootballException extends Exception {
	private static final long serialVersionUID = 7040983772447822829L;

	public FootballException() {
		
	}
	
	public FootballException(String message) {
		System.err.println(message);
	}
}
