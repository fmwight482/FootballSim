package FootballSim;

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
