package FootballSim;

public abstract class absFootballEvent implements Comparable {
	int time;
	
	public absFootballEvent(int aTime) {
		time = aTime;
	}
	
	public int getTime() {
		return time;
	}
	
	public int compareTo(Object o) {
		int comparison = 0;
		
		if (o instanceof absFootballEvent) {
			int otherTime = ((absFootballEvent)o).getTime();
			if (otherTime < time) {
				comparison = -1;
			}
			else if (otherTime > time) {
				comparison = 1;
			}
		}
		else {
				try {
					throw new FootballException("Cannot compare absFooballEvent to a " + o.getClass());
				} 
				catch (FootballException e) {
					e.printStackTrace();
				}
		}
		return comparison;
	}
}
