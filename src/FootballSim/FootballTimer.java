package FootballSim;

import java.util.PriorityQueue;

public class FootballTimer {
	PriorityQueue<IFootballEvent> timer;
	
	public FootballTimer() {
		timer = new PriorityQueue<IFootballEvent>();
	}
}
