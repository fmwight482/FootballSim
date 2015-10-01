package FootballSim;

public class FootballPlayer {
	int arm;
	int speed;
	int catching;
	String pos;
	
	
	public FootballPlayer(String pPos) {
		pos = pPos;
	}
	
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
}
