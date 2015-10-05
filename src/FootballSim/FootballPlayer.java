package FootballSim;

/**
 * Class to hold the information for football players
 * @author Rick
 *
 */
public class FootballPlayer {
	// will be expanded to include name, more attributes, etc
	int arm;
	int speed;
	int catching;
	String pos;
	
	
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
	
	public int getArm() {
		return arm;
	}
	
	public void setArm(int arm) {
		this.arm = arm;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getCatching() {
		return catching;
	}
	
	public void setCatching(int catching) {
		this.catching = catching;
	}
	
	public String getPos() {
		return pos;
	}
	
	public void setPos(String pos) {
		this.pos = pos;
	}
	
	public boolean equals(Object o) {
		boolean isEqual = false;
		if (o instanceof FootballPlayer) {
			FootballPlayer otherPlayer = new FootballPlayer((FootballPlayer)o);
			if (pos == otherPlayer.getPos() && speed == otherPlayer.getSpeed() &&
					arm == otherPlayer.getArm() && catching == otherPlayer.getCatching()) {
				isEqual = true;
			}
		}
		return isEqual;
	}
	
	public int hashCode() {
		int hash = 13;
		hash = (hash + pos.hashCode()) * 17;
		hash = (hash + arm) * 17;
		hash = (hash + speed) * 17;
		hash = (hash + catching) * 17;
		return hash;
	}
}
