package FootballSim;

public abstract class absFootballEvent implements Comparable<absFootballEvent> {
	int time;
	
	public absFootballEvent(int aTime) {
		time = aTime;
	}
	
	public int getTime() {
		return time;
	}
	
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
