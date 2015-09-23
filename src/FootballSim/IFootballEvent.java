package FootballSim;

// interface to 
public interface IFootballEvent {
	
	public void executeEvent();
	
	// return the time when this event occurs (exits the timer queue)
	public int getTime();
}
