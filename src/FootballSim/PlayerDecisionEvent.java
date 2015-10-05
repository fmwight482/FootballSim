package FootballSim;

/**
 * Class to handle player events which are not movement along the field
 * Ex: reading an opposing player, going through progressions, reaction times
 * @author Rick
 *
 */
public class PlayerDecisionEvent extends absFootballEvent implements IFootballEvent {
	FootballPlayer player;
	// TODO add a variable to denote appropriate actions
	
	public PlayerDecisionEvent(int aTime, FootballPlayer aPlayer) {
		super(aTime);
		player = aPlayer;
	}

	@Override
	public void executeEvent() {
		// TODO take an appropriate action
	}

}
