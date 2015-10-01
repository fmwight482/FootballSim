package FootballSim;

/**
 * Class to handle events related to the game clock (2 minute warning, end of half, etc)
 * @author Rick
 *
 */
public class FootballTimerEvent extends absFootballEvent implements IFootballEvent {

	public FootballTimerEvent(int aTime) {
		super(aTime);
	}

	@Override
	public void executeEvent() {
		// TODO stop game clock
	}
	
}
