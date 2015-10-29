package FootballSim;

/**
 * class denoting a movement of the football from one point on the field to another
 * @author Rick
 *
 */
public class BallMoveEvent extends absFootballEvent implements IFootballEvent {
	FieldCoordinate oldCoord;
	FieldCoordinate newCoord;

	public BallMoveEvent(int aTime, FieldCoordinate anOldCoord, FieldCoordinate aNewCoord) {
		super(aTime);
		oldCoord = anOldCoord;
		newCoord = aNewCoord;
	}
	
	@Override
	public void executeEvent(FootballGame theGame) {
		// TODO Auto-generated method stub
	}
}
