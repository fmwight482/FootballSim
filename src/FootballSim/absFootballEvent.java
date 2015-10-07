package FootballSim;

/**
 * Abstract class representing time sensitive events.
 * 
 * Class has overriden compareTo but NOT equals, as the comparison value (time) 
 * is not sufficient to determine equality
 * @author Rick
 *
 */
public abstract class absFootballEvent implements Comparable<absFootballEvent> {
	int time;
	
	public absFootballEvent(int aTime) {
		time = aTime;
	}
	
	public int getTime() {
		return time;
	}
	
	/**
	 * override of compareTo. Compares events based off of their times. This is explicitly less 
	 * sophisticated than the comparisons made in overrides of equals function. 
	 */
	public int compareTo(absFootballEvent anEvent) {
		int comparison;
		
		int otherTime = anEvent.getTime();
		if (otherTime < time) {
			comparison = -1;
		}
		else if (otherTime > time) {
			comparison = 1;
		}
		else {
			comparison = 0;
		}
		
		return comparison;
	}
}
