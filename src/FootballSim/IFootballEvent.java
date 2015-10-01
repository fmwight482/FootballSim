package FootballSim;

/**
 * Interface representing time sensitive events
 * @author Rick
 *
 */
public interface IFootballEvent {
	
	public void executeEvent();
	
	/**
	 * @return the time when this event occurs (exits the timer queue)
	 */
	public int getTime();
}
