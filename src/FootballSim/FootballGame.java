package FootballSim;

public class FootballGame {
	public Field fbField;
	public FootballTimer fbTimer;
	FootballPlayer QB;
	FootballPlayer WR;
	
	// constructor with pre-built players for debugging convenience
	public FootballGame() {
		fbField = new Field();
		fbTimer = new FootballTimer();
		QB = new FootballPlayer("QB");
		WR = new FootballPlayer("WR");
	}
	
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
