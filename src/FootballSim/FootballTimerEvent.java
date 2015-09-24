package FootballSim;

public class FootballTimerEvent extends absFootballEvent implements IFootballEvent {

	public FootballTimerEvent(int aTime) {
		super(aTime);
	}

	@Override
	public void executeEvent() {
		// TODO stop game clock
	}
	
}
