package FootballSim;

/**
 * Class to hold vector coordinates representing individual steps in larger player movements 
 * and sort them by time indexes. Used as an intermediate step when creating PlayerMoveEvents. 
 * @author Rick
 *
 */
public class ComparableCoordinate extends FieldCoordinate implements Comparable<ComparableCoordinate> {
	/**
	 * The time the player would move to this coordinate. Value is accurate relative to other 
	 * steps but does not necessarily correspond to a "real" game time.
	 */
	int time;
	
	/**
	 * Standard constructor
	 * @param vert
	 * @param horz
	 * @param aTime
	 */
	public ComparableCoordinate(int vert, int horz, int aTime) {
		super(vert, horz);
		time = aTime;
	}
	
	public ComparableCoordinate(ComparableCoordinate otherCoordinate) {
		super(otherCoordinate.getVert(), otherCoordinate.getHorz());
		time = otherCoordinate.getTime();
	}
	
	public int getTime() {
		return time;
	}
	
	public FieldCoordinate getFieldCoordinate() {
		return new FieldCoordinate(vert, horz);
	}

	@Override
	public int compareTo(ComparableCoordinate otherCoord) {
		int comparison = 0;
		if (time < otherCoord.getTime()) {
			comparison = -1;
		}
		else if(time > otherCoord.getTime()) {
			comparison = 1;
		}
		return comparison;
	}
}
