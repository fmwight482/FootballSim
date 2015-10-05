package FootballSim;

/**
 * Class to hold the information for football players
 * @author Rick
 *
 */
public class FootballPlayer {
	// will be expanded to include name, more attributes, etc
	String pos;
	int arm;
	int speed;
	int catching;
	int firstStep;
	
	
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
