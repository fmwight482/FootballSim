package FootballSim;

/**
 * Class denoting a location on a FootballField
 * @author Rick
 *
 */
public class FieldCoordinate {
	int vert;
	int horz;
	
	public FieldCoordinate(int v, int h) {
		vert = v;
		horz = h;
	}
	
	public FieldCoordinate(FieldCoordinate aCoord) {
		vert = aCoord.getVert();
		horz = aCoord.getHorz();
	}
	
	/**
	 * constructs a new coordinate by combining two other coordinates
	 * forces new coordinate to remain within the bounds of the field. 
	 * @param coord1
	 * @param coord2 (usually a vector)
	 */
	public FieldCoordinate(FieldCoordinate coord1, FieldCoordinate coord2) throws FootballException {
		vert = coord1.getVert() + coord2.getVert();
		horz = coord1.getHorz() + coord2.getHorz();
		
		checkCoords();
	}
	
	/**
	 * constrain coordinates to within a range of 0-119 for vert and 0-52 for horz
	 * @throws FootballException
	 */
	private void checkCoords() throws FootballException {
		if (vert >= 120) {
			throw new FootballException("vert value of " + vert + " is greater than 119");
		}
		else if (vert < 0) {
			throw new FootballException("vert value of " + vert + " is less than 0");
		}
		if (horz >= 53) {
			throw new FootballException("vert value of " + horz + " is greater than 52");
		}
		else if (horz < 0) {
			throw new FootballException("vert value of " + horz + " is less than 0");
		}
	}
	
	public int getVert() {
		return vert;
	}
	
	public int getHorz() {
		return horz;
	}
	
	/**
	 * 
	 * @param otherCoord
	 * @return the distance between this coordinate and the given coordinate
	 */
	public double getDistBetween(FieldCoordinate otherCoord) {
		double dist = Math.sqrt(Math.pow(getVert() - otherCoord.getVert(), 2) + 
				Math.pow(getHorz() - otherCoord.getHorz(), 2));
		return dist;
	}
	
	/**
	 * override of equals method, compares vert and horz values
	 */
	public boolean equals(Object o) {
		boolean isEqual = false;
		if (o instanceof FieldCoordinate) {
			FieldCoordinate otherCoord = ((FieldCoordinate)o);
			if (otherCoord.getVert() == getVert() &&
					otherCoord.getHorz() == getHorz()) {
				isEqual = true;
			}
		}
		
		return isEqual;
	}
	
	/**
	 * override of hashCode
	 */
	public int hashCode() {
		int hash = 13;
		hash = (hash + getVert()) * 17;
		hash = (hash + getHorz()) * 17;
		
		return hash;
	}
	
	/**
	 * override of toString, returns coordinate pair in standard (x, y) notation.
	 */
	public String toString() {
		return "(" + getVert() + ", " + getHorz() + ")";
	}
}
