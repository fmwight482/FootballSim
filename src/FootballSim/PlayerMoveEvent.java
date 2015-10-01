package FootballSim;

/**
 * Class to handle player events where the player moves along the field
 * @author Rick
 *
 */
public class PlayerMoveEvent extends absFootballEvent implements IFootballEvent {
	FieldCoordinate oldCoord;
	FieldCoordinate newCoord;
	FootballPlayer player;
	
	public PlayerMoveEvent(int aTime, FieldCoordinate anOldCoord, FieldCoordinate aNewCoord, FootballPlayer aPlayer) {
		super(aTime);
		oldCoord = anOldCoord;
		newCoord = aNewCoord;
		player = aPlayer;
	}

	@Override
	public void executeEvent() {
		// TODO move player from oldCoord to newCoord
	}
}
