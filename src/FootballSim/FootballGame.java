package FootballSim;

import java.util.PriorityQueue;

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
	 * Generates a list of single-tile movements required for the player to run the given route, 
	 * as well as the times at which they will reach each tile, and adds them to the timer queue.
	 * @param startPos
	 * @param aRoute
	 * @param aPlayer
	 * @throws FootballException
	 */
	public void simpleRunRoute(FieldCoordinate startPos, Route aRoute, FootballPlayer aPlayer, 
			int currentTime) throws FootballException {
		FieldCoordinate currentPos = startPos;
		FieldCoordinate targetPos;
		double distBetween;
		double vertDistBetween;
		double horzDistBetween; 
		int movementTime;
		
		while (aRoute.countSteps() > 0) {
			targetPos = new FieldCoordinate(currentPos, aRoute.getNextStep());
			distBetween = currentPos.getDistBetween(targetPos);
			vertDistBetween = currentPos.getVertDistBetween(targetPos);
			horzDistBetween = currentPos.getHorzDistBetween(targetPos);
			movementTime = (int)(aPlayer.getBasicSpeed() * distBetween);
		}
	}
	
	/**
	 * 
	 * @param movementTime
	 * @param vertDistBetween
	 * @param horzDistBetween
	 * @return a playerMoveEvent with 
	 */
	private PlayerMoveEvent getPlayerMoveEvent(int movementTime, double vertDistBetween, double horzDistBetween) {
		int vertMsecPerYard = (int)(movementTime/vertDistBetween);
		int horzMsecPerYard = (int)(movementTime/horzDistBetween);
		int vertSign = (int)(vertDistBetween/Math.abs(vertDistBetween));
		int horzSign = (int)(horzDistBetween/Math.abs(horzDistBetween));
		
		PriorityQueue<ComparableCoordinate> steps = new PriorityQueue<ComparableCoordinate>();
		Route finishedSteps = new Route();
		PlayerMoveEvent move;
		for (int x=0; x<movementTime; x+=vertMsecPerYard) {
			steps.add(new ComparableCoordinate(vertSign, 0, x));
		}
		for (int y=0; y<movementTime; y+=horzMsecPerYard) {
			steps.add(new ComparableCoordinate(0, horzSign, y));
		}
		for (ComparableCoordinate step : steps) {
			finishedSteps.addStep(step);
		}
		return move;
	}
}
