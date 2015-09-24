package FootballSim;

public class BallMoveEvent extends absFootballEvent implements IFootballEvent {
	FieldCoordinate oldCoord;
	FieldCoordinate newCoord;

	public BallMoveEvent(int aTime, FieldCoordinate anOldCoord, FieldCoordinate aNewCoord) {
		super(aTime);
		oldCoord = anOldCoord;
		newCoord = aNewCoord;
	}
	
	@Override
	public void executeEvent() {
		// TODO Auto-generated method stub
	}
}
