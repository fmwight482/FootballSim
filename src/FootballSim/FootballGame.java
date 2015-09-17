package FootballSim;

public class FootballGame {
	public Field fbField;
	FootballPlayer QB;
	FootballPlayer WR;
	
	public FootballGame() {
		fbField = new Field();
		QB = new FootballPlayer("QB");
		WR = new FootballPlayer("WR");
	}
	
	public void runRoute(FieldCoordinate startPos, Route aRoute, FootballPlayer reciever) {
		FieldCoordinate currentPos = startPos;
		FieldCoordinate targetPos;
		while (aRoute.countSteps() > 0) {
			targetPos = new FieldCoordinate(currentPos, aRoute.getNextStep());
			fbField.movePlayer(currentPos, targetPos);
			currentPos = new FieldCoordinate(targetPos);
		}
	}
}
