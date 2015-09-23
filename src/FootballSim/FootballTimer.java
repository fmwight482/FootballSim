package FootballSim;

import java.util.PriorityQueue;

public class FootballTimer {
	PriorityQueue<IFootballEvent> timer;
	int currentTime;
	
	public FootballTimer() {
		currentTime = 0;
		timer = new PriorityQueue<IFootballEvent>();
	}
	
	public IFootballEvent getNextEvent() {
		currentTime = timer.peek().getTime();
		return timer.poll();
	}
	
	public int getCurrentTime() {
		return currentTime;
	}
}
