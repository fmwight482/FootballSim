package FootballSim;

/**
 * Class to handle player events where the player moves along the field
 * @author Rick
 *
 */
public class PlayerMoveEvent extends absFootballEvent implements IFootballEvent {
	private FieldCoordinate oldCoord;
	private FieldCoordinate newCoord;
	private FootballPlayer player;
	
	public PlayerMoveEvent(int aTime, FieldCoordinate anOldCoord, FieldCoordinate aNewCoord, FootballPlayer aPlayer) {
		super(aTime);
		setOldCoord(anOldCoord);
		setNewCoord(aNewCoord);
		setPlayer(aPlayer);
	}

	@Override
	public void executeEvent() {
		// TODO move player from oldCoord to newCoord
	}
	
	public FieldCoordinate getOldCoord() {
		return oldCoord;
	}

	public void setOldCoord(FieldCoordinate anOldCoord) {
		oldCoord = new FieldCoordinate(anOldCoord);
	}

	public FieldCoordinate getNewCoord() {
		return newCoord;
	}

	public void setNewCoord(FieldCoordinate aNewCoord) {
		newCoord = new FieldCoordinate(aNewCoord);
	}

	public FootballPlayer getPlayer() {
		return player;
	}

	public void setPlayer(FootballPlayer aPlayer) {
		player = new FootballPlayer(aPlayer);
	}

	public boolean equals(Object o) {
		return false;
	}
}
