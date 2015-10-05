package FootballSim;

import java.util.PriorityQueue;

/**
 * Class to handle when time sensitive events occur in relation to each other
 * @author Rick
 *
 */
public class FootballTimer {
	PriorityQueue<IFootballEvent> timer;
	int currentTime;
	
	public FootballTimer() {
		currentTime = 0;
		timer = new PriorityQueue<IFootballEvent>();
	}
	
	/**
	 * @return the next event in the queue
	 */
	public IFootballEvent getNextEvent() {
		currentTime = timer.peek().getTime();
		return timer.poll();
	}
	
	/**
	 * @return the current time
	 */
	public int getCurrentTime() {
		return currentTime;
	}
}
