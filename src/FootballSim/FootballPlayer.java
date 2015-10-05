package FootballSim;

/**
 * Class to hold the information for football players
 * @author Rick
 *
 */
public class FootballPlayer {
	// will be expanded to include name, more attributes, etc
	private String pos;
	private int arm;
	private int speed;
	private int catching;
	private int firstStep;
	
	
	public FootballPlayer(String pPos) {
		pos = pPos;
	}
	
	/**
	 * copy constructor
	 * @param otherPlayer
	 */
	public FootballPlayer(FootballPlayer otherPlayer) {
		pos = otherPlayer.getPos();
		arm = otherPlayer.getArm();
		speed = otherPlayer.getSpeed();
		catching = otherPlayer.getCatching();
		firstStep = otherPlayer.getFirstStep();
	}
	
	/**
	 * gives a single character value to be displayed when printing the field. 
	 * currently rudementary and based entierly off of listed position
	 */
	public String toString() {
		String playerString = "?";
		if (pos == "QB") {
			playerString = "Q";
		}
		if (pos == "WR") {
			playerString = "W";
		}
		if (pos == "CB") {
			playerString = "C";
		}
		return playerString;
	}
	
	/**
	 * Calculate the effective speed of a player in milliseconds/yard. 
	 * This is the simplified speed calculation, using only the speed attribute. 
	 * getTimeToRunPath() is more complicated, using the first step attribute and 
	 * information from previous "steps" to make a more realistic estimate.
	 * <p>
	 * Assumptions/explanations: 
	 * <br>
	 * - As of 2015, 17 players had run a <= 4.30 second 40. The best time was 4.24 seconds. 
	 * As 0.06 seconds over 40 yards is negligible in-game, it seems reasonable to map 99 speed
	 * to a 4.30 second 40 time, which is 9.30 yards/sec and 107.5 msec/yard. 
	 * <br>
	 * - The worst time I can find from the 2015 combine is 5.74 seconds. It seems reasonable 
	 * to assume that no one at the combine would have earned a "0" attribute score for speed 
	 * or any other physical att, so I will round down and map 0 speed to a 6.00 second 40 
	 * time, which is 6.67 yards/sec and 150 msec/yard.
	 * <br>
	 * - Thus, the intended range is from 107.5 to 150 msec/yard. 150 - (42.5 * (att + 1)/100)
	 * is an adequate formula to capture that range, although that may be revisited.
	 * @return number of milliseconds necessary for this player to move one yard
	 */
	public double getBasicSpeed() {
		double basicSpeed = 150 - (42.5 * (speed + 1) / 100);
		return basicSpeed;
	}
	
	public double getTimeToRunPath(FieldCoordinate startPos) {
		return 0;
	}
	
	/**
	 * @return players arm attribute
	 */
	public int getArm() {
		return arm;
	}
	
	/**
	 * set players arm attribute
	 * @param arm
	 */
	public void setArm(int arm) {
		this.arm = arm;
	}
	
	/**
	 * @return players speed attribute
	 */
	public int getSpeed() {
		return speed;
	}
	
	/**
	 * set players speed attribute
	 * @param speed
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	/**
	 * @return players catching attribute
	 */
	public int getCatching() {
		return catching;
	}
	
	/**
	 * set players catching attribute
	 * @param catching
	 */
	public void setCatching(int catching) {
		this.catching = catching;
	}
	
	/**
	 * @return players first step attribute
	 */
	public int getFirstStep() {
		return firstStep;
	}
	
	/**
	 * set players first step attribute
	 * @param firstStep
	 */
	public void setFirstStep(int firstStep) {
		this.firstStep = firstStep;
	}
	
	/**
	 * @return the player's position
	 */
	public String getPos() {
		return pos;
	}
	
	/**
	 * set players position
	 * @param pos
	 */
	public void setPos(String pos) {
		this.pos = pos;
	}
	
	/**
	 * override of equals method.
	 * returns true if the player has the same position and all attributes, false otherwise. 
	 * will be expanded as more attributes and other variables are implemented. 
	 */
	public boolean equals(Object o) {
		boolean isEqual = false;
		if (o instanceof FootballPlayer) {
			FootballPlayer otherPlayer = new FootballPlayer((FootballPlayer)o);
			if (pos == otherPlayer.getPos() && speed == otherPlayer.getSpeed() &&
					arm == otherPlayer.getArm() && catching == otherPlayer.getCatching() &&
					firstStep == otherPlayer.getFirstStep()) {
				isEqual = true;
			}
		}
		return isEqual;
	}
	
	/**
	 * override of hashCode method
	 * like equals, uses all existing variables to compute hash
	 */
	public int hashCode() {
		int hash = 13;
		hash = (hash + pos.hashCode()) * 17;
		hash = (hash + arm) * 17;
		hash = (hash + speed) * 17;
		hash = (hash + catching) * 17;
		hash = (hash + firstStep) * 17;
		return hash;
	}
}
