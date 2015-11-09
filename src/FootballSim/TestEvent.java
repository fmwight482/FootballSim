package FootballSim;

public class TestEvent extends absFootballEvent implements IFootballEvent {
	
	public TestEvent(int time) {
		super(time);
	}

	@Override
	public void executeEvent(FootballGame theGame) throws FootballException {
		System.out.println("Executing test event!");
	}
}
