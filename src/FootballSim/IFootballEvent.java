package FootballSim;

/**
 * Interface representing time sensitive events
 * @author Rick
 *
 */
public interface IFootballEvent {
	
	/**
	 * Execute this event
	 * @param theGame passed into this function to grant access to field and timer objects
	 * @throws FootballException 
	 */
	public void executeEvent(FootballGame theGame) throws FootballException;
	
	/**
	 * @return the time when this event occurs (exits the timer queue)
	 */
	public int getTime();
}
