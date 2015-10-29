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
	public void executeEvent(FootballGame theGame) {
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
