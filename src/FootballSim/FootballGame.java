package FootballSim;

/**
 * Class containing the core components of a football game (the field and timer). 
 * Also responsible for executing higher level actions on the field.
 * @author Rick
 *
 */
public class FootballGame {
	public Field fbField;
	public FootballTimer fbTimer;
	
	/*
	 * Temporary player "slots" for ease of use.
	 * players will likely be taken from a roster object in the final product.
	 */
	FootballPlayer QB;
	FootballPlayer WR;
	
	/**
	 * constructor with pre-built players for debugging convenience
	 */
	public FootballGame() {
		fbField = new Field();
		fbTimer = new FootballTimer();
		QB = new FootballPlayer("QB");
		WR = new FootballPlayer("WR");
	}
	
	/**
	 * Makes the given reciever "run" the given route from startPos
	 * @param startPos
	 * @param aRoute
	 * @param reciever
	 * @throws FootballException
	 */
	public void runRoute(FieldCoordinate startPos, Route aRoute, FootballPlayer reciever) 
			throws FootballException {
		FieldCoordinate currentPos = startPos;
		FieldCoordinate targetPos;
		while (aRoute.countSteps() > 0) {
			targetPos = new FieldCoordinate(currentPos, aRoute.getNextStep());
			fbField.movePlayer(currentPos, targetPos);
			currentPos = new FieldCoordinate(targetPos);
		}
	}
}
