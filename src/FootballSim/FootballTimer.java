package FootballSim;

import java.util.PriorityQueue;

/**
 * Class to handle when time sensitive events occur in relation to each other
 * @author Rick
 *
 */
public class FootballTimer {
	PriorityQueue<IFootballEvent> timer;
	
	/**
	 * currentTime is the current simulated time in milliseconds. Note that this represents 
	 * "real time," not game time, and time as simulated by this class will continue to 
	 * "happen" even when the game clock is stopped (such as during a timeout or at the end 
	 * of a half). 
	 */
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
	
	/**
	 * set currentTime to the given value
	 * @param aTime
	 */
	public void setCurrentTime(int aTime) {
		currentTime = aTime;
	}
	
	/**
	 * Add the given event to the timer queue
	 * @param newEvent
	 */
	public void addEvent(IFootballEvent newEvent) {
		
	}
	
	/**
	 * @return the number of events in the timer queue
	 */
	public int getSize() {
		return timer.size();
	}
}
