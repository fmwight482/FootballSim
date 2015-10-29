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
	private Route route;
	
	/**
	 * standard constructor for PlayerMoveEvent class
	 * @param aTime
	 * @param anOldCoord
	 * @param aRoute
	 * @param aPlayer
	 */
	public PlayerMoveEvent(int aTime, FieldCoordinate anOldCoord, Route aRoute, FootballPlayer aPlayer) 
			throws FootballException {
		super(aTime);
		setRoute(aRoute);
		setOldCoord(anOldCoord);
		setNewCoord(new FieldCoordinate(route.getNextStep(), anOldCoord));
		setPlayer(aPlayer);
	}
	
	/**
	 * copy constructor for PlayerMoveEvent class
	 * @param anEvent
	 */
	public PlayerMoveEvent(PlayerMoveEvent anEvent) {
		super(anEvent.getTime());
		setOldCoord(anEvent.getOldCoord());
		setNewCoord(anEvent.getNewCoord());
		setPlayer(anEvent.getPlayer());
		setRoute(anEvent.getRoute());
	}
	
	@Override
	public void executeEvent(FootballGame theGame) throws FootballException {
		if (theGame.fbField.getPlayerNumAt(oldCoord) != 0) {
			if (theGame.fbField.getPlayerAt(oldCoord).equals(player)) {
				theGame.fbField.movePlayer(oldCoord, newCoord);
				setOldCoord(newCoord);
				setNewCoord(new FieldCoordinate(route.getNextStep(), oldCoord));
			}
			else {
				throw new FootballException("Coordinates " + oldCoord + " are occupied by player " + 
						theGame.fbField.getPlayerAt(oldCoord) + ", not " + player);
			}
		}
		else {
			throw new FootballException("No player at coordinates " + oldCoord);
		}
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
	
	public Route getRoute() {
		return route;
	}

	public void setRoute(Route aRoute) {
		route = new Route(aRoute);
	}

	public boolean equals(Object o) {
		return false;
	}
}
